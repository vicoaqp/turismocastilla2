package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton1=findViewById<Button>(R.id.button_princ)

        boton1.setOnClickListener {
            val lanzar= Intent(this, HistoriaApl::class.java)
            startActivity(lanzar)
        }

    }
}