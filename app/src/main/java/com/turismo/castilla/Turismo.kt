package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Turismo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turismo)

        /*
        val bdinosaurio=findViewById<Button>(R.id.button_dinosaurio)
        val bcastillo=findViewById<Button>(R.id.button_castillo)
        val brostro=findViewById<Button>(R.id.button_rostro)
        val bciclismo=findViewById<Button>(R.id.button_ciclismo)
        val bcanotaje=findViewById<Button>(R.id.button_canotaje)
        val bcabalgata=findViewById<Button>(R.id.button_cabalgatas)

        bcabalgata.setOnClickListener{
            val lanzarcabal= Intent(this,DescriTurismo::class.java)
            lanzarcabal.putExtra("turi","cabalgata")
            startActivity(lanzarcabal)
        }

        bcanotaje.setOnClickListener{
            val lanzarcano= Intent(this,DescriTurismo::class.java)
            lanzarcano.putExtra("turi","canotaje")
            startActivity(lanzarcano)
        }

        bciclismo.setOnClickListener{
            val lanzarcicli= Intent(this,DescriTurismo::class.java)
            lanzarcicli.putExtra("turi","ciclismo")
            startActivity(lanzarcicli)
        }

        brostro.setOnClickListener{
            val lanzarrostro= Intent(this,DescriTurismo::class.java)
            lanzarrostro.putExtra("turi","rostrocristo")
            startActivity(lanzarrostro)
        }

        bdinosaurio.setOnClickListener{
            val lanzardino= Intent(this,DescriTurismo::class.java)
            lanzardino.putExtra("turi","dinosaurio")
            startActivity(lanzardino)
        }

        bcastillo.setOnClickListener{
            val lanzarcast= Intent(this,DescriTurismo::class.java)
            lanzarcast.putExtra("turi","castillo")
            startActivity(lanzarcast)
        }

         */



    }
}