package com.turismo.castilla

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
class InfoNegocios : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_negocios)

        var infonego=intent.getStringExtra("idDistrito")
        var infocelular=intent.getStringExtra("celular")
        var infodescripcion=intent.getStringExtra("descripcion")
        var infodias=intent.getStringExtra("dias")
        var infodireccion=intent.getStringExtra("direccion")
        var infohorario=intent.getStringExtra("horario")
        var infonamenego=intent.getStringExtra("namenegocio")
        var infofacebook=intent.getStringExtra("facebook")
        var infomapa=intent.getStringExtra("mapa")
        var infomapas2=intent.getStringExtra("mapa2")
        var infoimg1=intent.getStringExtra("img1")


        //Log.i("imagenesdos",img1.toString())

        val textodes = findViewById<TextView>(R.id.textnedes)
        val textodir = findViewById<TextView>(R.id.textnedir)
        val textocel = findViewById<TextView>(R.id.textnecel)
        val textodias = findViewById<TextView>(R.id.textneate)
        val textohora= findViewById<TextView>(R.id.textnehor)

        val btnface = findViewById<Button>(R.id.btnfacene)
        val btnmapa = findViewById<Button>(R.id.btnmapne)
        val btnllamada = findViewById<Button>(R.id.btnllamadane)

        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)
        Glide.with(this).load(infoimg1).into(imagencabecera)

        textodes.text=infodescripcion.toString()
        textodir.text=infodireccion.toString()
        textocel.text=infocelular.toString()
        textodias.text=infodias.toString()
        textohora.text=infohorario.toString()




    }

}