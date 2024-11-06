package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityDocumentosBinding
import com.turismo.castilla.modal.UsersDocumentos

class documentos : AppCompatActivity() {
    private lateinit var binding: ActivityDocumentosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namedocu = intent.extras?.getString("codigodoc")

        binding.RecyclerViewdoc.apply {
            layoutManager = LinearLayoutManager(this@documentos)
        }

        // Inicia la carga de documentos
        documentodescarga(namedocu.toString())
    }

    private fun documentodescarga(dase: String) {
        // Mostrar el ProgressBar mientras se carga
        binding.progressBar.visibility = View.VISIBLE


        FirebaseFirestore.getInstance().collection("documentos")
            .whereEqualTo("iddoc", dase)
            .get()
            .addOnSuccessListener { documents ->
                // Ocultar el ProgressBar cuando se haya terminado de cargar
                binding.progressBar.visibility = View.GONE

                // Asumiendo que tienes una clase 'UsersDocumentos' para mapear los datos
                val user = documents.toObjects(UsersDocumentos::class.java)
                binding.RecyclerViewdoc.adapter = DocumentoAdapter(this, user)
            }
            .addOnFailureListener {
                // Si hay error en la carga de los datos, también ocultar el ProgressBar
                binding.progressBar.visibility = View.GONE
            }
    }
}