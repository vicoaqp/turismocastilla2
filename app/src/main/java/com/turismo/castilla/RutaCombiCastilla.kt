package com.turismo.castilla

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class RutaCombiCastilla : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var rutaCombiAdapter: RutaCombiAdapter
    private val rutasCombiList: MutableList<RutaCombi> = mutableListOf()
    private val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ruta_combi_castilla)


        recyclerView = findViewById(R.id.recyclerViewRutasCombi)
        recyclerView.layoutManager = LinearLayoutManager(this)

        rutaCombiAdapter = RutaCombiAdapter(rutasCombiList)
        recyclerView.adapter = rutaCombiAdapter

        loadRutasFromFirestore()



    }

    private fun loadRutasFromFirestore() {
        db.collection("rutastransporte")
            .get()
            .addOnSuccessListener { result ->
                rutasCombiList.clear()
                for (document in result) {
                    val inicio = document.getString("inicio") ?: ""
                    val fin = document.getString("fin") ?: ""
                    val imageUrl = document.getString("imageUrl") ?: ""
                    val geoinicio = document.getGeoPoint("geoinicio")
                    val geofinal = document.getGeoPoint("geofinal")
                    val ruta = RutaCombi(inicio, fin, imageUrl, geoinicio, geofinal)
                    rutasCombiList.add(ruta)
                }
                rutaCombiAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }
}