package com.turismo.castilla

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class Pruebas : AppCompatActivity() {

    lateinit var googleMap:GoogleMap
    lateinit var mapFragment:SupportMapFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pruebas)

        var mapacorde=intent.getStringExtra("mapa")
        var mapacorde2=intent.getStringExtra("mapa2")
        var foto= intent.getStringExtra("imagen1")
        var nombre=intent.getStringExtra("namehotel")

        var textoname= findViewById<TextView>(R.id.textodes)
        var imagedes = findViewById<ImageView>(R.id.fotodes)

        textoname.text= nombre.toString()

        Glide.with(this).load(foto.toString())
            .into(imagedes)

        mapFragment=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap= it
            val  location1 = LatLng(mapacorde.toString().toDouble(), mapacorde2.toString().toDouble())
            googleMap.addMarker(MarkerOptions().position(location1).title(nombre.toString()))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,18f))

        })

    }


}