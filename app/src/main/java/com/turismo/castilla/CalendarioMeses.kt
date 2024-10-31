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
            Pair(R.id.imageVieweneroc, "L8DuAa4bfEdX7KDrQaRS"),
            Pair(R.id.imageViewfebreroc, "QLslVX7MzTFgCUc7tNVd"),
            Pair(R.id.imageViewmarzoc, "Z11roQ8tUYTzKZdyEf69"),
            Pair(R.id.imageViewabrilc, "5wbRpujsd0rCAOe2hJZY"),
            Pair(R.id.imageViewmayoc, "uxopdIZ1J09tY8rjDCuN"),
            Pair(R.id.imageViewjunioc, "RWyr3D4ZacZ04o1S6HmB"),
            Pair(R.id.imageViewjulioc, "Ulzrpb1o84gp7Uw8iGe9"),
            Pair(R.id.imageViewagostoc, "9mA9rA1Cl6gOgNq4OgPw"),
            Pair(R.id.imageViewsetiembrec, "sDIDKGySSe90dhSmQayt"),
            Pair(R.id.imageViewoctubrec, "qFz38Ev3KkOJ1tjT9HjE"),
            Pair(R.id.imageViewnoviembrec, "ggcPsGWL8US0wbbWaTML"),
            Pair(R.id.imageViewdiciembrec, "62riMfD9ohh01NzN8f7f")
        )

        // Configuración de listeners para cada mes usando un bucle
        mesesData.forEach { (imageViewId, mesId) ->
            findViewById<ImageView>(imageViewId).setOnClickListener {
                val intent = Intent(this, Distritos::class.java).apply {
                    putExtra("Mes", mesId)
                    putExtra("Mesname", "calendario")
                }
                startActivity(intent)
            }
        }


    }
}