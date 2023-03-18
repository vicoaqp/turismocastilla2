package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        var namedistrito = intent.extras?.getString("Fotosdis")

        binding.mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PortaFotos)
        }
        fetchData(namedistrito.toString())

    }

    private fun fetchData(dase:String) {

        if (dase == "aplao") {
            Toast.makeText(this,"aplaosalio",Toast.LENGTH_LONG).show()
            FirebaseFirestore.getInstance().collection("fotoaplao")
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
        else if(dase =="huancarqui"){
            Toast.makeText(this,"huancarquisalio",Toast.LENGTH_LONG).show()

            FirebaseFirestore.getInstance().collection("fotoshuancarqui")
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
        else if(dase =="uraca"){

            FirebaseFirestore.getInstance().collection("fotosuraca")
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
        else if(dase =="viraco"){
            FirebaseFirestore.getInstance().collection("fotoviraco")
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
        else if(dase =="pampacolca"){
            FirebaseFirestore.getInstance().collection("fotopampacolca")
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
        else if(dase =="machahuay"){
            FirebaseFirestore.getInstance().collection("fotomachahuay")
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
        else if(dase =="andagua"){
            FirebaseFirestore.getInstance().collection("fotoandagua")
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
        else if(dase =="chilcaymarca"){
            FirebaseFirestore.getInstance().collection("fotochilcaymarca")
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
        else if(dase =="unon"){
            FirebaseFirestore.getInstance().collection("fotounon")
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
        else if(dase =="choco"){
            FirebaseFirestore.getInstance().collection("fotochoco")
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
        else if(dase =="chachas"){
            FirebaseFirestore.getInstance().collection("fotochachas")
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
        else if(dase =="tipan"){
            FirebaseFirestore.getInstance().collection("fototipan")
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
        else if(dase =="ayo"){
            FirebaseFirestore.getInstance().collection("fotoayo")
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
        else if(dase =="orcopampa"){
            FirebaseFirestore.getInstance().collection("fotoorcopampa")
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
        else if(dase =="general"){
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
        else if(dase =="castillo"){
            FirebaseFirestore.getInstance().collection("fototcastillo")
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

        else if(dase =="dinosaurio"){
            FirebaseFirestore.getInstance().collection("fototdinosaurio")
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


        /*FirebaseFirestore.getInstance().collection("fotos")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UserModel::class.java)
                    binding.mainRecyclerview.adapter= UserAdapter(this,user)
                }
            }
            .addOnFailureListener{

            }*/
    }
}