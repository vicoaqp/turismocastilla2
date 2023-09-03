package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class info_turismo : AppCompatActivity() {
    var sampleImages = arrayOf(
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_3.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_1.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_turismo)

        var vidHotel=intent.getStringExtra("idTurismo")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dias")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamehotel=intent.getStringExtra("nameturismo")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")
        var mapas2=intent.getStringExtra("mapa2")
        var img1=intent.getStringExtra("img1")
        var img2=intent.getStringExtra("img2")
        var img3=intent.getStringExtra("img3")
        var img4=intent.getStringExtra("img4")


        val textodes = findViewById<TextView>(R.id.turiprides)
        val textodir = findViewById<TextView>(R.id.turipridireccion)
        val textocel = findViewById<TextView>(R.id.turipricelulares)
        val textodias = findViewById<TextView>(R.id.turipridias)
        val textohora= findViewById<TextView>(R.id.turiprihorarios)
        val btnface = findViewById<Button>(R.id.buttonfacebookturipri)
        val btnmapa = findViewById<Button>(R.id.buttonmapturipri)
        val btnllamada = findViewById<Button>(R.id.buttonllamadaturipri)

        textodes.text=vdescripcion.toString()
        textodir.text=vdireccion.toString()
        textocel.text=vcelular.toString()
        textodias.text=vdias.toString()
        textohora.text=vhorario.toString()

        btnmapa.setOnClickListener{
            val lanzar3= Intent(this,Pruebas::class.java)
            lanzar3.putExtra("mapa",vmapa.toString())
            lanzar3.putExtra("mapa2",mapas2.toString())
            lanzar3.putExtra("namehotel",vnamehotel.toString())
            lanzar3.putExtra("imagen1",img1.toString())
            startActivity(lanzar3)
        }

        btnface.setOnClickListener{
            val face= Intent(Intent.ACTION_VIEW, Uri.parse(""+vfacebook.toString()))
            startActivity(face)
        }
        btnllamada.setOnClickListener{
            val myUri= Uri.parse("tel:"+vcelular.toString()).let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }

        sampleImages = arrayOf(
            img1.toString(),
            img2.toString(),
            img3.toString(),
            img4.toString()

        )

        val carouselView = findViewById(R.id.carouselView) as CarouselView
        carouselView.setPageCount(sampleImages.size)
        carouselView.setImageListener(imageListener)


    }
    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
            //imageView.setImageResource(sampleImages[position])
            Picasso.get().load(sampleImages[position]).into(imageView)
        }
    }

}