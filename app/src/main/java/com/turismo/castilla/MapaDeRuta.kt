package com.turismo.castilla

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions


class MapaDeRuta : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var buttonDondeSale: Button
    private lateinit var textViewTitulo: TextView
    private var googleMap: GoogleMap? = null
    private var geoinicioLatitude: Double? = null
    private var geoinicioLongitude: Double? = null
    private var geofinalLatitude: Double? = null
    private var geofinalLongitude: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_de_ruta)


        mapView = findViewById(R.id.mapView)
        buttonDondeSale = findViewById(R.id.buttonDondeSale)
        textViewTitulo = findViewById(R.id.textViewTituloMapa)

        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        val inicio = intent.getStringExtra("inicio") ?: ""
        val fin = intent.getStringExtra("fin") ?: ""

        geoinicioLatitude = intent.getDoubleExtra("geoinicio_latitude", Double.NaN)
        geoinicioLatitude = if (geoinicioLatitude?.isNaN() == true) null else geoinicioLatitude

        geoinicioLongitude = intent.getDoubleExtra("geoinicio_longitude", Double.NaN)
        geoinicioLongitude = if (geoinicioLongitude?.isNaN() == true) null else geoinicioLongitude

        geofinalLatitude = intent.getDoubleExtra("geofinal_latitude", Double.NaN)
        geofinalLatitude = if (geofinalLatitude?.isNaN() == true) null else geofinalLatitude

        geofinalLongitude = intent.getDoubleExtra("geofinal_longitude", Double.NaN)
        geofinalLongitude = if (geofinalLongitude?.isNaN() == true) null else geofinalLongitude

        textViewTitulo.text = "Ruta: $inicio - $fin"

        buttonDondeSale.setOnClickListener {
            // Implementar la lógica para "Donde Sale"
            // Esto podría involucrar obtener la ubicación actual del usuario
            // y mostrarla en el mapa.
        }

    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Añadir marcador de inicio
        if (geoinicioLatitude != null && geoinicioLongitude != null) {
            val inicioLatLng = LatLng(geoinicioLatitude!!, geoinicioLongitude!!)
            googleMap?.addMarker(MarkerOptions().position(inicioLatLng).title("Inicio"))
        }

        // Añadir marcador de fin
        if (geofinalLatitude != null && geofinalLongitude != null) {
            val finLatLng = LatLng(geofinalLatitude!!, geofinalLongitude!!)
            googleMap?.addMarker(MarkerOptions().position(finLatLng).title("Final"))

            // Si no se ha movido la camara al inicio, lo hace al final
            if (geoinicioLatitude == null || geoinicioLongitude == null){
                googleMap?.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(finLatLng, 15f)) // Zoom level
            }
        }

        // Dibujar la línea
        if (geoinicioLatitude != null && geoinicioLongitude != null && geofinalLatitude != null && geofinalLongitude != null) {
            val inicioLatLng = LatLng(geoinicioLatitude!!, geoinicioLongitude!!)
            val finLatLng = LatLng(geofinalLatitude!!, geofinalLongitude!!)

            val polylineOptions = PolylineOptions()
                .add(inicioLatLng, finLatLng)
                .color(ContextCompat.getColor(this, R.color.ruta_line_color)) // Usa un color de resources
                .width(5f)  // Ancho de la línea

            googleMap?.addPolyline(polylineOptions)
            // Mover la camara al inicio
            googleMap?.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(inicioLatLng, 15f))
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}