package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import myPages

class HistoriaApl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_apl)




        val slider=findViewById<ViewPager2>(R.id.slider)
        val tabs=findViewById<TabLayout>(R.id.tabs)

        val adapterSlider= myPages(this)
        slider.adapter=adapterSlider

        val admintab=TabLayoutMediator(tabs,slider,TabLayoutMediator.TabConfigurationStrategy{

            tab, position ->

            when(position){

                0->tab.text="Descripcion"
                1->tab.text="Fotos"
                2->tab.text="Mapa"
                3->tab.text="Descripcion"
                4->tab.text="Descripcion"
            }


        })
        admintab.attach()
    }
}