package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import myPages

class HistoriaApl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_apl)

        val slider=findViewById<ViewPager2>(R.id.slider)
        val adapterSlider= myPages(this)
        slider.adapter=adapterSlider

    }
}