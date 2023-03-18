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
        val botonevento=findViewById<ImageView>(R.id.imageViewevento)
        val botondesa=findViewById<ImageView>(R.id.imagedesav)
        val botonnoticias=findViewById<ImageView>(R.id.imageViewReco)


        botonnoticias.setOnClickListener {
            val btdesas=Intent(this,noticiascastilla::class.java)
            startActivity(btdesas)
        }



        botondesa.setOnClickListener {
            //val btdesas=Intent(this,Desarrollador::class.java)
            //startActivity(btdesas)
        }

        botonevento.setOnClickListener {
            val btdesas=Intent(this,noticiascastilla::class.java)
            startActivity(btdesas)
        }

        botonyoutube.setOnClickListener {
            val youvar=Intent(this,Youtube::class.java)
            startActivity(youvar)
        }

        botongaleria.setOnClickListener {
            val galvar=Intent(this,PortaFotos::class.java)
            galvar.putExtra("Fotosdis","general")
            startActivity(galvar)
        }

        botondis.setOnClickListener {
            val distele=Intent(this,Distritos::class.java)

            startActivity(distele)
        }


    }
}