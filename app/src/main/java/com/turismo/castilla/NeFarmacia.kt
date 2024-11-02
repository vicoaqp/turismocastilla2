package com.turismo.castilla

import android.os.Bundle
import android.widget.ImageView
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNeFarmaciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la variable con el ImageView del binding
        imagegeneralcambio = binding.imagegeneralne

        // Obtener los datos del intent
        val negocate = intent.extras?.getString("categorianegocio")
        val neDistrito = intent.extras?.getString("Distrito")

        // Map para las categorías y sus respectivas imágenes
        val imagenesCategorias = mapOf(
            "farmacia" to R.drawable.backfarmacias,
            "abarrotes" to R.drawable.backabarrotes,
            "emporios" to R.drawable.backcarnicerias,
            "dulceria" to R.drawable.backdulcerias,
            "floreria" to R.drawable.backfloreria,
            "heladerias" to R.drawable.backheladerias,
            "panaderias" to R.drawable.backpanaderias,
            "tamales" to R.drawable.backtamales // imagen por defecto
        )

        // Establecer la imagen correspondiente
        imagegeneralcambio.setImageResource(imagenesCategorias[negocate] ?: R.drawable.backtamales)

        // Configurar el RecyclerView
        binding.recyclerFarmacia.layoutManager = LinearLayoutManager(this)

        // Llamar a la función para elegir el negocio
        neDistrito?.let { elegirNegocio(it, negocate ?: "") }
    }

    private fun elegirNegocio(distrito: String, negocio: String) {
        // Mapeo de categorías a las colecciones de Firebase
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

        // Obtener la colección correspondiente a la categoría
        val coleccion = colecciones[negocio] ?: "negociotamales" // colección por defecto

        FirebaseFirestore.getInstance().collection(coleccion)
            .whereEqualTo("idDistrito", distrito)
            .get()
            .addOnSuccessListener { documents ->
                val userList = documents.toObjects(UserGastrono::class.java)
                binding.recyclerFarmacia.adapter = negociosadapter(this, userList)
            }
            .addOnFailureListener {
                // Manejo de errores aquí (por ejemplo, mostrar un mensaje al usuario)
            }
    }
}