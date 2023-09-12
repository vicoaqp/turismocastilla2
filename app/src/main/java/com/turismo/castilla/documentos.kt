package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityDocumentosBinding
import com.turismo.castilla.modal.UsersDocumentos

class documentos : AppCompatActivity() {
    private lateinit var binding: ActivityDocumentosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDocumentosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var namedocu = intent.extras?.getString("codigodoc")

        binding.RecyclerViewdoc.apply {
            layoutManager= LinearLayoutManager(this@documentos)
        }

        documentodescarga(namedocu.toString())

    }
    private fun documentodescarga(dase:String) {
        Toast.makeText(this,dase.toString(), Toast.LENGTH_LONG).show()

        FirebaseFirestore.getInstance().collection("documentos")
            .whereEqualTo("iddoc",dase)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UsersDocumentos::class.java)
                    binding.RecyclerViewdoc.adapter = DocumentoAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }
    }
}