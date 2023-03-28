package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriRestaurante : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_restaurante)


        var vrestaura=intent.getStringExtra("resta")

        val paqueteresta:Bundle= Bundle()
        paqueteresta.putString("restapa",vrestaura)
        supportFragmentManager.setFragmentResult("fragresta",paqueteresta)

        val paquetenamerest:Bundle= Bundle()
        paquetenamerest.putString("restprimero",vrestaura)
        supportFragmentManager.setFragmentResult("restsegundo",paquetenamerest)


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