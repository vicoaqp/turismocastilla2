package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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

        var lanegocios = intent.extras?.getString("NEGOCIOS")
        var lanmeses = intent.extras?.getString("Mesname")
        var lanmesest = intent.extras?.getString("Mes")

        botonapl.setOnClickListener{

            if (lanegocios == "vnegocio") {
                val aplao= Intent(this,Negocios::class.java)
                aplao.putExtra("Distrito","uyC1afkIWd23narJPGMP")
                startActivity(aplao)
            }else if (lanmeses == "caledanrio"){
                val aplao= Intent(this,eleccionmes::class.java)
                aplao.putExtra("Mes",lanmesest)
                startActivity(aplao)
            }else{
                val aplao= Intent(this,Eleccion::class.java)
                aplao.putExtra("Distrito","uyC1afkIWd23narJPGMP")
                aplao.putExtra("codigo","vino")
                startActivity(aplao)
            }

        }

        btnorcopampa.setOnClickListener{

            if (lanegocios == "vnegocio") {
                val orco= Intent(this,Negocios::class.java)
                orco.putExtra("Distrito","LpcObyvDvenDre1olyJn")
                startActivity(orco)
            }else if (lanmeses == "caledanrio"){
                val orco= Intent(this,eleccionmes::class.java)
                orco.putExtra("Mes",lanmesest)
                startActivity(orco)
            }else{
                val orco= Intent(this,Eleccion::class.java)
                orco.putExtra("Distrito","LpcObyvDvenDre1olyJn")
                orco.putExtra("codigo","novino")
                startActivity(orco)
            }
        }

        btnayo.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val ayo= Intent(this,Negocios::class.java)
                ayo.putExtra("Distrito","cikcoCgMQghiaZWKkEvu")
                startActivity(ayo)
            }else if (lanmeses == "caledanrio"){
                val ayo= Intent(this,eleccionmes::class.java)
                ayo.putExtra("Mes",lanmesest)
                startActivity(ayo)
            }else{
                val ayo= Intent(this,Eleccion::class.java)
                ayo.putExtra("Distrito","cikcoCgMQghiaZWKkEvu")
                ayo.putExtra("codigo","novino")
                startActivity(ayo)
            }
        }

        btntipan.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val tipan= Intent(this,Negocios::class.java)
                tipan.putExtra("Distrito","vmG9JczBTRSSJPPA6muk")
                startActivity(tipan)
            }else if (lanmeses == "caledanrio"){
                val tipan= Intent(this,eleccionmes::class.java)
                tipan.putExtra("Mes",lanmesest)
                startActivity(tipan)
            }else{
                val tipan= Intent(this,Eleccion::class.java)
                tipan.putExtra("Distrito","vmG9JczBTRSSJPPA6muk")
                tipan.putExtra("codigo","novino")
                startActivity(tipan)
            }
        }

        btnchoco.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val choco= Intent(this,Negocios::class.java)
                choco.putExtra("Distrito","UKh1aNqrJgH4BseEupyG")
                startActivity(choco)
            }else if (lanmeses == "caledanrio"){
                val choco= Intent(this,eleccionmes::class.java)
                choco.putExtra("Mes",lanmesest)
                startActivity(choco)
            }else{
                val choco= Intent(this,Eleccion::class.java)
                choco.putExtra("Distrito","UKh1aNqrJgH4BseEupyG")
                choco.putExtra("codigo","novino")
                choco.putExtra("codigos","pocainformacion")
                startActivity(choco)
            }
        }

        btnchachas.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val chachas= Intent(this,Negocios::class.java)
                chachas.putExtra("Distrito","eHCGunMDILDjNjFUR3Vd")
                startActivity(chachas)
            }else if (lanmeses == "caledanrio"){
                val chachas= Intent(this,eleccionmes::class.java)
                chachas.putExtra("Mes",lanmesest)
                startActivity(chachas)
            }else{
            val chachas= Intent(this,Eleccion::class.java)
            chachas.putExtra("Distrito","eHCGunMDILDjNjFUR3Vd")
            chachas.putExtra("codigo","novino")
            startActivity(chachas)
            }
        }

        btnunon.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val unon= Intent(this,Negocios::class.java)
                unon.putExtra("Distrito","nII9JY5ZzmaOBWqJtWyl")
                startActivity(unon)
            }else if (lanmeses == "caledanrio"){
                val unon= Intent(this,eleccionmes::class.java)
                unon.putExtra("Mes",lanmesest)
                startActivity(unon)
            }else{
                val unon= Intent(this,Eleccion::class.java)
                unon.putExtra("Distrito","nII9JY5ZzmaOBWqJtWyl")
                unon.putExtra("codigo","novino")
                startActivity(unon)
            }
        }

        btnchilcaymarca.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val chilca= Intent(this,Negocios::class.java)
                chilca.putExtra("Distrito","fcVILQojC53q1hnpueQT")
                startActivity(chilca)
            }else if (lanmeses == "caledanrio"){
                val chilca= Intent(this,eleccionmes::class.java)
                chilca.putExtra("Mes",lanmesest)
                startActivity(chilca)
            }else{
                val chilca= Intent(this,Eleccion::class.java)
                chilca.putExtra("Distrito","fcVILQojC53q1hnpueQT")
                chilca.putExtra("codigo","novino")
                startActivity(chilca)
            }
        }

        btnandagua.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val andagua= Intent(this,Negocios::class.java)
                andagua.putExtra("Distrito","Ztu8W2RcUOqFrUZnNkf4")
                startActivity(andagua)
            }else if (lanmeses == "caledanrio"){
                val andagua= Intent(this,eleccionmes::class.java)
                andagua.putExtra("Mes",lanmesest)
                startActivity(andagua)
            }else{
            val andagua= Intent(this,Eleccion::class.java)
            andagua.putExtra("Distrito","Ztu8W2RcUOqFrUZnNkf4")
            andagua.putExtra("codigo","novino")
            startActivity(andagua)
            }
        }

        btnmachahuay.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val machahuay= Intent(this,Negocios::class.java)
                machahuay.putExtra("Distrito","J3GBEeOUxzP8znrNg7xx")
                startActivity(machahuay)
            }else if (lanmeses == "caledanrio"){
                val machahuay= Intent(this,eleccionmes::class.java)
                machahuay.putExtra("Mes",lanmesest)
                startActivity(machahuay)
            }else{
            val machahuay= Intent(this,Eleccion::class.java)
            machahuay.putExtra("Distrito","J3GBEeOUxzP8znrNg7xx")
            machahuay.putExtra("codigo","novino")
            startActivity(machahuay)
            }
        }

        btnpampacolca.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val pampacolca= Intent(this,Negocios::class.java)
                pampacolca.putExtra("Distrito","DmRmRNEmsSi86lVFjuEp")
                startActivity(pampacolca)
            }else if (lanmeses == "caledanrio"){
                val pampacolca= Intent(this,eleccionmes::class.java)
                pampacolca.putExtra("Mes",lanmesest)
                startActivity(pampacolca)
            }else{
                val pampacolca= Intent(this,Eleccion::class.java)
                pampacolca.putExtra("Distrito","DmRmRNEmsSi86lVFjuEp")
                pampacolca.putExtra("codigo","novino")
                startActivity(pampacolca)
            }
        }

        botonhuan.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val huancar= Intent(this,Negocios::class.java)
                huancar.putExtra("Distrito","7BYUbi0kDD8EZGRvV5UF")
                startActivity(huancar)
            }else if (lanmeses == "caledanrio"){
                val huancar= Intent(this,eleccionmes::class.java)
               huancar.putExtra("Mes",lanmesest)
                startActivity(huancar)
            }else{
                val huancar= Intent(this,Eleccion::class.java)
                huancar.putExtra("Distrito","7BYUbi0kDD8EZGRvV5UF")
                huancar.putExtra("codigo","vino")
                startActivity(huancar)
            }
        }

        btnuraca.setOnClickListener{
            if (lanegocios == "vnegocio") {
                val uraca= Intent(this,Negocios::class.java)
                uraca.putExtra("Distrito","Y4uQ1LLi2Rvrm0pgbc36")
                startActivity(uraca)
            }else if (lanmeses == "caledanrio"){
                val uraca= Intent(this,eleccionmes::class.java)
                uraca.putExtra("Mes",lanmesest)
                startActivity(uraca)
            }else{
                val uraca= Intent(this,Eleccion::class.java)
                uraca.putExtra("Distrito","Y4uQ1LLi2Rvrm0pgbc36")
                uraca.putExtra("codigo","vino")
                startActivity(uraca)
            }
        }

        btnviraco.setOnClickListener{

            if (lanegocios == "vnegocio") {
                val viraco= Intent(this,Negocios::class.java)
                viraco.putExtra("Distrito","85LN38HemVE0bnJUCcMb")
                startActivity(viraco)
            }else if (lanmeses == "caledanrio"){
                val viraco= Intent(this,eleccionmes::class.java)
                viraco.putExtra("Mes",lanmesest)
                startActivity(viraco)
            }else{
                val viraco= Intent(this,Eleccion::class.java)
                viraco.putExtra("Distrito","85LN38HemVE0bnJUCcMb")
                viraco.putExtra("codigo","novino")
                startActivity(viraco)
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item=menu?.findItem(R.id.act1)
        item?.setVisible(false)
        item?.isEnabled=false
        return super.onPrepareOptionsMenu(menu)
    }


}