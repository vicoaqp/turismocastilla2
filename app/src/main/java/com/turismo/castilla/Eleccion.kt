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
        val aplaof=findViewById<Button>(R.id.button_quehacer)

        aplaoh.setOnClickListener{
            val lanzar=Intent(this,HistoriaApl::class.java)
            startActivity(lanzar)
        }


        aplaof.setOnClickListener{
            val lanzar2=Intent(this,LocalInfo::class.java)
            startActivity(lanzar2)
        }

    }
}