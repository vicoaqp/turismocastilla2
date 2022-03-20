package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GastroCorire : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastro_corire)

        val bllutis=findViewById<Button>(R.id.button_cllutis)

        bllutis.setOnClickListener{
            val llutis= Intent(this,DescriRestaurante::class.java)
            llutis.putExtra("resta","llutis")
            startActivity(llutis)
        }


    }
}