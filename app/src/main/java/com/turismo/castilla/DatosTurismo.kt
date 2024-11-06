package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityDatosTurismoBinding


class DatosTurismo : AppCompatActivity() {

    private lateinit var binding: ActivityDatosTurismoBinding
    private lateinit var imagegeneralcambio: ImageView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosTurismoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imagegeneralcambio = binding.imagedesav
        progressBar = binding.progressBar // Inicializar el ProgressBar

        val namedistrito = intent.extras?.getString("dist")
        val nameeleccion = intent.extras?.getString("eleccion")

        val imagenesEleccion = mapOf(
            "turismo" to R.drawable.lugares,
            "gastronomia" to R.drawable.gastronomiappp,
            "hoteles" to R.drawable.hotelespp,
            "vinedos" to R.drawable.vinedosp
        )

        imagegeneralcambio.setImageResource(imagenesEleccion[nameeleccion] ?: R.drawable.lugares)

        binding.recyclerdTurismo.layoutManager = LinearLayoutManager(this)

        namedistrito?.let { elegirNegocio(it, nameeleccion ?: "") }

        // Configura el botón para abrir el enlace de Google Forms
        binding.uploadButton.setOnClickListener {
            val url = when (nameeleccion) {
                "turismo" -> "https://forms.gle/4FR5zExQK7NWqJXt7"
                "gastronomia" -> "https://forms.gle/1F4aPaqRZfZLEpxE7"
                "hoteles" -> "https://forms.gle/UZCNtkM3znU9gCwW7"
                "vinedos" -> "https://forms.gle/kg8htmm1cQLeet147"
                else -> "https://forms.gle/4FR5zExQK7NWqJXt7" // Default to turismo if no match
            }

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun elegirNegocio(distrito: String, eleccion: String) {
        val colecciones = mapOf(
            "turismo" to "turismo",
            "gastronomia" to "restauran",
            "hoteles" to "hotel",
            "vinedos" to "vinedos"
        )

        val coleccion = colecciones[eleccion] ?: "turismo"

        val itemType = when (coleccion) {
            "turismo" -> DatosAdapter.ItemType.TURISMO
            "restauran" -> DatosAdapter.ItemType.GASTRONOMIA
            "hotel" -> DatosAdapter.ItemType.HOTELES
            "vinedos" -> DatosAdapter.ItemType.VINEDO
            else -> DatosAdapter.ItemType.TURISMO
        }

        // Mostrar el ProgressBar antes de obtener los datos
        progressBar.visibility = View.VISIBLE

        FirebaseFirestore.getInstance().collection(coleccion)
            .whereEqualTo("idDistrito", distrito)
            .get()
            .addOnSuccessListener { documents ->
                // Ocultar el ProgressBar después de obtener los datos
                progressBar.visibility = View.GONE

                when (itemType) {
                    DatosAdapter.ItemType.TURISMO -> {
                        val items = documents.toObjects(Usersturismos::class.java)
                        binding.recyclerdTurismo.adapter = DatosAdapter(this, items, DatosAdapter.TURISMO)
                    }
                    DatosAdapter.ItemType.GASTRONOMIA -> {
                        val items = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerdTurismo.adapter = DatosAdapter(this, items, DatosAdapter.GASTRONOMIA)
                    }
                    DatosAdapter.ItemType.HOTELES -> {
                        val items = documents.toObjects(UsersHoteles::class.java)
                        binding.recyclerdTurismo.adapter = DatosAdapter(this, items, DatosAdapter.HOTELES)
                    }
                    DatosAdapter.ItemType.VINEDO -> {
                        val items = documents.toObjects(UsersVinedos::class.java)
                        binding.recyclerdTurismo.adapter = DatosAdapter(this, items, DatosAdapter.VINEDOS)
                    }
                }
            }
            .addOnFailureListener { exception ->
                // Ocultar el ProgressBar si ocurre un error
                progressBar.visibility = View.GONE
                Log.e("Firebase", "Error al obtener documentos: ", exception)
            }
    }
}