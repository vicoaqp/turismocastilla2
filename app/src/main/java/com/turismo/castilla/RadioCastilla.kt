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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_castilla)

        val botonplay=findViewById<Button>(R.id.button_play)
        val botonpause=findViewById<Button>(R.id.button_pausa)

        botonplay.setOnClickListener {

            val player=ExoPlayer.Builder(this).build()
            val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
            val mediaItem =MediaItem.fromUri("https://stream.zeno.fm/uixbyq7btsutv")
            val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
            player.setMediaSource(mediaSource)
            player.prepare()
            player.playWhenReady = true



        }

        botonpause.setOnClickListener {

            val player=ExoPlayer.Builder(this).build()
           // val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
           // val mediaItem =MediaItem.fromUri("https://stream.zeno.fm/uixbyq7btsutv")
           // val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
           // player.setMediaSource(mediaSource)
            player.pause()
           player.playWhenReady = false
        }

       // setupPlayer()

    }

    private fun setupPlayer(){
        val player=ExoPlayer.Builder(this).build()
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        val mediaItem =MediaItem.fromUri("https://stream.zeno.fm/uixbyq7btsutv")
        val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        player.setMediaSource(mediaSource)
        player.prepare()
        player.playWhenReady = true
    }
}