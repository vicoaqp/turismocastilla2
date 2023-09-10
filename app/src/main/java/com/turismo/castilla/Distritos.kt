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



        btnorcopampa.setOnClickListener{
            val orco= Intent(this,Eleccion::class.java)
            orco.putExtra("Distrito","LpcObyvDvenDre1olyJn")
            orco.putExtra("codigo","novino")
            startActivity(orco)
        }

        btnayo.setOnClickListener{
            val ayo= Intent(this,Eleccion::class.java)
            ayo.putExtra("Distrito","cikcoCgMQghiaZWKkEvu")
            ayo.putExtra("codigo","novino")
            startActivity(ayo)
        }

        btntipan.setOnClickListener{
            val tipan= Intent(this,Eleccion::class.java)
            tipan.putExtra("Distrito","vmG9JczBTRSSJPPA6muk")
            tipan.putExtra("codigo","novino")
            startActivity(tipan)
        }

        btnchoco.setOnClickListener{
            val choco= Intent(this,Eleccion::class.java)
            choco.putExtra("Distrito","UKh1aNqrJgH4BseEupyG")
            choco.putExtra("codigo","novino")
            choco.putExtra("codigos","pocainformacion")
            startActivity(choco)
        }

        btnchachas.setOnClickListener{
            val chachas= Intent(this,Eleccion::class.java)
            chachas.putExtra("Distrito","eHCGunMDILDjNjFUR3Vd")
            chachas.putExtra("codigo","novino")
            startActivity(chachas)
        }

        btnunon.setOnClickListener{
            val unon= Intent(this,Eleccion::class.java)
            unon.putExtra("Distrito","nII9JY5ZzmaOBWqJtWyl")
            unon.putExtra("codigo","novino")
            startActivity(unon)
        }

        btnchilcaymarca.setOnClickListener{
            val chilca= Intent(this,Eleccion::class.java)
            chilca.putExtra("Distrito","fcVILQojC53q1hnpueQT")
            chilca.putExtra("codigo","novino")
            startActivity(chilca)
        }

        btnandagua.setOnClickListener{
            val andagua= Intent(this,Eleccion::class.java)
            andagua.putExtra("Distrito","Ztu8W2RcUOqFrUZnNkf4")
            andagua.putExtra("codigo","novino")
            startActivity(andagua)
        }

        btnmachahuay.setOnClickListener{
            val machahuay= Intent(this,Eleccion::class.java)
            machahuay.putExtra("Distrito","J3GBEeOUxzP8znrNg7xx")
            machahuay.putExtra("codigo","novino")
            startActivity(machahuay)
        }

        btnpampacolca.setOnClickListener{
            val pampacolca= Intent(this,Eleccion::class.java)
            pampacolca.putExtra("Distrito","DmRmRNEmsSi86lVFjuEp")
            pampacolca.putExtra("codigo","novino")
            startActivity(pampacolca)
        }

        botonapl.setOnClickListener{
            val aplao= Intent(this,Eleccion::class.java)
            aplao.putExtra("Distrito","uyC1afkIWd23narJPGMP")
            aplao.putExtra("codigo","vino")
            startActivity(aplao)
        }

        botonhuan.setOnClickListener{
            val huancar= Intent(this,Eleccion::class.java)
            huancar.putExtra("Distrito","7BYUbi0kDD8EZGRvV5UF")
            huancar.putExtra("codigo","vino")
            startActivity(huancar)
        }

        btnuraca.setOnClickListener{
            val uraca= Intent(this,Eleccion::class.java)
            uraca.putExtra("Distrito","Y4uQ1LLi2Rvrm0pgbc36")
            uraca.putExtra("codigo","vino")
            startActivity(uraca)
        }

        btnviraco.setOnClickListener{
            val viraco= Intent(this,Eleccion::class.java)
            viraco.putExtra("Distrito","85LN38HemVE0bnJUCcMb")
            viraco.putExtra("codigo","novino")
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