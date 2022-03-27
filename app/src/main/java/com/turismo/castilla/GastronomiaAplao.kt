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
        val bfundobarra=findViewById<Button>(R.id.button_fundobarra)
        val bcasademauro=findViewById<Button>(R.id.button_casmauro)
        val bfundoyupanqui=findViewById<Button>(R.id.button_yupanqui)
        val bmajesriver=findViewById<Button>(R.id.button_majeriver)
        val brambo=findViewById<Button>(R.id.button_rambo)
        val brocasbambu=findViewById<Button>(R.id.button_rocasbambu)
        val btuno=findViewById<Button>(R.id.button_tuno)

        btuno.setOnClickListener{
            val lanzartuno=Intent(this,DescriRestaurante::class.java)
            lanzartuno.putExtra("resta","tuno")
            startActivity(lanzartuno)
        }

        brocasbambu.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","rokasbambu")
            startActivity(lanzar)
        }

        brambo.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","rambo")
            startActivity(lanzar)
        }

        bmajesriver.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","majesriver")
            startActivity(lanzar)
        }

        bfundoyupanqui.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","fundoyupanqui")
            startActivity(lanzar)
        }

        bcasademauro.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","casademauro")
            startActivity(lanzar)
        }

        bfundobarra.setOnClickListener{
            val lanzar=Intent(this,DescriRestaurante::class.java)
            lanzar.putExtra("resta","fundobarra")
            startActivity(lanzar)
        }

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