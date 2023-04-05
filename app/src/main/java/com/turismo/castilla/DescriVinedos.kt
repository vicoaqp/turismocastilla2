package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriVinedos : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_vinedos)

        var vidVinedos=intent.getStringExtra("idVinedos")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dias")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamevinedos=intent.getStringExtra("namevinedos")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")



        val paquetevinedos:Bundle= Bundle()
        paquetevinedos.putString("vidVinedos",vidVinedos)
        paquetevinedos.putString("vcelular",vcelular)
        paquetevinedos.putString("vdescripcion",vdescripcion)
        paquetevinedos.putString("vdias",vdias)
        paquetevinedos.putString("vdireccion",vdireccion)
        paquetevinedos.putString("vhorario",vhorario)
        paquetevinedos.putString("vnamevinedos",vnamevinedos)
        paquetevinedos.putString("vfacebook",vfacebook)
        paquetevinedos.putString("vmapa",vmapa)
        supportFragmentManager.setFragmentResult("fragvino",paquetevinedos)


        val paquelinkv:Bundle= Bundle()
        paquelinkv.putString("vtcelular",vcelular)
        paquelinkv.putString("vtfacebook",vfacebook)
        paquelinkv.putString("vtmapa",vmapa)
        supportFragmentManager.setFragmentResult("fraglinkvino",paquelinkv)


        val sliderviendos=findViewById<ViewPager2>(R.id.slidervinedos)
        val tabsvinedos=findViewById<TabLayout>(R.id.tabsvinedos)

        val adaphotel=myVinedos(this)
        sliderviendos.adapter=adaphotel


        val admintabvinedos= TabLayoutMediator(tabsvinedos,sliderviendos, TabLayoutMediator.TabConfigurationStrategy{
                tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Contacto"

            }
        })
        admintabvinedos.attach()

    }
}