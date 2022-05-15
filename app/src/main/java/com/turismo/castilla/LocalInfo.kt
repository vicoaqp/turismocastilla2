package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LocalInfo : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_info)


        val sliderlocal=findViewById<ViewPager2>(R.id.sliderlocal)
        val tabslocal = findViewById<TabLayout>(R.id.tabslocal)

        val adapterSlider2=myPages2(this)
        sliderlocal.adapter=adapterSlider2

        val admintab2=TabLayoutMediator(tabslocal,sliderlocal,TabLayoutMediator.TabConfigurationStrategy{
            tablocal, positionlocal->
            when(positionlocal){

                0->tablocal.text="Descripcion"
                1->tablocal.text="Fotos"
                2->tablocal.text="Como Llegar"

            }

        })
        admintab2.attach()

    }
}