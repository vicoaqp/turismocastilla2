package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class gastrohuancarqui : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastrohuancarqui)

        val btnrinconcito=findViewById<Button>(R.id.button_huancrinconcito)

        btnrinconcito.setOnClickListener{
            val rinconcitoval= Intent(this,DescriRestaurante::class.java)
            rinconcitoval.putExtra("resta","rinconcitohuancarqui")
            startActivity(rinconcitoval)
        }




    }
}