package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityEventosInfoBinding

class EventosInfo : AppCompatActivity() {

    private lateinit var binding: ActivityEventosInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventosInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eventoRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@EventosInfo)
        }
        evento()

    }

    private fun evento() {
        FirebaseFirestore.getInstance().collection("eventos")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val usereve = documents.toObjects(UserEventos::class.java)
                    binding.eventoRecyclerview.adapter= UserAdpaterEve(this,usereve)
                }
            }
            .addOnFailureListener{

            }
    }
}