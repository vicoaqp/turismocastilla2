package com.turismo.castilla

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso


class info_distritos : AppCompatActivity() {

    var sampleImages = arrayOf(
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_3.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_1.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg"
    )

    var dvmapa:String?=null
    var dmapas2:String?=null
    var dnamedist:String?=null
    var dimg1:String?=null
    var dimg2:String?=null
    var dimg3:String?=null
    var dimg4:String?=null
    var dvfacebook:String?=null
    var dvcelular:String?=null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_distritos)

        val descripciontext = findViewById<TextView>(R.id.distridescripcion)
        val direcciontext = findViewById<TextView>(R.id.distridireccion)
        val alcaldetext = findViewById<TextView>(R.id.distrialcalde)
        val anexostext = findViewById<TextView>(R.id.distrianexos)
        val festividadestext = findViewById<TextView>(R.id.distrifestividades)
        val btnface = findViewById<Button>(R.id.buttonfacebookdist)
        val btnmapa = findViewById<Button>(R.id.buttonmapdist)
        val btnllamada = findViewById<Button>(R.id.buttonllamadadist)

        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)



        var vanamedistrito = intent.extras?.getString("dist")

        FirebaseFirestore.getInstance().collection("distritos")
            .whereEqualTo("idDistrito",vanamedistrito)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    descripciontext.text= document.data.get("descripcion").toString()
                    direcciontext.text= document.data.get("direccion").toString()
                    alcaldetext.text = document.data.get("alcalde").toString()
                    anexostext.text = document.data.get("anexos").toString()
                    festividadestext.text = document.data.get("festividades").toString()
                    dvmapa = document.data.get("mapa").toString()
                    dmapas2 = document.data.get("mapa2").toString()
                    dnamedist = document.data.get("namedistrito").toString()
                    dimg1 = document.data.get("img1").toString()
                    dimg2 = document.data.get("img2").toString()
                    dimg3 = document.data.get("img3").toString()
                    dimg4 = document.data.get("img4").toString()
                    dvcelular = document.data.get("celular").toString()
                    dvfacebook = document.data.get("facebook").toString()

                    Glide.with(this).load(dimg1).into(imagencabecera)
                    restaplao(dimg1.toString())
                   // Toast.makeText(this, img1.toString(), Toast.LENGTH_LONG).show()


                }
            }
            .addOnFailureListener{
            }



        btnmapa.setOnClickListener{
            val lanzar3= Intent(this,Pruebas::class.java)
            lanzar3.putExtra("mapa",dvmapa.toString())
            lanzar3.putExtra("mapa2",dmapas2.toString())
            lanzar3.putExtra("namehotel",dnamedist.toString())
            lanzar3.putExtra("imagen1",dimg1.toString())
            startActivity(lanzar3)
        }
        Toast.makeText(this, dvfacebook.toString(), Toast.LENGTH_LONG).show()
        btnface.setOnClickListener{
            val face= Intent(Intent.ACTION_VIEW, Uri.parse(""+dvfacebook.toString()))
            startActivity(face)
        }
        btnllamada.setOnClickListener{
            val myUri= Uri.parse("tel:"+dvcelular.toString()).let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }


        sampleImages = arrayOf(
           dimg1.toString(),
            dimg2.toString(),
            dimg3.toString(),
           dimg4.toString()
        )

        //val carouselView = findViewById(R.id.carouselView) as CarouselView
        //carouselView.setPageCount(sampleImages.size)
        //carouselView.setImageListener(imageListener)
    }


    private fun restaplao(dase:String) {

        //Toast.makeText(this,dase.toString(), Toast.LENGTH_LONG).show()

        sampleImages = arrayOf(
            dimg1.toString(),
            dimg2.toString(),
            dimg3.toString(),
            dimg4.toString()
        )

        //val carouselView = findViewById(R.id.carouselView) as CarouselView

        //carouselView.setPageCount(sampleImages.size)
        //carouselView.setImageListener(imageListener)

    }
    /*
    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
            //imageView.setImageResource(sampleImages[position])
            Picasso.get().load(sampleImages[position]).into(imageView)
        }
    }
    */

}