package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Distritos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distritos)


        val botonapl=findViewById<Button>(R.id.button_aplao)

        botonapl.setOnClickListener{
            val aplao= Intent(this,Eleccion::class.java)
            aplao.putExtra("Distrito","aplao")
            startActivity(aplao)
        }

    }
}