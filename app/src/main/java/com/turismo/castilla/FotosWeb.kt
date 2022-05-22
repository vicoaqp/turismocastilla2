package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.turismo.castilla.databinding.ActivityFotosWebBinding

class FotosWeb : AppCompatActivity() {
    private val COLUMNAS = 3
    val imageList =ArrayList<imagen>()
    val galeriaAdapter: AdaptorImagenes = AdaptorImagenes()

    lateinit var binding: ActivityFotosWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotosWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargar_imagenes()


    }

    private fun cargar_imagenes() {

        galeriaAdapter.AdaptorImagenes(imageList,this)
        binding.recyclerView.layoutManager =GridLayoutManager(this, COLUMNAS)
        binding.recyclerView.adapter = galeriaAdapter
        galeriaAdapter.notifyDataSetChanged()
        imageList.add(imagen("https://scontent.flim13-1.fna.fbcdn.net/v/t39.30808-6/245427729_102496052226848_5862517484475516092_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeFEqbQouJSHJX77sBf142g4W_NM3XsNYTVb80zdew1hNSNTT9SpMTdU32ln31A3Kjk&_nc_ohc=NZylETCIPrgAX9cgtxL&_nc_oc=AQniy8IkxnDPgZDg1cyg-gj3gzwbkwbagog00rb-kPLNP5mzGcEgavDwCc8iYO0fuaE&_nc_ht=scontent.flim13-1.fna&oh=00_AT9ADQEXMxlJDvBCDgckfiMF9pRP96JSCAqkTIWlOw5hpQ&oe=628D9FA2","imagen 1"))
        imageList.add(imagen("https://scontent.flim8-1.fna.fbcdn.net/v/t39.30808-6/246248380_102495868893533_7213323236914442036_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeEH2aoLg_b7Xjdh4t4ENawm2yJ4wHRm-RbbInjAdGb5FnpJ6fm3k0hlKPctgEYDsuw&_nc_ohc=q4jJ7n7AtpUAX-fWBrW&_nc_ht=scontent.flim8-1.fna&oh=00_AT-9whtrMsONToOdlK07o0Xg4dSM3_ItXcqKIbCCslx4ow&oe=628E8EC5","iamgen2"))
        galeriaAdapter.notifyDataSetChanged()
    }
}