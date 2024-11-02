package com.turismo.castilla

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class info_vinedos : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_vinedos)

        var vidHotel=intent.getStringExtra("idVinedos")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dias")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamehotel=intent.getStringExtra("namevinedos")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")
        var mapas2=intent.getStringExtra("mapa2")
        var img1=intent.getStringExtra("img1")
        var img2=intent.getStringExtra("img2")
        var img3=intent.getStringExtra("img3")
        var img4=intent.getStringExtra("img4")



        val textodes = findViewById<TextView>(R.id.vindes)
        val textodir = findViewById<TextView>(R.id.vindireccion)
        val textocel = findViewById<TextView>(R.id.vincelulares)
        val textodias = findViewById<TextView>(R.id.vindias)
        val textohora= findViewById<TextView>(R.id.vinhorarios)
        val btnface = findViewById<Button>(R.id.buttonfacebookvin)
        val btnmapa = findViewById<Button>(R.id.buttonmapvin)
        val btnllamada = findViewById<Button>(R.id.buttonllamadavin)

        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)
        Glide.with(this).load(img1).into(imagencabecera)


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


    }

}