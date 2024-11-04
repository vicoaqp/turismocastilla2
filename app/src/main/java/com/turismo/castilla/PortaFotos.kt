package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityPortaFotosBinding

class PortaFotos : AppCompatActivity() {

    private lateinit var binding: ActivityPortaFotosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortaFotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namedistrito = intent.extras?.getString("Fotosdis")

        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)

        // Iniciar el indicador de carga y comenzar a obtener los datos
        binding.progressBar.visibility = View.VISIBLE
        fetchData(namedistrito.toString())

        // Configurar el botón para abrir el enlace de Google Forms
        binding.uploadButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/2riHXUrqYRiM5Cky8"))
            startActivity(intent)
        }
    }

    private fun fetchData(dase: String) {
        FirebaseFirestore.getInstance().collection("fotosturismo")
            .whereEqualTo("turismo", dase)
            .get()
            .addOnSuccessListener { documents ->
                val users = documents.toObjects(UserModel::class.java)

                // Configurar el adaptador con los datos obtenidos
                binding.mainRecyclerview.adapter = UserAdapter(this, users)

                // Ocultar el indicador de carga después de cargar los datos
                binding.progressBar.visibility = View.GONE
            }
            .addOnFailureListener {
                // Ocultar el indicador de carga en caso de error
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, "Error al cargar las imágenes", Toast.LENGTH_SHORT).show()
            }
    }
}