package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.VideoView

class Portada : AppCompatActivity() {
    protected lateinit var vvfondo:VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portada)

        val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.castilla)

        vvfondo= findViewById(R.id.videoview)

        vvfondo.setVideoURI(uri)
        vvfondo.requestFocus()


        vvfondo.setOnCompletionListener {
            Toast.makeText(this,"Gracias por mirara el video",Toast.LENGTH_LONG).show()
        }

        vvfondo.setOnPreparedListener { mp->
            vvfondo.start()
        }

        val botondis=findViewById<ImageView>(R.id.imageDistritos)
        val botongaleria=findViewById<ImageView>(R.id.imageViewgaleria)
        val botonyoutube=findViewById<ImageView>(R.id.imageyoutube)


        botonyoutube.setOnClickListener {
            val youvar=Intent(this,Youtube::class.java)
            startActivity(youvar)
        }

        botongaleria.setOnClickListener {
            val galvar=Intent(this,PortaFotos::class.java)
            startActivity(galvar)
        }

        botondis.setOnClickListener {
            val distele=Intent(this,Distritos::class.java)
            startActivity(distele)
        }


    }
}