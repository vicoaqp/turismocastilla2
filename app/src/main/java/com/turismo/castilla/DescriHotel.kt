package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriHotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_hotel)

        var vhotel=intent.getStringExtra("resta")

        val paqueteresta:Bundle= Bundle()
        paqueteresta.putString("hotelva",vhotel)
        supportFragmentManager.setFragmentResult("fraghotel",paqueteresta)


        val sliderhotel=findViewById<ViewPager2>(R.id.sliderhotel)
        val tabshotel=findViewById<TabLayout>(R.id.tabshotel)

        val adaphotel=myHotel(this)
        sliderhotel.adapter=adaphotel


        val admintabhotel= TabLayoutMediator(tabshotel,sliderhotel, TabLayoutMediator.TabConfigurationStrategy{
                tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Fotos"
                2->tab.text="Contacto"
            }
        })
        admintabhotel.attach()


    }
}