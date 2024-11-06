package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.turismo.castilla.databinding.ActivityEleccionmesBinding

class eleccionmes : AppCompatActivity() {
    private lateinit var binding: ActivityEleccionmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleccionmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nameMes = intent.extras?.getString("Mes")

        binding.recyclerMes.apply {
            layoutManager = LinearLayoutManager(this@eleccionmes)
        }

        elegirmes(nameMes.toString())

        // Configura el botón para redirigir al URL
        binding.buttonIngresar.setOnClickListener {
            val url = "https://forms.gle/mBWaWMEyFs5DQXzT8"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun elegirmes(dase: String) {
        Toast.makeText(this, dase.toString(), Toast.LENGTH_LONG).show()

        FirebaseFirestore.getInstance().collection("calendarioturistico")
            .whereEqualTo("idmes", dase)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = documents.toObjects(UsersCalendario::class.java)
                    binding.recyclerMes.adapter = CalendarioAdapter(this, user)
                }
            }
            .addOnFailureListener {

            }
    }
}