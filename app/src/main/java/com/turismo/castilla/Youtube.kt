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
        val reproduciryo2=findViewById<Button>(R.id.reproducirId2)
        val reproduciryo3=findViewById<Button>(R.id.reproducirId3)

        reproduciryo.setOnClickListener {
            val intent=YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,"e97O84XaGN0")
            startActivity(intent)
        }
        reproduciryo2.setOnClickListener {
            val intent=YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,"onV9keyudPQ")
            startActivity(intent)
        }

        reproduciryo3.setOnClickListener {
            val intent=YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,"24LzP1nFW4k")
            startActivity(intent)
        }
    }
}