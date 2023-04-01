package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import android.widget.VideoView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Portada : AppCompatActivity() {
    protected lateinit var vvfondo:VideoView
    var videoapps:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portada)

        //val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        val db= Firebase.firestore

        db.collection("vinedos")
            .get()
            .addOnSuccessListener { resultados ->
                for (document in resultados) {
                    Log.i("dasess",resultados.toString())
                    videoapps = document.data.get("celular").toString()
                    Log.i("valorvideo",videoapps.toString())
                }
            }

        //val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.castilla)

        Toast.makeText(this,videoapps.toString(),Toast.LENGTH_LONG).show()
        val uri = Uri.parse(videoapps)

        vvfondo= findViewById(R.id.videoview)

        vvfondo.setVideoURI(uri)
        vvfondo.requestFocus()


        vvfondo.setOnCompletionListener {
            //Toast.makeText(this,"Gracias por mirara el video",Toast.LENGTH_LONG).show()
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