package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Hoteles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteles)

        val bbuenosaires=findViewById<Button>(R.id.button_buenosaires)
        val bcasalinda=findViewById<Button>(R.id.button_casalinda)
        val bmunicipal=findViewById<Button>(R.id.button_municipal)

        bbuenosaires.setOnClickListener{
            val lanzarbuenosaires= Intent(this,DescriHotel::class.java)
            lanzarbuenosaires.putExtra("resta","buenosaires")
            startActivity(lanzarbuenosaires)
        }

        bcasalinda.setOnClickListener{
            val lanzarcasalinda= Intent(this,DescriHotel::class.java)
            lanzarcasalinda.putExtra("resta","casalinda")
            startActivity(lanzarcasalinda)
        }

        bmunicipal.setOnClickListener{
            val lanzarmunicipal= Intent(this,DescriHotel::class.java)
            lanzarmunicipal.putExtra("resta","municipal")
            startActivity(lanzarmunicipal)
        }

    }
}