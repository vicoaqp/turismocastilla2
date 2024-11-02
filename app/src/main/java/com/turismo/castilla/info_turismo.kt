package com.turismo.castilla

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.squareup.picasso.Picasso
import com.bumptech.glide.request.target.Target

class info_turismo : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_turismo)

        val vdescripcion = intent.getStringExtra("descripcion")
        val vdireccion = intent.getStringExtra("direccion")
        val vcelular = intent.getStringExtra("celular")
        val vdias = intent.getStringExtra("dias")
        val vhorario = intent.getStringExtra("horario")
        val vfacebook = intent.getStringExtra("facebook")
        val vmapa = intent.getStringExtra("mapa")
        val mapas2 = intent.getStringExtra("mapa2")
        val img1 = intent.getStringExtra("img1")

        val textodes = findViewById<TextView>(R.id.turiprides)
        val textodir = findViewById<TextView>(R.id.turipridireccion)
        val textocel = findViewById<TextView>(R.id.turipricelulares)
        val textodias = findViewById<TextView>(R.id.turipridias)
        val textohora = findViewById<TextView>(R.id.turiprihorarios)
        val btnface = findViewById<Button>(R.id.buttonfacebookturipri)
        val btnmapa = findViewById<Button>(R.id.buttonmapturipri)
        val btnllamada = findViewById<Button>(R.id.buttonllamadaturipri)
        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        // Mostrar el ProgressBar al iniciar la carga
        progressBar.visibility = View.VISIBLE

        Glide.with(this)
            .load(img1)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: com.bumptech.glide.load.DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(imagencabecera)


        textodes.text = vdescripcion ?: "Descripción no disponible"
        textodir.text = vdireccion ?: "Dirección no disponible"
        textocel.text = vcelular ?: "Teléfono no disponible"
        textodias.text = vdias ?: "Días no disponible"
        textohora.text = vhorario ?: "Horario no disponible"


        btnface.setOnClickListener {
            val face = Intent(Intent.ACTION_VIEW, Uri.parse(vfacebook))
            startActivity(face)
        }
        btnmapa.setOnClickListener {
            val intentMapa = Intent(this, Pruebas::class.java).apply {
                putExtra("mapa", vmapa)
                putExtra("mapa2", mapas2)
                putExtra("imagen1", img1)
                putExtra("namehotel", "Turismo")
            }
            startActivity(intentMapa)
        }
        btnllamada.setOnClickListener {
            val intentLlamada = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$vcelular"))
            startActivity(intentLlamada)
        }
    }
}