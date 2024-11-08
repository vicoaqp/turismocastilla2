package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Desarrollador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desarrollador)

        val botonface=findViewById<ImageView>(R.id.imageViewdface)
        val botonllamada=findViewById<ImageView>(R.id.imageViewdllamada)


        botonface.setOnClickListener{
            val face= Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/vicoaqp/"))
            startActivity(face)
        }

        botonllamada.setOnClickListener{
            val myUri= Uri.parse("tel:969734486").let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }

    }
}