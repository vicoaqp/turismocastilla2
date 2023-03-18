package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

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
        val aplaomov=findViewById<Button>(R.id.button_movilidad)


        //DISTRITO
        aplaoh.setOnClickListener{
            val lanzar=Intent(this,HistoriaApl::class.java)
            lanzar.putExtra("dist",namedistrito)
            startActivity(lanzar)
        }
        aplaoqh.setOnClickListener{

            if(namedistrito =="aplao"){
                val lanzar2=Intent(this,Turismo::class.java)
                lanzar2.putExtra("dist",namedistrito)
                startActivity(lanzar2)
            }
            else if(namedistrito =="huancarqui"){
                val lanzar2=Intent(this,qhuancarqui::class.java)
                lanzar2.putExtra("dist",namedistrito)
                startActivity(lanzar2)
            }
            else if(namedistrito =="uraca"){
                val lanzar2=Intent(this,queuraca2::class.java)
                lanzar2.putExtra("dist",namedistrito)
                startActivity(lanzar2)
            }
            else{
                val lanzar2=Intent(this,generalturismo2::class.java)
                lanzar2.putExtra("dist",namedistrito)
                startActivity(lanzar2)
            }

            //val lanzar2=Intent(this,Turismo::class.java)
            //lanzar2.putExtra("dist",namedistrito)
            //startActivity(lanzar2)
        }

        aplaogast.setOnClickListener{

            if(namedistrito =="aplao"){
                val lanzar3=Intent(this,GastronomiaAplao::class.java)
                startActivity(lanzar3)
            }else if(namedistrito =="uraca"){
                val lanzar3=Intent(this,GastroCorire::class.java)
                startActivity(lanzar3)
            }else if(namedistrito =="huancarqui"){
                val lanzar3=Intent(this,gastrohuancarqui::class.java)
                startActivity(lanzar3)
            }else{
                val lanzar30=Intent(this,generalgastronomia::class.java)
                startActivity(lanzar30)
            }

        }



        aplaohos.setOnClickListener{
            if(namedistrito =="aplao"){
                val lanzar4=Intent(this,Hoteles::class.java)
                lanzar4.putExtra("dist",namedistrito)
                startActivity(lanzar4)
            }else if(namedistrito =="huancarqui"){
                val lanzar3=Intent(this,hotelhuancarqui::class.java)
                startActivity(lanzar3)
            }
            else{
                val lanzar2=Intent(this,generalhotel2::class.java)
                lanzar2.putExtra("dist",namedistrito)
                startActivity(lanzar2)
            }



            //val lanzar4=Intent(this,Hoteles::class.java)
            //lanzar4.putExtra("dist",namedistrito)
            //startActivity(lanzar4)


        }




        aplaovin.setOnClickListener{

            if(namedistrito =="aplao"){
                val lanzar5=Intent(this,Vinedos::class.java)
                lanzar5.putExtra("dist",namedistrito)
                startActivity(lanzar5)
            }
            else{
                val lanzar5=Intent(this,generalvinedos::class.java)
                lanzar5.putExtra("dist",namedistrito)
                startActivity(lanzar5)
            }

            //val lanzar5=Intent(this,Vinedos::class.java)
           //lanzar5.putExtra("dist",namedistrito)
            //startActivity(lanzar5)
        }
        aplaomov.setOnClickListener{


            val lanzar6=Intent(this,generalmovilidad::class.java)
            startActivity(lanzar6)

        }




    }
}