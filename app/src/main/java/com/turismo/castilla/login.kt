package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = Firebase.firestore


        /*
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )
        db.collection("usuarios")
        */

        db.collection("usuarios")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.i("result", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.i("result", "Error getting documents.", exception)
            }


    }
}