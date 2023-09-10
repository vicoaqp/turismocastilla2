package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityCalendarioCastillaBinding
import com.turismo.castilla.databinding.ActivityHotelesBinding

class calendario_castilla : AppCompatActivity() {

    private lateinit var binding: ActivityCalendarioCastillaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarioCastillaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyrclearenero.apply {
            layoutManager= LinearLayoutManager(this@calendario_castilla)
        }

        //calendario("enero",binding.recyrclearenero)




    }
   // private fun calendario(dase:String,recyclerView: RecyclerView) {
    //    Toast.makeText(this,dase.toString(), Toast.LENGTH_LONG).show()

    //    FirebaseFirestore.getInstance().collection("calendarioturistico")
     //       .whereEqualTo("idmes",dase)
     //       .get()
     //       .addOnSuccessListener { documents ->
     //           for (document in documents) {
     //               val user = documents.toObjects(UsersCalendario::class.java)
     //               recyclerView.adapter = CalendarioAdapter(this,user)
       //         }
      //      }
        //    .addOnFailureListener{

        //    }
   // }
}