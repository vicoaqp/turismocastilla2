package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible

class Eleccion : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        // Obtener datos del Intent
        val nombreDistrito = intent.extras?.getString("Distrito") ?: "Distrito Desconocido"
        val codigoDist = intent.extras?.getString("codigo")
        val codigoChoco = intent.extras?.getString("codigos")

        // Mostrar el nombre del distrito
        Toast.makeText(this, nombreDistrito, Toast.LENGTH_LONG).show()

        // Inicializar botones
        val btnHistoria = findViewById<Button>(R.id.button_historia)
        val btnQueHacer = findViewById<Button>(R.id.button_quehacer)
        val btnHospedaje = findViewById<Button>(R.id.button_hospedaje)
        val btnGastronomia = findViewById<Button>(R.id.button_gastronomia)
        val btnVinedos = findViewById<Button>(R.id.button_vinedos)

        // Configurar visibilidad de botones
        configurarVisibilidadBotones(codigoDist, codigoChoco, btnVinedos, btnHospedaje, btnGastronomia)

        // Configurar listeners de botones
        btnHistoria.setOnClickListener { iniciarActividad(info_distritos::class.java, nombreDistrito) }
        btnQueHacer.setOnClickListener { iniciarActividad(Turismo::class.java, nombreDistrito) }
        btnGastronomia.setOnClickListener { iniciarActividad(GastroAplaoRec::class.java, nombreDistrito) }
        btnHospedaje.setOnClickListener { iniciarActividad(Hoteles::class.java, nombreDistrito) }
        btnVinedos.setOnClickListener { iniciarActividad(Vinedos::class.java, nombreDistrito) }
    }

    // Función para configurar la visibilidad de los botones
    private fun configurarVisibilidadBotones(codigoDist: String?, codigoChoco: String?, btnVinedos: Button, btnHospedaje: Button, btnGastronomia: Button) {
        if (codigoDist == "novino") {
            btnVinedos.visibility = View.INVISIBLE
        }
        if (codigoChoco == "pocainformacion") {
            btnHospedaje.visibility = View.INVISIBLE
            btnGastronomia.visibility = View.INVISIBLE
        }
    }

    // Función para iniciar actividades
    private fun <T> iniciarActividad(actividad: Class<T>, nombreDistrito: String) {
        val intent = Intent(this, actividad)
        intent.putExtra("dist", nombreDistrito)
        startActivity(intent)
    }
}