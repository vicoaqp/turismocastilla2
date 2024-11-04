package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityTurismoBinding

class Turismo : AppCompatActivity() {
    private lateinit var binding: ActivityTurismoBinding
    private lateinit var imagegeneralcambio: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurismoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imagegeneralcambio = binding.imagedesav

        val namedistrito = intent.extras?.getString("dist")
        val nameeleccion = intent.extras?.getString("eleccion")


        val imagenesEleccion = mapOf(
            "turismo" to R.drawable.lugares,
            "gastronomia" to R.drawable.gastronomiappp,
            "hoteles" to R.drawable.hotelespp,
            "vinedos" to R.drawable.vinedosp
        )

        imagegeneralcambio.setImageResource(imagenesEleccion[nameeleccion] ?: R.drawable.lugares)



        binding.recyclerTurismo.layoutManager = LinearLayoutManager(this)

        namedistrito?.let { elegirNegocio(it, nameeleccion ?: "") }



        // Llama a la función para obtener datos
        //turismoaplao(namedistrito.toString())

        // Configura el botón para abrir el enlace de Google Forms
        binding.uploadButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/4FR5zExQK7NWqJXt7"))
            startActivity(intent)
        }
    }

    private fun elegirNegocio(distrito: String, eleccion: String) {
        val colecciones = mapOf(
            "turismo" to "turismo",
            "gastronomia" to "restauran", // Verifica que sea "restauran"
            "hoteles" to "hotel",
            "vinedos" to "vinedos"
        )

        val coleccion = colecciones[eleccion] ?: "turismo" // colección por defecto
        Log.d("Firebase", "Colección seleccionada: $coleccion, Distrito: $distrito")

        FirebaseFirestore.getInstance().collection(coleccion)
            .whereEqualTo("idDistrito", distrito)
            .get()
            .addOnSuccessListener { documents ->
                Log.d("Firebase", "Documentos obtenidos: ${documents.size()}")
                if (documents.isEmpty) {
                    Log.d("Firebase", "No se encontraron documentos para la colección $coleccion y distrito $distrito")
                }
                when (coleccion) {
                    "turismo" -> {
                        val user = documents.toObjects(Usersturismos::class.java)
                        binding.recyclerTurismo.adapter = TurismoAdapter(this, user)
                    }
                    "gastronomia" -> {
                        val userGastrono = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerTurismo.adapter = GastroAdapter(this, userGastrono)
                    }
                    "hoteles" -> {
                        val usersHoteles = documents.toObjects(UsersHoteles::class.java)
                        binding.recyclerTurismo.adapter = HotelAdapter(this, usersHoteles)
                    }
                    "vinedos" -> {
                        val usersVinedos = documents.toObjects(UsersVinedos::class.java)
                        binding.recyclerTurismo.adapter = VinedosAdapter(this, usersVinedos)
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.e("Firebase", "Error al obtener documentos: ", exception)
            }
    }

}