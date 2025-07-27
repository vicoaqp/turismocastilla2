package com.turismo.castilla

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class InfoCalendario : AppCompatActivity() {
    var sampleImages = arrayOf(
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_3.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_1.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg"
    )


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_calendario)

        var vidcalendario=intent.getStringExtra("idTurismo")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dia")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamehotel=intent.getStringExtra("nameturismo")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")
        var mapas2=intent.getStringExtra("mapa2")
        var imgcalendario=intent.getStringExtra("imgcalendario")

        var img1=intent.getStringExtra("img1")
        var img2=intent.getStringExtra("img2")
        var img3=intent.getStringExtra("img3")
        var img4=intent.getStringExtra("img4")

        val textodes = findViewById<TextView>(R.id.calendariodes)
        val textodir = findViewById<TextView>(R.id.calendariodireccion)
        //val textocel = findViewById<TextView>(R.id.turipricelulares)
        val textodias = findViewById<TextView>(R.id.calendariodias)
        //val textohora= findViewById<TextView>(R.id.turiprihorarios)


        val btnmapac = findViewById<Button>(R.id.buttonmapcalen)


        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)
        Glide.with(this).load(imgcalendario).into(imagencabecera)

        textodes.text=vdescripcion.toString()
        textodir.text=vdireccion.toString()
        //textocel.text=vcelular.toString()
        textodias.text=vdias.toString()
        //textohora.text=vhorario.toString()




        sampleImages = arrayOf(
            img1.toString(),
            img2.toString(),
            img3.toString(),
            img4.toString()

        )



      //  val carouselView = findViewById(R.id.carouselView) as CarouselView
      //  carouselView.setPageCount(sampleImages.size)
     //   carouselView.setImageListener(imageListener)


    }
    //var imageListener: ImageListener = object : ImageListener {
   //     override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
            //imageView.setImageResource(sampleImages[position])
    //        Picasso.get().load(sampleImages[position]).into(imageView)
    //    }
    //}

}