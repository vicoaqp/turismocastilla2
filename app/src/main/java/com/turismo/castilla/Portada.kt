package com.turismo.castilla

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.VideoView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Portada : AppCompatActivity() {

    private lateinit var vvfondo: VideoView
    private var videoapps: String? = null
    private val channelId = "mi_canal_id"

    private lateinit var btnPause: Button // Agregar referencia al botón de pausa
    private var isVideoPaused = false // Variable para rastrear el estado del video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portada)

        vvfondo = findViewById(R.id.videoview)
        btnPause = findViewById(R.id.btnPause) // Inicializar el botón de pausa

        setupNotificationChannel()
        loadVideoFromFirebase()
        setupButtonListeners()
    }

    // Configuración del canal de notificaciones
    private fun setupNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Canal de Notificaciones",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Canal para notificaciones de la app"
            }
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }

    // Carga de video desde Firebase
    private fun loadVideoFromFirebase() {
        FirebaseFirestore.getInstance().collection("videoapp")
            .get()
            .addOnSuccessListener { results ->
                results.firstOrNull()?.let { document ->
                    videoapps = document.data["videolink"]?.toString()
                    playVideo(videoapps)
                }
            }
            .addOnFailureListener {
                Log.e("Portada", "Error al cargar video desde Firebase", it)
            }
    }

    // Reproduce el video si el enlace no es nulo
    private fun playVideo(videoUrl: String?) {
        videoUrl?.let {
            val uri = Uri.parse(it)
            vvfondo.setVideoURI(uri)
            vvfondo.setOnPreparedListener { vvfondo.start() }
            vvfondo.setOnCompletionListener {
                Toast.makeText(this, "Gracias por ver el video", Toast.LENGTH_SHORT).show()
            }
            setupPauseButton() // Configura el botón de pausa
        } ?: run {
            Toast.makeText(this, "No se pudo cargar el video", Toast.LENGTH_SHORT).show()
        }
    }

    // Configura el botón de pausa
    private fun setupPauseButton() {
        btnPause.setOnClickListener {
            if (isVideoPaused) {
                vvfondo.start() // Reanudar video
                btnPause.text = "Pausar el Video" // Cambiar texto a "Pausar"
            } else {
                vvfondo.pause() // Pausar video
                btnPause.text = "Reanudar" // Cambiar texto a "Reanudar"
            }
            isVideoPaused = !isVideoPaused // Alternar estado
        }
    }

    // Configuración de listeners para botones
    private fun setupButtonListeners() {
        setButtonListener(R.id.imageDistritos, Distritos::class.java)
        setButtonListener(R.id.imageViewgaleria, PortaFotos::class.java, "Fotosdis", "aplao")
        setButtonListener(R.id.imageViewcontacto, Desarrollador::class.java)
        setButtonListener(R.id.imageViewCalenda, CalendarioMeses::class.java)
        setButtonListener(R.id.imageViewdescarga, documentos::class.java, "codigodoc", "docu")
        setButtonListener(R.id.imageViewradioonline, RadioCastilla::class.java)
        setButtonListener(R.id.imageViewnegocios, Distritos::class.java, "NEGOCIOS", "vnegocio")
        setButtonListener(R.id.imageViewseguridad, transportes::class.java)
    }

    // Método para asignar listeners a los botones
    private fun <T> setButtonListener(buttonId: Int, activityClass: Class<T>, extraKey: String? = null, extraValue: String? = null) {
        findViewById<ImageView>(buttonId).setOnClickListener {
            val intent = Intent(this, activityClass)
            extraKey?.let { intent.putExtra(it, extraValue) }
            startActivity(intent)
        }
    }

    // Ejemplo de enlace de videos desde Firebase (sin usar aquí pero como ejemplo adicional)
    private fun linkVideos(collection: String) {
        FirebaseFirestore.getInstance().collection(collection)
            .get()
            .addOnSuccessListener { results ->
                for (document in results) {
                    val videoData = document.data["celular"]?.toString()
                    Log.i("linkVideos", "Video: $videoData")
                }
            }
            .addOnFailureListener {
                Log.e("linkVideos", "Error al obtener videos", it)
            }
    }
}