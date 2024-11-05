package com.turismo.castilla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Negocios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_negocios)

        // Obtener el distrito del intent
        val distrito = intent.extras?.getString("Distrito")

        // Mapeo de botones a categorías
        val categorias = mapOf(
            R.id.imageboticas to "farmacia",
            R.id.imagefloreria to "floreria",
            R.id.imageabarrotes to "abarrotes",
            R.id.imagedulceria to "dulceria",
            R.id.imageemporios to "emporios",
            R.id.imageheladerias to "heladerias",
            R.id.imagepanaderias to "panaderias",
            R.id.imagetamales to "tamales"
        )



        // Establecer los click listeners para cada botón
        for ((buttonId, categoria) in categorias) {
            findViewById<ImageView>(buttonId).setOnClickListener {
                abrirActividad(distrito, categoria)
            }
        }


    }

    // Función para abrir la actividad de NeFarmacia
    private fun abrirActividad(distrito: String?, categoria: String) {
        val intent = Intent(this, NeFarmacia::class.java).apply {
            putExtra("Distrito", distrito)
            putExtra("categorianegocio", categoria)
        }
        startActivity(intent)
    }
}