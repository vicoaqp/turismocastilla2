package com.turismo.castilla

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class det_transporte : AppCompatActivity() {

    private lateinit var recyclerViewTransporte: RecyclerView
    private lateinit var transporteAdapter: TransporteAdapter
    private val transportesList = mutableListOf<Transporte>() //MutableList es mejor ya que si no dara un error
    private lateinit var collectionName: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_det_transporte)


        // Obtiene el nombre de la colección del Intent
        collectionName = intent.getStringExtra("collection") ?: "mototaxi" // Valor por defecto

        recyclerViewTransporte = findViewById(R.id.recyclerViewTransporte)
        recyclerViewTransporte.layoutManager = LinearLayoutManager(this)
        transporteAdapter = TransporteAdapter(this, transportesList)
        recyclerViewTransporte.adapter = transporteAdapter

        // Carga los datos de Firebase
        loadTransportesFromFirebase()



    }

    private fun loadTransportesFromFirebase() {
        val db = FirebaseFirestore.getInstance()

        db.collection(collectionName)
            .get()
            .addOnSuccessListener { result ->
                transportesList.clear() // Limpia la lista antes de agregar nuevos datos
                for (document in result) {
                    val transporte = document.toObject(Transporte::class.java)
                    transportesList.add(transporte)
                }
                transporteAdapter.notifyDataSetChanged() // Notifica al adapter que los datos cambiaron
            }
            .addOnFailureListener { exception ->
                // Maneja el error de Firebase
                android.util.Log.w("DetTransporteActivity", "Error getting documents.", exception)
                android.widget.Toast.makeText(this, "Error al cargar los datos", android.widget.Toast.LENGTH_SHORT).show()
            }
    }
}