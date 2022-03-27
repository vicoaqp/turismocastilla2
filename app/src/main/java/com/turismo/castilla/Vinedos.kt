package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Vinedos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vinedos)


        val bestremadoyro=findViewById<Button>(R.id.button_estremadoyro)


        bestremadoyro.setOnClickListener{
            val lanzarestre= Intent(this,DescriVinedos::class.java)
            lanzarestre.putExtra("vine","estremadoyro")
            startActivity(lanzarestre)
        }

    }
}