package com.turismo.castilla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Negocios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_negocios)

        val btnnefarmacia = findViewById<ImageView>(R.id.imageboticas)
        val btnnefloreria = findViewById<ImageView>(R.id.imagefloreria)
        val btnneabarrotes = findViewById<ImageView>(R.id.imageabarrotes)
        val btnnedulceria = findViewById<ImageView>(R.id.imagedulceria)
        val btnneemporios = findViewById<ImageView>(R.id.imageemporios)
        val btnneheladerias = findViewById<ImageView>(R.id.imageheladerias)
        val btnnepanaderias = findViewById<ImageView>(R.id.imagepanaderias)
        val btnnetamales = findViewById<ImageView>(R.id.imagetamales)


        var lannegodistrito = intent.extras?.getString("Distrito")

        btnnetamales.setOnClickListener{
            val tamales= Intent(this,NeFarmacia::class.java)
            tamales.putExtra("Distrito",lannegodistrito)
            tamales.putExtra("categorianegocio","tamales")
            startActivity(tamales)
        }


        btnnepanaderias.setOnClickListener{
            val panaderias= Intent(this,NeFarmacia::class.java)
            panaderias.putExtra("Distrito",lannegodistrito)
            panaderias.putExtra("categorianegocio","panaderias")
            startActivity(panaderias)
        }

        btnneheladerias.setOnClickListener{
            val heladerias= Intent(this,NeFarmacia::class.java)
            heladerias.putExtra("Distrito",lannegodistrito)
            heladerias.putExtra("categorianegocio","heladerias")
            startActivity(heladerias)
        }

        btnneemporios.setOnClickListener{
            val emporios= Intent(this,NeFarmacia::class.java)
            emporios.putExtra("Distrito",lannegodistrito)
            emporios.putExtra("categorianegocio","emporios")
            startActivity(emporios)
        }


        btnnedulceria.setOnClickListener{
            val dulceria= Intent(this,NeFarmacia::class.java)
            dulceria.putExtra("Distrito",lannegodistrito)
            dulceria.putExtra("categorianegocio","dulceria")
            startActivity(dulceria)
        }

        btnnedulceria.setOnClickListener{
            val dulceria= Intent(this,NeFarmacia::class.java)
            dulceria.putExtra("Distrito",lannegodistrito)
            dulceria.putExtra("categorianegocio","dulceria")
            startActivity(dulceria)
        }

        btnnefarmacia.setOnClickListener{
            val farmacia= Intent(this,NeFarmacia::class.java)
            farmacia.putExtra("Distrito",lannegodistrito)
            farmacia.putExtra("categorianegocio","farmacia")
            startActivity(farmacia)
        }
        btnnefloreria.setOnClickListener{
            val floreria= Intent(this,NeFarmacia::class.java)
            floreria.putExtra("Distrito",lannegodistrito)
            floreria.putExtra("categorianegocio","floreria")
            startActivity(floreria)
        }
        btnneabarrotes.setOnClickListener{
            val abarrotes= Intent(this,NeFarmacia::class.java)
            abarrotes.putExtra("Distrito",lannegodistrito)
            abarrotes.putExtra("categorianegocio","abarrotes")
            startActivity(abarrotes)
        }

    }
}