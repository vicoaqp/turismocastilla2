package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class Pruebas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pruebas)

        val imageprueba=findViewById<ImageView>(R.id.imageprueba)

        Picasso.get().load("https://i.ibb.co/y46HrDH/aplao1.jpg").into(imageprueba)

    }
}