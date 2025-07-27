package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.google.firebase.firestore.FirebaseFirestore

class Eleccion : MenuTodos() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        // Obtener datos del Intent
        val codigoDistrito = intent.extras?.getString("Distrito") ?: "desconocido"
        val codigoVinedos = intent.extras?.getString("codigo")
        val codigoTurismo = intent.extras?.getString("codigos")

        // Inicializar botones
        val btnHistoria = findViewById<Button>(R.id.button_historia)
        val btnQueHacer = findViewById<Button>(R.id.button_quehacer)
        val btnHospedaje = findViewById<Button>(R.id.button_hospedaje)
        val btnGastronomia = findViewById<Button>(R.id.button_gastronomia)
        val btnVinedos = findViewById<Button>(R.id.button_vinedos)

        val textDistrito = findViewById<TextView>(R.id.text_nombre_distrito)

        // Obtener nombre real del distrito desde Firestore
        val db = FirebaseFirestore.getInstance()
        db.collection("distritos")
            .whereEqualTo("idDistrito", codigoDistrito)
            .get()
            .addOnSuccessListener { documentos ->
                if (!documentos.isEmpty) {
                    val nombreReal = documentos.documents[0].getString("namedistrito")
                    textDistrito.text = "Explora: $nombreReal"
                } else {
                    textDistrito.text = "Explora: Distrito desconocido"
                }
            }
            .addOnFailureListener {
                textDistrito.text = "Error al obtener distrito"
            }

        // Configurar visibilidad de botones
        configurarVisibilidadBotones(codigoVinedos, codigoTurismo, btnVinedos, btnHospedaje, btnGastronomia)

        // Configurar acciones de los botones
        btnHistoria.setOnClickListener {
            iniciarActividad(info_distritos::class.java, codigoDistrito, "historia")
        }

        btnQueHacer.setOnClickListener {
            iniciarActividad(DatosTurismo::class.java, codigoDistrito, "turismo")
        }

        btnGastronomia.setOnClickListener {
            iniciarActividad(DatosTurismo::class.java, codigoDistrito, "gastronomia")
        }

        btnHospedaje.setOnClickListener {
            iniciarActividad(DatosTurismo::class.java, codigoDistrito, "hoteles")
        }

        btnVinedos.setOnClickListener {
            iniciarActividad(DatosTurismo::class.java, codigoDistrito, "vinedos")
        }
    }

    // Función para configurar la visibilidad de los botones
    private fun configurarVisibilidadBotones(
        codigoVinedos: String?,
        codigoTurismo: String?,
        btnVinedos: Button,
        btnHospedaje: Button,
        btnGastronomia: Button
    ) {
        if (codigoVinedos == "novino") {
            btnVinedos.visibility = View.INVISIBLE
        }
        if (codigoTurismo == "pocainformacion") {
            btnHospedaje.visibility = View.INVISIBLE
            btnGastronomia.visibility = View.INVISIBLE
        }
    }

    // Función para iniciar actividades
    private fun <T> iniciarActividad(actividad: Class<T>, codigoDistrito: String, eleccion: String) {
        val intent = Intent(this, actividad)
        intent.putExtra("dist", codigoDistrito)
        intent.putExtra("eleccion", eleccion)
        startActivity(intent)
    }
}