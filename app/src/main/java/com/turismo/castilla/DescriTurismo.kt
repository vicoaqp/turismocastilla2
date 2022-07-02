package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriTurismo : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_turismo)

        var vturismo=intent.getStringExtra("turi")

        val paqueteresta:Bundle= Bundle()
        paqueteresta.putString("turismova",vturismo)
        supportFragmentManager.setFragmentResult("fragturismo",paqueteresta)


        val sliderturismo=findViewById<ViewPager2>(R.id.sliderturi)
        val tabsturismo=findViewById<TabLayout>(R.id.tabsturi)

        val adapres=myTurismo(this)
        sliderturismo.adapter=adapres


        val admintabturismo= TabLayoutMediator(tabsturismo,sliderturismo, TabLayoutMediator.TabConfigurationStrategy{
                tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Contacto"
            }
        })
        admintabturismo.attach()


    }
}