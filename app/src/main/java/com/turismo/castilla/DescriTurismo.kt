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

        var vidHotel=intent.getStringExtra("idTurismo")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dias")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamehotel=intent.getStringExtra("nameturismo")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")

        val paqueteturismos:Bundle= Bundle()
        paqueteturismos.putString("tidTurismos",vidHotel)
        paqueteturismos.putString("tcelular",vcelular)
        paqueteturismos.putString("tdescripcion",vdescripcion)
        paqueteturismos.putString("tdias",vdias)
        paqueteturismos.putString("tdireccion",vdireccion)
        paqueteturismos.putString("thorario",vhorario)
        paqueteturismos.putString("tnamehotel",vnamehotel)
        paqueteturismos.putString("tfacebook",vfacebook)
        paqueteturismos.putString("tmapa",vmapa)
        supportFragmentManager.setFragmentResult("fragturismos",paqueteturismos)



        val paquelinkt:Bundle= Bundle()
        paquelinkt.putString("trcelular",vcelular)
        paquelinkt.putString("trfacebook",vfacebook)
        paquelinkt.putString("trmapa",vmapa)
        supportFragmentManager.setFragmentResult("fraglinkturismo",paquelinkt)






        val sliderturismo=findViewById<ViewPager2>(R.id.sliderturi)
        val tabsturismo=findViewById<TabLayout>(R.id.tabsturi)

        val adapres=myTurismo(this)
        sliderturismo.adapter=adapres


        val admintabturismo= TabLayoutMediator(tabsturismo,sliderturismo, TabLayoutMediator.TabConfigurationStrategy{
                tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Informacion"
            }
        })
        admintabturismo.attach()


    }
}