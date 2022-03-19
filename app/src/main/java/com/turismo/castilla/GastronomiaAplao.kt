package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GastronomiaAplao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastronomia_aplao)

        val btitanic=findViewById<Button>(R.id.button_titanic)
        val bkasamia=findViewById<Button>(R.id.button_kasamia)


        btitanic.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","titanic")
            startActivity(lanzar)
        }
        bkasamia.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","ksamia")
            startActivity(lanzar)
        }


    }
}