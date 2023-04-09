package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityHotelesBinding
import com.turismo.castilla.databinding.ActivityTurismoBinding

class Turismo : AppCompatActivity() {
    private lateinit var binding:ActivityTurismoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurismoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var namedistrito = intent.extras?.getString("dist")

        binding.recyclerTurismo.apply {
            layoutManager = LinearLayoutManager(this@Turismo)

        }
        turismoaplao(namedistrito.toString())

    }

    private fun turismoaplao(dase:String) {
        //Toast.makeText(this,dase.toString(), Toast.LENGTH_LONG).show()

        FirebaseFirestore.getInstance().collection("turismo")
            .whereEqualTo("idDistrito",dase)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(Usersturismos::class.java)
                    binding.recyclerTurismo.adapter = TurismoAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }
    }

}