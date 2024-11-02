package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityHotelesBinding

class Hoteles : MenuTodos() {

    private lateinit var binding: ActivityHotelesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var namedistrito = intent.extras?.getString("dist")

        binding.recyclerHotel.apply {
            layoutManager = LinearLayoutManager(this@Hoteles)

        }

        hotelaplao(namedistrito.toString())

    }



    private fun hotelaplao(dase:String) {
        Toast.makeText(this,dase.toString(), Toast.LENGTH_LONG).show()

        FirebaseFirestore.getInstance().collection("hotel")
            .whereEqualTo("idDistrito",dase)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UsersHoteles::class.java)
                    binding.recyclerHotel.adapter = HotelAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }
    }



}