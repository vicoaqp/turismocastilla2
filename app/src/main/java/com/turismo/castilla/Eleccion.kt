package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Eleccion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        val aplaoh=findViewById<Button>(R.id.button_historia)

        aplaoh.setOnClickListener{

            val lanzar=Intent(this,HistoriaApl::class.java)
            startActivity(lanzar)

        }

    }
}