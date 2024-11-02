package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class InfoGeneral : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_info_general)



        var vgnameid=intent.getStringExtra("idgeneral")
        var vgcelular=intent.getStringExtra("celularg")
        var vgdescripcion=intent.getStringExtra("descripciong")
        var vgdias=intent.getStringExtra("diasg")
        var vgdireccion=intent.getStringExtra("direcciong")
        var vghorario=intent.getStringExtra("horariog")
        var vnamegeneral=intent.getStringExtra("nameg")
        var vgfacebook=intent.getStringExtra("facebookg")
        var vgmapa=intent.getStringExtra("mapag")
        var vgmapas2=intent.getStringExtra("mapag2")
        var img1=intent.getStringExtra("img1")
        var img2=intent.getStringExtra("img2")
        var img3=intent.getStringExtra("img3")
        var img4=intent.getStringExtra("img4")


        val textodes = findViewById<TextView>(R.id.gdes)
        val textodir = findViewById<TextView>(R.id.gdireccion)
        val textocel = findViewById<TextView>(R.id.gcelulares)
        val textodias = findViewById<TextView>(R.id.gdias)
        val textohora= findViewById<TextView>(R.id.ghorarios)
        val btnface = findViewById<Button>(R.id.buttonfacebookg)
        val btnmapa = findViewById<Button>(R.id.buttonmapg)
        val btnllamada = findViewById<Button>(R.id.buttonllamadag)


        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)
        Glide.with(this).load(img1).into(imagencabecera)

        textodes.text=vgdescripcion.toString()
        textodir.text=vgdireccion.toString()
        textocel.text=vgcelular.toString()
        textodias.text=vgdias.toString()
        textohora.text=vghorario.toString()

        btnmapa.setOnClickListener{
            val lanzar3= Intent(this,Pruebas::class.java)
            lanzar3.putExtra("mapa",vgmapa.toString())
            lanzar3.putExtra("mapa2",vgmapas2.toString())
            lanzar3.putExtra("namehotel",vnamegeneral.toString())
            lanzar3.putExtra("imagen1",img1.toString())
            startActivity(lanzar3)
        }

        btnface.setOnClickListener{
            val face= Intent(Intent.ACTION_VIEW, Uri.parse(""+vgfacebook.toString()))
            startActivity(face)
        }
        btnllamada.setOnClickListener{
            val myUri= Uri.parse("tel:"+vgcelular.toString()).let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }

    }


}