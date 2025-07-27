package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class CalendarioMeses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario_meses)

        // Lista de pares con los IDs de los ImageViews y sus datos correspondientes
        val mesesData = listOf(
            Pair(R.id.imageVieweneroc, "enero"),
            Pair(R.id.imageViewfebreroc, "febrero"),
            Pair(R.id.imageViewmarzoc, "marzo"),
            Pair(R.id.imageViewabrilc, "abril"),
            Pair(R.id.imageViewmayoc, "mayo"),
            Pair(R.id.imageViewjunioc, "junio"),
            Pair(R.id.imageViewjulioc, "julio"),
            Pair(R.id.imageViewagostoc, "agosto"),
            Pair(R.id.imageViewsetiembrec, "setiembre"),
            Pair(R.id.imageViewoctubrec, "octubre"),
            Pair(R.id.imageViewnoviembrec, "noviembre"),
            Pair(R.id.imageViewdiciembrec, "diciembre")
        )

        // Configuración de listeners para cada mes usando un bucle
        mesesData.forEach { (imageViewId, mesId) ->
            findViewById<ImageView>(imageViewId).setOnClickListener {
                val intent = Intent(this, eleccionmes::class.java).apply {
                    putExtra("Mes", mesId)
                    //putExtra("Mesname", "calendario")
                }
                startActivity(intent)
            }
        }


    }
}