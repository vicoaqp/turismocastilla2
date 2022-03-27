package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriVinedos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_vinedos)

        var vvinedos=intent.getStringExtra("vine")

        val paqueteresta:Bundle= Bundle()
        paqueteresta.putString("vinedosva",vvinedos)
        supportFragmentManager.setFragmentResult("fragvinedos",paqueteresta)


        val sliderviendos=findViewById<ViewPager2>(R.id.slidervinedos)
        val tabsvinedos=findViewById<TabLayout>(R.id.tabsvinedos)

        val adaphotel=myVinedos(this)
        sliderviendos.adapter=adaphotel


        val admintabvinedos= TabLayoutMediator(tabsvinedos,sliderviendos, TabLayoutMediator.TabConfigurationStrategy{
                tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Fotos"
                2->tab.text="Contacto"
            }
        })
        admintabvinedos.attach()

    }
}