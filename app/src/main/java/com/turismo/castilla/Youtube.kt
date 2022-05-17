package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.youtube.player.YouTubeStandalonePlayer

class Youtube : AppCompatActivity() {

    val API_KEY="AIzaSyBZToK6WovuPcNYyAN6JUe8_B5omSoT6_0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        val reproduciryo=findViewById<Button>(R.id.reproducirId)


        reproduciryo.setOnClickListener {
            val intent=YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,"KpsJWFuVTdI")
            startActivity(intent)
        }
    }
}