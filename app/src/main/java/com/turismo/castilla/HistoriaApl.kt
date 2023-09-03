package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.firestore.FirebaseFirestore
import myPages

class HistoriaApl : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_apl)

        var namedistrito = intent.extras?.getString("dist")

        //Toast.makeText(this,distrito.toString(), Toast.LENGTH_LONG).show()

        restaplao(namedistrito.toString())

    }
    private fun restaplao(dase:String) {
        Toast.makeText(this,dase.toString(), Toast.LENGTH_LONG).show()

        FirebaseFirestore.getInstance().collection("distritos")
            .whereEqualTo("idDistrito",dase)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var descridist = document.data.get("descripcion").toString()
                    var diredist = document.data.get("direccion").toString()
                    var alcaldedist = document.data.get("alcalde").toString()
                    var anexodist = document.data.get("anexos").toString()
                    var festidist = document.data.get("festividades").toString()

                }
            }
            .addOnFailureListener{

            }
    }

}