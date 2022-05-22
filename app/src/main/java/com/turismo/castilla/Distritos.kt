package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class Distritos : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distritos)


        val botonapl=findViewById<Button>(R.id.button_fundobarra)
        val botonhuan=findViewById<Button>(R.id.button_casmauro)
        val btnuraca=findViewById<Button>(R.id.button_yupanqui)
        val btnviraco=findViewById<Button>(R.id.button_kasamia)
        val btnpampacolca=findViewById<Button>(R.id.button_majeriver)
        val btnmachahuay=findViewById<Button>(R.id.button_rambo)
        val btnandagua=findViewById<Button>(R.id.button_rocasbambu)
        val btnchilcaymarca=findViewById<Button>(R.id.button_titanic)
        val btnunon=findViewById<Button>(R.id.button_unon)
        val btnchachas=findViewById<Button>(R.id.button_chachas)
        val btnchoco=findViewById<Button>(R.id.button_choco)
        val btntipan=findViewById<Button>(R.id.button_tipan)
        val btnayo=findViewById<Button>(R.id.button_ayo)
        val btnorcopampa=findViewById<Button>(R.id.button_orcopampa)

        val btnpruebaa=findViewById<Button>(R.id.buttonpruebaaaa)
        val btnfotosprueba=findViewById<Button>(R.id.buttonfotosss)

        btnfotosprueba.setOnClickListener{
            val orco2222= Intent(this,PortaFotos::class.java)
            startActivity(orco2222)
        }


        btnpruebaa.setOnClickListener{
            val orco2= Intent(this,Youtube::class.java)
            startActivity(orco2)
        }


        btnorcopampa.setOnClickListener{
            val orco= Intent(this,Eleccion::class.java)
            orco.putExtra("Distrito","orcopampa")
            startActivity(orco)
        }

        btnayo.setOnClickListener{
            val ayo= Intent(this,Eleccion::class.java)
            ayo.putExtra("Distrito","ayo")
            startActivity(ayo)
        }

        btntipan.setOnClickListener{
            val tipan= Intent(this,Eleccion::class.java)
            tipan.putExtra("Distrito","tipan")
            startActivity(tipan)
        }

        btnchoco.setOnClickListener{
            val choco= Intent(this,Eleccion::class.java)
            choco.putExtra("Distrito","choco")
            startActivity(choco)
        }

        btnchachas.setOnClickListener{
            val chachas= Intent(this,Eleccion::class.java)
            chachas.putExtra("Distrito","chachas")
            startActivity(chachas)
        }

        btnunon.setOnClickListener{
            val unon= Intent(this,Eleccion::class.java)
            unon.putExtra("Distrito","unon")
            startActivity(unon)
        }

        btnchilcaymarca.setOnClickListener{
            val chilca= Intent(this,Eleccion::class.java)
            chilca.putExtra("Distrito","chilcaymarca")
            startActivity(chilca)
        }

        btnandagua.setOnClickListener{
            val andagua= Intent(this,Eleccion::class.java)
            andagua.putExtra("Distrito","andagua")
            startActivity(andagua)
        }

        btnmachahuay.setOnClickListener{
            val machahuay= Intent(this,Eleccion::class.java)
            machahuay.putExtra("Distrito","machahuay")
            startActivity(machahuay)
        }

        btnpampacolca.setOnClickListener{
            val pampacolca= Intent(this,Eleccion::class.java)
            pampacolca.putExtra("Distrito","pampacolca")
            startActivity(pampacolca)
        }

        botonapl.setOnClickListener{
            val aplao= Intent(this,Eleccion::class.java)
            aplao.putExtra("Distrito","aplao")
            startActivity(aplao)
        }

        botonhuan.setOnClickListener{
            val huancar= Intent(this,Eleccion::class.java)
            huancar.putExtra("Distrito","huancarqui")
            startActivity(huancar)
        }

        btnuraca.setOnClickListener{
            val uraca= Intent(this,Eleccion::class.java)
            uraca.putExtra("Distrito","uraca")
            startActivity(uraca)
        }

        btnviraco.setOnClickListener{
            val viraco= Intent(this,Eleccion::class.java)
            viraco.putExtra("Distrito","viraco")
            startActivity(viraco)
        }


    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item=menu?.findItem(R.id.act1)
        item?.setVisible(false)
        item?.isEnabled=false
        return super.onPrepareOptionsMenu(menu)
    }


}