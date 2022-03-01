package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.turismo.castilla.databinding.ActivityLoginBinding
import com.turismo.castilla.databinding.ActivityMainBinding

class login : AppCompatActivity() {

    lateinit var layout:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(layout.root)


        val db = Firebase.firestore

        val entrar=layout.btningreso
        val salir=layout.btnsalir
        val user=layout.txtlogin
        val pas=layout.txtpas

        var login=false


        salir.setOnClickListener{
            finish()
        }

        entrar.setOnClickListener{

            if(user.toString().isEmpty() || pas.toString().isEmpty()){

            }

                db.collection("usuarios")
                    .whereEqualTo("nick",user.text.toString())
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            if(pas.text.toString() == document.data.get("pas").toString()){
                                login=true
                            }
                        }

                        if(login){
                            startActivity(Intent(this,Distritos::class.java))
                        }
                    }

        }







    }
}