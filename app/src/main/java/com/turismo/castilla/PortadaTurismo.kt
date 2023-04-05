package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.VideoView
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityGastroAplaoRecBinding
import com.turismo.castilla.databinding.ActivityPortadaTurismoBinding

class PortadaTurismo : AppCompatActivity() {

    private lateinit var binding: ActivityPortadaTurismoBinding
    //protected lateinit var turismovideof: VideoView
    //var videoappst:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortadaTurismoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseFirestore.getInstance().collection("videoapp")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    //Log.i("dasess",resultadosvideo.toString())
                    var videoappst = document.data.get("videolink").toString()
                    Log.i("valorvideos",videoappst.toString())
                    Toast.makeText(this,videoappst.toString(), Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener{
            }

    }
}