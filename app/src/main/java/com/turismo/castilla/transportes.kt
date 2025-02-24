package com.turismo.castilla

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class transportes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transportes)

        val mototaxisImageView: ImageView = findViewById(R.id.tmototaxis)
        val taxisImageView: ImageView = findViewById(R.id.ttaxi) // Usando el ID correcto
        val combisImageView: ImageView = findViewById(R.id.tcombis)

        mototaxisImageView.setOnClickListener {
            startDetTransporteActivity("mototaxi")
        }

        taxisImageView.setOnClickListener {
            startDetTransporteActivity("taxi")
        }

        combisImageView.setOnClickListener {
            startRutaCombiActivity() // Inicia la actividad RutaCombi
        }


        // Puedes agregar OnClickListeners para los otros tipos de transporte


    }

    private fun startDetTransporteActivity(collectionName: String) {
        val intent = Intent(this, det_transporte::class.java)
        intent.putExtra("collection", collectionName)
        startActivity(intent)
    }

    private fun startRutaCombiActivity() {
        val intent = Intent(this, RutaCombiCastilla::class.java)
        startActivity(intent)
    }


}