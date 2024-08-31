package com.turismo.castilla

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityEleccionmesBinding
import com.turismo.castilla.databinding.ActivityNeFarmaciaBinding

class NeFarmacia : AppCompatActivity() {
    private lateinit var binding: ActivityNeFarmaciaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNeFarmaciaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imagegeneralcambio = findViewById<ImageView>(R.id.imagegeneralne)
        var negocate = intent.extras?.getString("categorianegocio")
        var neDistrito = intent.extras?.getString("Distrito")

        if (negocate =="farmacia"){
            imagegeneralcambio.setImageResource(R.drawable.backfarmacias)
        } else if(negocate =="abarrotes"){
            imagegeneralcambio.setImageResource(R.drawable.backabarrotes)
        }else if(negocate =="emporios"){
            imagegeneralcambio.setImageResource(R.drawable.backcarnicerias)
        }else if(negocate =="dulceria"){
            imagegeneralcambio.setImageResource(R.drawable.backdulcerias)
        }else if(negocate =="floreria"){
            imagegeneralcambio.setImageResource(R.drawable.backfloreria)
        }else if(negocate =="heladerias"){
            imagegeneralcambio.setImageResource(R.drawable.backheladerias)
        }else if(negocate =="panaderias"){
            imagegeneralcambio.setImageResource(R.drawable.backpanaderias)
        }else {
            imagegeneralcambio.setImageResource(R.drawable.backtamales)
        }

        binding.recyclerFarmacia.apply {
            layoutManager = LinearLayoutManager(this@NeFarmacia)

        }

        elegirnegocio(neDistrito.toString(),negocate.toString())

    }
    private fun elegirnegocio(dase:String,negocio:String) {

        if (negocio =="farmacia"){
            FirebaseFirestore.getInstance().collection("negociofarmacia")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        } else if(negocio =="abarrotes"){
            FirebaseFirestore.getInstance().collection("negocioabarrotes")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }else if(negocio =="emporios"){
            FirebaseFirestore.getInstance().collection("negociocarnicerias")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }else if(negocio =="dulceria"){
            FirebaseFirestore.getInstance().collection("negociodulceria")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }else if(negocio =="floreria"){
            FirebaseFirestore.getInstance().collection("negociofloreria")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }else if(negocio =="heladerias"){
            FirebaseFirestore.getInstance().collection("negocioheladerias")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }else if(negocio =="panaderias"){
            FirebaseFirestore.getInstance().collection("negociopanaderias")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }else {
            FirebaseFirestore.getInstance().collection("negociotamales")
                .whereEqualTo("idDistrito",dase)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(UserGastrono::class.java)
                        binding.recyclerFarmacia.adapter = negociosadapter(this,user)
                    }
                }
                .addOnFailureListener{
                }
        }


    }

}