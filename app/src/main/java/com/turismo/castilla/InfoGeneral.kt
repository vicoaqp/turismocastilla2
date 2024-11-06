package com.turismo.castilla

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class InfoGeneral : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "idgeneral"
        const val EXTRA_CELULAR = "celularg"
        const val EXTRA_DESCRIPCION = "descripciong"
        const val EXTRA_DIAS = "diasg"
        const val EXTRA_DIRECCION = "direcciong"
        const val EXTRA_HORARIO = "horariog"
        const val EXTRA_NAME = "nameg"
        const val EXTRA_FACEBOOK = "facebookg"
        const val EXTRA_MAPA = "mapag"
        const val EXTRA_MAPA2 = "mapag2"
        const val EXTRA_IMG1 = "img1"
        const val EXTRA_IMG2 = "img2"
        const val EXTRA_IMG3 = "img3"
        const val EXTRA_IMG4 = "img4"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_general)

        // Recoger datos del Intent con valores predeterminados
        val vgnameid = intent.getStringExtra(EXTRA_ID) ?: ""
        val vgcelular = intent.getStringExtra(EXTRA_CELULAR) ?: ""
        val vgdescripcion = intent.getStringExtra(EXTRA_DESCRIPCION) ?: ""
        val vgdias = intent.getStringExtra(EXTRA_DIAS) ?: ""
        val vgdireccion = intent.getStringExtra(EXTRA_DIRECCION) ?: ""
        val vghorario = intent.getStringExtra(EXTRA_HORARIO) ?: ""
        val vnamegeneral = intent.getStringExtra(EXTRA_NAME) ?: ""
        val vgfacebook = intent.getStringExtra(EXTRA_FACEBOOK) ?: ""
        val vgmapa = intent.getStringExtra(EXTRA_MAPA) ?: ""
        val vgmapas2 = intent.getStringExtra(EXTRA_MAPA2) ?: ""
        val img1 = intent.getStringExtra(EXTRA_IMG1) ?: ""
        val img2 = intent.getStringExtra(EXTRA_IMG2) ?: ""
        val img3 = intent.getStringExtra(EXTRA_IMG3) ?: ""
        val img4 = intent.getStringExtra(EXTRA_IMG4) ?: ""

        // Configurar las vistas
        setupViews(vgdescripcion, vgdireccion, vgcelular, vgdias, vghorario, img1)

        // Configurar los botones
        setupButtons(vgfacebook, vgcelular, vgmapa, vgmapas2, vnamegeneral, img1)
    }

    private fun setupViews(
        descripcion: String,
        direccion: String,
        celular: String,
        dias: String,
        horario: String,
        img1: String
    ) {
        findViewById<TextView>(R.id.gdes).text = descripcion
        findViewById<TextView>(R.id.gdireccion).text = direccion
        findViewById<TextView>(R.id.gcelulares).text = celular
        findViewById<TextView>(R.id.gdias).text = dias
        findViewById<TextView>(R.id.ghorarios).text = horario

        val imagencabecera = findViewById<ImageView>(R.id.imageViewcabecera)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        // Mostrar el ProgressBar antes de cargar la imagen
        progressBar.visibility = View.VISIBLE

        // Usar Glide para cargar la imagen y ocultar el ProgressBar cuando haya terminado
        Glide.with(this)
            .load(img1)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean
                ): Boolean {
                    // Si la carga falla, ocultamos el ProgressBar
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean
                ): Boolean {
                    // Cuando la imagen se haya cargado con éxito, ocultamos el ProgressBar
                    progressBar.visibility = View.GONE
                    return false
                }
            })
            .transition(DrawableTransitionOptions.withCrossFade())  // Opcional, para un efecto suave de transición
            .into(imagencabecera)
    }

    private fun setupButtons(
        facebookUrl: String,
        celular: String,
        mapaUrl: String,
        mapa2Url: String,
        name: String,
        img1: String
    ) {
        findViewById<Button>(R.id.buttonmapg).setOnClickListener {
            val intentMap = Intent(this, Pruebas::class.java).apply {
                putExtra("mapa", mapaUrl)
                putExtra("mapa2", mapa2Url)
                putExtra("namehotel", name)
                putExtra("imagen1", img1)
            }
            startActivity(intentMap)
        }

        findViewById<Button>(R.id.buttonfacebookg).setOnClickListener {
            val intentFacebook = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
            startActivity(intentFacebook)
        }

        findViewById<Button>(R.id.buttonllamadag).setOnClickListener {
            val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$celular"))
            startActivity(intentCall)
        }
    }
}