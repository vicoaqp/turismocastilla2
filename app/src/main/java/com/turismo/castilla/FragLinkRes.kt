package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.turismo.castilla.databinding.FragmentFragLinkResBinding
import com.turismo.castilla.databinding.FragmentFragLinkTuriBinding
import com.turismo.castilla.databinding.FragmentRestauranteBinding



class FragLinkRes : Fragment() {

    lateinit var layout:FragmentFragLinkResBinding
    var linkf:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("dase","entroooo")

       parentFragmentManager.setFragmentResultListener("restsegundo",this,
         FragmentResultListener{reStr:String, data:Bundle ->
               linkf=data.getString("restprimero")
                Log.i("dase",linkf.toString())
           }

        )

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val boton= FragmentFragLinkResBinding.inflate(layoutInflater)

        boton.galleriares.setOnClickListener{

            val galvar= Intent(context,PortaFotos::class.java)
            galvar.putExtra("Fotosdis",linkf)
            startActivity(galvar)

        }

        boton.mapasres.setOnClickListener{

            if (linkf == "rinconcitohuancarqui") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.09204372865129, -72.47436532135633"))
                startActivity(mapa)

            }
            else if (linkf == "rokasbambu") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.088099861678273, -72.49173503098635"))
                startActivity(mapa)
            }
            else if (linkf == "rambo") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.992201342907073, -72.47512998433605"))
                startActivity(mapa)
            }
            else if (linkf == "majesriver") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.992902470159002, -72.4750694661794"))
                startActivity(mapa)
            }
            else if (linkf == "fundoyupanqui") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.978449075791202, -72.53338283063333"))
                startActivity(mapa)
            }
            else if (linkf == "casademauro") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.978449075791202, -72.53338283063333"))
                startActivity(mapa)
            }
            else if (linkf == "fundobarra") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.074615455277076, -72.48997892204497"))
                startActivity(mapa)
            }
            else if (linkf == "titanic") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.07763331455655, -72.48233453568012"))
                startActivity(mapa)
            }
            else if (linkf == "ksamia") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.991566574526704, -72.47542393744975"))
                startActivity(mapa)
            }




        }

        boton.faceres.setOnClickListener{

            if (linkf == "rinconcitohuancarqui") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/rinconcitohuancarquino"))
                startActivity(face)

           }
            else if (linkf == "rokasbambu") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/RokasyBambu"))
                startActivity(face)
           }
            else if (linkf == "rambo") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/cevicheria.rambo.3"))
                startActivity(face)
            }
            else if (linkf == "majesriver") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/groups/294875110694"))
                startActivity(face)
            }
            else if (linkf == "fundoyupanqui") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/fundo.yupanqui.73"))
                startActivity(face)
            }
            else if (linkf == "casademauro") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/LACASADEMAUROTURISMOYAVENTURA"))
                startActivity(face)
            }
            else if (linkf == "fundobarra") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100063548051478"))
                startActivity(face)
            }
            else if (linkf == "titanic") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/RestaurantTitanicAplao"))
                startActivity(face)
            }
            else if (linkf == "ksamia") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Restauranteksamia"))
                startActivity(face)
            }


        }

        return boton.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragLinkRes().apply {
                arguments = Bundle().apply {

                }
            }
    }
}