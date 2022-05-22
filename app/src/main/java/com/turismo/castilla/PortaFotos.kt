package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityPortaFotosBinding

class PortaFotos : AppCompatActivity() {

    private lateinit var binding: ActivityPortaFotosBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPortaFotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PortaFotos)
        }
        fetchData()

    }

    private fun fetchData() {

        FirebaseFirestore.getInstance().collection("fotos")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UserModel::class.java)
                    binding.mainRecyclerview.adapter= UserAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }
    }
}