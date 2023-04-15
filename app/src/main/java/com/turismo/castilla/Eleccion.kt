package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible

class Eleccion : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        var namedistrito=intent.extras?.getString("Distrito")
        Toast.makeText(this,namedistrito.toString(),Toast.LENGTH_LONG).show()

        val aplaoh=findViewById<Button>(R.id.button_historia)
        val aplaoqh=findViewById<Button>(R.id.button_quehacer)
        val aplaohos=findViewById<Button>(R.id.button_hospedaje)
        val aplaogast=findViewById<Button>(R.id.button_gastronomia)
        val aplaovin=findViewById<Button>(R.id.button_vinedos)

        //DISTRITO

        //if(namedistrito=""){
          //  aplaovin.isInvisible
        // }

        aplaoh.setOnClickListener{
            val lanzar=Intent(this,HistoriaApl::class.java)
            lanzar.putExtra("dist",namedistrito)
            startActivity(lanzar)
        }
        aplaoqh.setOnClickListener{

            val lanzar2=Intent(this,Turismo::class.java)
            lanzar2.putExtra("dist",namedistrito)
            startActivity(lanzar2)

        }

        aplaogast.setOnClickListener{

            val lanzar3=Intent(this,GastroAplaoRec::class.java)
            lanzar3.putExtra("dist",namedistrito)
            startActivity(lanzar3)

        }

        aplaohos.setOnClickListener{
            val lanzar4=Intent(this,Hoteles::class.java)
            lanzar4.putExtra("dist",namedistrito)
            startActivity(lanzar4)

        }

        aplaovin.setOnClickListener{
            val lanzar5=Intent(this,Vinedos::class.java)
            lanzar5.putExtra("dist",namedistrito)
            startActivity(lanzar5)
        }




    }
}