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

        val botonenero=findViewById<ImageView>(R.id.imageVieweneroc)
        val botonfebrero=findViewById<ImageView>(R.id.imageViewfebreroc)
        val botonmarzo=findViewById<ImageView>(R.id.imageViewmarzoc)
        val botonabril=findViewById<ImageView>(R.id.imageViewabrilc)
        val botonmayo=findViewById<ImageView>(R.id.imageViewmayoc)
        val botonjunio=findViewById<ImageView>(R.id.imageViewjunioc)
        val botonjulio=findViewById<ImageView>(R.id.imageViewjulioc)
        val botonagosto=findViewById<ImageView>(R.id.imageViewagostoc)
        val botonsetiembre=findViewById<ImageView>(R.id.imageViewsetiembrec)
        val botonoctubre=findViewById<ImageView>(R.id.imageViewoctubrec)
        val botonnoviembre=findViewById<ImageView>(R.id.imageViewnoviembrec)
        val botondiciembre=findViewById<ImageView>(R.id.imageViewdiciembrec)


        botonenero.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","L8DuAa4bfEdX7KDrQaRS")
            orco.putExtra("Mesname","calendario")
            startActivity(orco)

        }
        botonfebrero.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","QLslVX7MzTFgCUc7tNVd")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonmarzo.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","Z11roQ8tUYTzKZdyEf69")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonabril.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","5wbRpujsd0rCAOe2hJZY")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonmayo.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","uxopdIZ1J09tY8rjDCuN")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonjunio.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","RWyr3D4ZacZ04o1S6HmB")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonjulio.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","Ulzrpb1o84gp7Uw8iGe9")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonagosto.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","9mA9rA1Cl6gOgNq4OgPw")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonsetiembre.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","sDIDKGySSe90dhSmQayt")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonoctubre.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","qFz38Ev3KkOJ1tjT9HjE")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botonnoviembre.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","ggcPsGWL8US0wbbWaTML")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
        botondiciembre.setOnClickListener {

            val orco= Intent(this,Distritos::class.java)
            orco.putExtra("Mes","62riMfD9ohh01NzN8f7f")
            orco.putExtra("Mesname","caledanrio")
            startActivity(orco)

        }
    }
}