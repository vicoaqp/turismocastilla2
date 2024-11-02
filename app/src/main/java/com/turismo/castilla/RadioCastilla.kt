package com.turismo.castilla

import android.content.Intent
import android.media.browse.MediaBrowser
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.api.Distribution

class RadioCastilla : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private val streamUrl = "https://stream.zeno.fm/uixbyq7btsutv"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_castilla)

        val botonPlay = findViewById<Button>(R.id.button_play)
        val botonPause = findViewById<Button>(R.id.button_pausa)

        // Inicializar el reproductor
        initializePlayer()

        botonPlay.setOnClickListener {
            player?.playWhenReady = true // Reproducir
        }

        botonPause.setOnClickListener {
            player?.playWhenReady = false // Pausar
        }
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().apply {
            val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
            val mediaItem = MediaItem.fromUri(streamUrl)
            val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
            setMediaSource(mediaSource)
            prepare()
        }
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    private fun releasePlayer() {
        player?.release()
        player = null
    }

    override fun onDestroy() {
        super.onDestroy()
        releasePlayer() // Asegurarse de liberar recursos al destruir la actividad
    }
}