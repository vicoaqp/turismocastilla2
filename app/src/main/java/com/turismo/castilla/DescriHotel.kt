package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DescriHotel : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descri_hotel)

        var vidHotel=intent.getStringExtra("idHotel")
        var vcelular=intent.getStringExtra("celular")
        var vdescripcion=intent.getStringExtra("descripcion")
        var vdias=intent.getStringExtra("dias")
        var vdireccion=intent.getStringExtra("direccion")
        var vhorario=intent.getStringExtra("horario")
        var vnamehotel=intent.getStringExtra("namehotel")
        var vfacebook=intent.getStringExtra("facebook")
        var vmapa=intent.getStringExtra("mapa")
        var img1=intent.getStringExtra("img1")
        var img2=intent.getStringExtra("img2")
        var img3=intent.getStringExtra("img3")
        var img4=intent.getStringExtra("img4")


        val paquetehotel:Bundle= Bundle()
        paquetehotel.putString("HidHotel",vidHotel)
        paquetehotel.putString("Hcelular",vcelular)
        paquetehotel.putString("Hdescripcion",vdescripcion)
        paquetehotel.putString("Hdias",vdias)
        paquetehotel.putString("Hdireccion",vdireccion)
        paquetehotel.putString("Hhorario",vhorario)
        paquetehotel.putString("Hnamehotel",vnamehotel)
        paquetehotel.putString("Hfacebook",vfacebook)
        paquetehotel.putString("Hmapa",vmapa)
        paquetehotel.putString("img1",img1)
        paquetehotel.putString("img2",img2)
        paquetehotel.putString("img3",img3)
        paquetehotel.putString("img4",img4)
        supportFragmentManager.setFragmentResult("fraghotel",paquetehotel)



        val paquelinkh:Bundle= Bundle()
        paquelinkh.putString("HTcelular",vcelular)
        paquelinkh.putString("HTfacebook",vfacebook)
        paquelinkh.putString("HTmapa",vmapa)
        paquelinkh.putString("HTidHotel",vidHotel)
        supportFragmentManager.setFragmentResult("fraglinkhotel",paquelinkh)



        val sliderhotel=findViewById<ViewPager2>(R.id.sliderhotel)
        val tabshotel=findViewById<TabLayout>(R.id.tabshotel)

        val adaphotel=myHotel(this)
        sliderhotel.adapter=adaphotel


        val admintabhotel= TabLayoutMediator(tabshotel,sliderhotel, TabLayoutMediator.TabConfigurationStrategy{
                tab, position ->
            when(position){
                0->tab.text="Descripcion"
                1->tab.text="Contacto"
            }
        })
        admintabhotel.attach()


    }
}