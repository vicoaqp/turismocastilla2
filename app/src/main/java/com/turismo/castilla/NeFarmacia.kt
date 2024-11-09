package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityEleccionmesBinding
import com.turismo.castilla.databinding.ActivityNeFarmaciaBinding

class NeFarmacia : AppCompatActivity() {
    private lateinit var binding: ActivityNeFarmaciaBinding
    private lateinit var imagegeneralcambio: ImageView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNeFarmaciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imagegeneralcambio = binding.imagegeneralne
        progressBar = binding.progressBar

        val negocate = intent.extras?.getString("categorianegocio")
        val neDistrito = intent.extras?.getString("Distrito")

        val imagenesCategorias = mapOf(
            "farmacia" to R.drawable.backfarmacias,
            "abarrotes" to R.drawable.backabarrotes,
            "emporios" to R.drawable.backcarnicerias,
            "dulceria" to R.drawable.backdulcerias,
            "floreria" to R.drawable.backfloreria,
            "heladerias" to R.drawable.backheladerias,
            "panaderias" to R.drawable.backpanaderias,
            "tamales" to R.drawable.backtamales
        )

        imagegeneralcambio.setImageResource(imagenesCategorias[negocate] ?: R.drawable.backtamales)

        binding.recyclerFarmacia.layoutManager = LinearLayoutManager(this)

        neDistrito?.let { elegirNegocio(neDistrito, negocate ?: "") }

        binding.btnSubeTuNegocio.setOnClickListener {
            val formularioUrl = "https://forms.gle/uqorWBXpBNPX4Vox8"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(formularioUrl))
            startActivity(intent)
        }
    }

    private fun elegirNegocio(distrito: String, negocio: String) {
        // Mostrar el ProgressBar mientras se carga la data
        progressBar.visibility = View.VISIBLE
        binding.recyclerFarmacia.visibility = View.GONE

        val colecciones = mapOf(
            "farmacia" to "negociofarmacia",
            "abarrotes" to "negocioabarrotes",
            "emporios" to "negociocarnicerias",
            "dulceria" to "negociodulceria",
            "floreria" to "negociofloreria",
            "heladerias" to "negocioheladerias",
            "panaderias" to "negociopanaderias",
            "tamales" to "negociotamales"
        )

        val coleccion = colecciones[negocio] ?: "negociotamales"

        FirebaseFirestore.getInstance().collection(coleccion)
            .whereEqualTo("idDistrito", distrito)
            .get()
            .addOnSuccessListener { documents ->
                val userList = documents.toObjects(UserNegociosd::class.java)
                binding.recyclerFarmacia.adapter = negociosadapter(this, userList)
                progressBar.visibility = View.GONE // Ocultar ProgressBar
                binding.recyclerFarmacia.visibility = View.VISIBLE // Mostrar RecyclerView
            }
            .addOnFailureListener {
                // Manejo de errores
                progressBar.visibility = View.GONE // Ocultar ProgressBar
                // Aquí podrías mostrar un mensaje de error si es necesario
            }
    }
}