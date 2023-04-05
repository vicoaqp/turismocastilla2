package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriRestaurante : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_restaurante)


        var vidDistrito=intent.getStringExtra("idDistrito")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dias")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamerest=intent.getStringExtra("namerest")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")
       // Log.i("variable",vrestaura.toString())

        val paqueterestaurante:Bundle= Bundle()
        paqueterestaurante.putString("FidDistrito",vidDistrito)
        paqueterestaurante.putString("Fcelular",vcelular)
        paqueterestaurante.putString("Fdescripcion",vdescripcion)
        paqueterestaurante.putString("Fdias",vdias)
        paqueterestaurante.putString("Fdireccion",vdireccion)
        paqueterestaurante.putString("Fhorario",vhorario)
        paqueterestaurante.putString("Fnamerest",vnamerest)
        paqueterestaurante.putString("Ffacebook",vfacebook)
        paqueterestaurante.putString("Fmapa",vmapa)
        supportFragmentManager.setFragmentResult("fragresta",paqueterestaurante)

        val paquetenamerest:Bundle= Bundle()
        paquetenamerest.putString("FRcelular",vcelular)
        paquetenamerest.putString("FRfacebook",vfacebook)
        paquetenamerest.putString("FRmapa",vmapa)
        supportFragmentManager.setFragmentResult("fragmresta",paquetenamerest)




        val sliderrest=findViewById<ViewPager2>(R.id.sliderres)
        val tabsrest=findViewById<TabLayout>(R.id.tabsres)

        val adapres=myResta(this)
        sliderrest.adapter=adapres


        val admintabres=TabLayoutMediator(tabsrest,sliderrest,TabLayoutMediator.TabConfigurationStrategy{
            tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Contacto"

            }
        })
        admintabres.attach()



    }
}