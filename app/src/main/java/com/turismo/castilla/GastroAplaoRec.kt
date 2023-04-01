package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityGastroAplaoRecBinding

class GastroAplaoRec : AppCompatActivity() {

    private lateinit var binding: ActivityGastroAplaoRecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGastroAplaoRecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var namedistrito = intent.extras?.getString("Fotosdis")

        binding.recyclerGastro.apply {
            layoutManager = LinearLayoutManager(this@GastroAplaoRec)

        }
        restaplao(namedistrito.toString())


    }
    private fun restaplao(dase:String) {

        FirebaseFirestore.getInstance().collection("gastroaplaof")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UserModel::class.java)
                    //binding.recyclerGastro.adapter = UserAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }
    }
}