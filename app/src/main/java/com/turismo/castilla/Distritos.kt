package com.turismo.castilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

class Distritos : MenuTodos() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distritos)



        // Obtiene los valores de los extras
        val lanegocios = intent.extras?.getString("NEGOCIOS")
        val lanmeses = intent.extras?.getString("Mesname")
        val lanmesest = intent.extras?.getString("Mes")

        // Mapa de botones y distritos
        val botonesDistritos = mapOf(
            R.id.button_dAplao to "uyC1afkIWd23narJPGMP",
            R.id.button_dHuancarqui to "7BYUbi0kDD8EZGRvV5UF",
            R.id.button_dUraca to "Y4uQ1LLi2Rvrm0pgbc36",
            R.id.button_dViraco to "85LN38HemVE0bnJUCcMb",
            R.id.button_dPampacolca to "DmRmRNEmsSi86lVFjuEp",
            R.id.button_dMachahuay to "J3GBEeOUxzP8znrNg7xx",
            R.id.button_dAndagua to "Ztu8W2RcUOqFrUZnNkf4",
            R.id.button_dChilcaymarca to "fcVILQojC53q1hnpueQT",
            R.id.button_dUnon to "nII9JY5ZzmaOBWqJtWyl",
            R.id.button_dChachas to "eHCGunMDILDjNjFUR3Vd",
            R.id.button_dChoco to "UKh1aNqrJgH4BseEupyG",
            R.id.button_dTipan to "vmG9JczBTRSSJPPA6muk",
            R.id.button_dAyo to "cikcoCgMQghiaZWKkEvu",
            R.id.button_dOrcopampa to "LpcObyvDvenDre1olyJn"
        )

        // Asigna listeners a cada botón usando un loop
        botonesDistritos.forEach { (buttonId, distritoId) ->
            findViewById<Button>(buttonId).setOnClickListener {
                handleButtonClick(distritoId, lanegocios, lanmeses, lanmesest)
            }
        }
    }

    // Función para manejar el clic en cada botón
    private fun handleButtonClick(distritoId: String, lanegocios: String?, lanmeses: String?, lanmesest: String?) {
        val intent = when {
            lanegocios == "vnegocio" -> Intent(this, Negocios::class.java).apply {
                putExtra("Distrito", distritoId)
            }
            lanmeses == "calendario" -> Intent(this, eleccionmes::class.java).apply {
                putExtra("Mes", lanmesest)
            }
            else -> Intent(this, Eleccion::class.java).apply {
                putExtra("Distrito", distritoId)
                putExtra("codigo", if (distritoId == "uyC1afkIWd23narJPGMP" || distritoId == "85LN38HemVE0bnJUCcMb") "vino" else "novino")

            }
        }
        startActivity(intent)
    }



    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item=menu?.findItem(R.id.act1)
        item?.setVisible(false)
        item?.isEnabled=false
        return super.onPrepareOptionsMenu(menu)
    }


}