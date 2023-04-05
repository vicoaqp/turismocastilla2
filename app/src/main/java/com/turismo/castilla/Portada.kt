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
        vvfondo= findViewById(R.id.videoview)

        //val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        //val db= Firebase.firestore

        FirebaseFirestore.getInstance().collection("videoapp")
            .get()
            .addOnSuccessListener { resultados ->
                for (document in resultados) {
                    //Log.i("dasess",resultados.toString())
                    videoapps = document.data.get("videolink").toString()
                    //Log.i("valorvideo",videoapps.toString())

                    val uri = Uri.parse(""+videoapps)
                    vvfondo.setVideoURI(uri)
                    vvfondo.requestFocus()

                    vvfondo.setOnCompletionListener {
                        //Toast.makeText(this,"Gracias por mirara el video",Toast.LENGTH_LONG).show()
                    }
                    vvfondo.setOnPreparedListener { mp->
                        vvfondo.start()
                    }

                }
            }
            .addOnFailureListener{
            }

        //val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.castilla)


        //val uri = Uri.parse(videoapps)
       // vvfondo.setVideoURI(uri)
       // vvfondo.requestFocus()

       // vvfondo.setOnCompletionListener {
            //Toast.makeText(this,"Gracias por mirara el video",Toast.LENGTH_LONG).show()
       // }
        //vvfondo.setOnPreparedListener { mp->
        //    vvfondo.start()
        //}


        val botondis=findViewById<ImageView>(R.id.imageDistritos)
        val botongaleria=findViewById<ImageView>(R.id.imageViewgaleria)
        val botonyoutube=findViewById<ImageView>(R.id.imageyoutube)
        val botonevento=findViewById<ImageView>(R.id.imageViewevento)
        val botondesa=findViewById<ImageView>(R.id.imagedesav)
        val botonnoticias=findViewById<ImageView>(R.id.imageViewReco)


        botonnoticias.setOnClickListener {
            val btdesas=Intent(this,GastroAplaoRec::class.java)
            btdesas.putExtra("Fotosdis","general")
            startActivity(btdesas)
        }



        botondesa.setOnClickListener {
            val btdesas=Intent(this,PortadaTurismo::class.java)
            startActivity(btdesas)
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

private fun linkvideos(dase:String) {
    //Toast.makeText(this,"ENTROOOOOO", Toast.LENGTH_LONG).show()
    FirebaseFirestore.getInstance().collection("gastroaplaof")
        .get()
        .addOnSuccessListener { resultados ->
            for (document in resultados) {
                Log.i("dasess",resultados.toString())
                var videoapps2 = document.data.get("celular").toString()
                Log.i("valorvideo",videoapps2.toString())
            }
        }
        .addOnFailureListener{

        }


}