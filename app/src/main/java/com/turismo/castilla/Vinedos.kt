package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityVinedosBinding

class Vinedos : AppCompatActivity() {

    private lateinit var binding: ActivityVinedosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVinedosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var namedistrito = intent.extras?.getString("dist")


        binding.recyclervinedos.apply {
            layoutManager = LinearLayoutManager(this@Vinedos)
        }
       //vinedosaplao(namedistrito.toString())

    }
    /*
    private fun vinedosaplao(dase:String) {

        FirebaseFirestore.getInstance().collection("vinedos")
            .whereEqualTo("idDistrito",dase)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UsersVinedos::class.java)
                    binding.recyclervinedos.adapter = VinedosAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }
    }

     */

}