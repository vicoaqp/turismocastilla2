package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler= Handler()
        handler.postDelayed({
            val intent=Intent(this,login::class.java)
            startActivity(intent)
            finish()

        },5000)

        val boton1=findViewById<Button>(R.id.button_princ)

        boton1.setOnClickListener {
            val lanzar= Intent(this, login::class.java)
            startActivity(lanzar)
        }
        val boton2=findViewById<Button>(R.id.botonsecu)

        boton2.setOnClickListener {
            val lanzar2= Intent(this, HistoriaApl::class.java)
            startActivity(lanzar2)
        }

    }
}