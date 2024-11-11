package com.turismo.castilla

import android.Manifest
import android.animation.ValueAnimator
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlay
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.firestore
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.*
import android.location.Location
import com.google.firebase.firestore.ktx.firestore

class mapasereno : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private var groundOverlay: GroundOverlay? = null
    private val firestore: FirebaseFirestore = Firebase.firestore
    private var firestoreListener: ListenerRegistration? = null
    private lateinit var overlayIcon: BitmapDescriptor
    private var latLngAnimator: ValueAnimator? = null
    private lateinit var statusTextView: TextView

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private var lastPosition: LatLng? = null
    private var stationaryTime = 0L
    private val stationaryThresholdTime = 10000L // 10 segundos sin movimiento
    private val distanceThreshold = 5 // Umbral de distancia en metros para considerar movimiento
    private val locationPermissionRequestCode = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapasereno)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        statusTextView = findViewById(R.id.statusTextView)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        overlayIcon = loadOverlayIcon(R.drawable.car_icon)

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val location = locationResult.lastLocation ?: return
                handleLocationUpdate(LatLng(location.latitude, location.longitude))
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionRequestCode)
        } else {
            startLocationUpdates()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        setupFirebaseListener()
    }

    private fun setupFirebaseListener() {
        firestoreListener = firestore.collection("sereno").document("sereno1")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    e.printStackTrace()
                    return@addSnapshotListener
                }

                if (snapshot != null && snapshot.exists()) {
                    val location = snapshot.getGeoPoint("location")
                    if (location != null) {
                        handleLocationUpdate(LatLng(location.latitude, location.longitude))
                    } else {
                        println("Error: La ubicación no está disponible en el documento.")
                    }
                } else {
                    println("Error: El documento 'sereno1' no existe en Firestore.")
                }
            }
    }

    private fun handleLocationUpdate(newLatLng: LatLng) {
        if (lastPosition != null && isStationary(lastPosition!!, newLatLng)) {
            stationaryTime += 5000
            if (stationaryTime >= stationaryThresholdTime) {
                updateStatusText("SERENO ESTACIONADO")
                stationaryTime = 0L
            }
        } else {
            stationaryTime = 0L
            updateStatusText("SERENO EN MOVIMIENTO")
        }

        lastPosition = newLatLng
        updateMapLocation(newLatLng)

        firestore.collection("sereno").document("sereno1")
            .update("location", com.google.firebase.firestore.GeoPoint(newLatLng.latitude, newLatLng.longitude))
            .addOnFailureListener { e -> println("Error al actualizar la ubicación: ${e.message}") }
    }

    private fun isStationary(lastPosition: LatLng, newPosition: LatLng): Boolean {
        val distance = FloatArray(1)
        Location.distanceBetween(
            lastPosition.latitude,
            lastPosition.longitude,
            newPosition.latitude,
            newPosition.longitude,
            distance
        )
        return distance[0] < distanceThreshold
    }

    private fun updateStatusText(status: String) {
        runOnUiThread {
            statusTextView.text = "Estado: $status"
        }
    }

    private fun updateMapLocation(newLatLng: LatLng) {
        if (groundOverlay == null) {
            groundOverlay = mMap.addGroundOverlay(
                GroundOverlayOptions()
                    .image(overlayIcon)
                    .position(newLatLng, 50f)
            )
        } else {
            animateOverlayPosition(groundOverlay!!, newLatLng)
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(newLatLng, 18f))
    }

    private fun animateOverlayPosition(overlay: GroundOverlay, newPosition: LatLng) {
        latLngAnimator?.cancel()

        val startLatLng = overlay.position
        latLngAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            addUpdateListener { animation ->
                val fraction = animation.animatedFraction
                val lat = startLatLng.latitude + (newPosition.latitude - startLatLng.latitude) * fraction
                val lng = startLatLng.longitude + (newPosition.longitude - startLatLng.longitude) * fraction
                overlay.position = LatLng(lat, lng)
            }
            start()
        }
    }

    private fun loadOverlayIcon(resourceId: Int): BitmapDescriptor {
        val originalIcon = BitmapFactory.decodeResource(resources, resourceId)
        val scaledIcon = Bitmap.createScaledBitmap(originalIcon, 80, 80, false)
        return BitmapDescriptorFactory.fromBitmap(scaledIcon)
    }

    private fun startLocationUpdates() {
        val locationRequest = LocationRequest.create().apply {
            interval = 5000
            fastestInterval = 2000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, mainLooper)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionRequestCode && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startLocationUpdates()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        firestoreListener?.remove()
        latLngAnimator?.cancel()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }
}