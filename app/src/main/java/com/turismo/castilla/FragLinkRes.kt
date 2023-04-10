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
    var rescelular:String?=""
    var resfacebook:String?=""
    var resmapa:String?=""
    var residRestaurante:String?=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       parentFragmentManager.setFragmentResultListener("fragmresta",this,
         FragmentResultListener{reStr:String, data:Bundle ->

             rescelular= data.getString("FRcelular")
             resfacebook= data.getString("FRfacebook")
             resmapa= data.getString("FRmapa")
             residRestaurante=data.getString("FRidRestaurante")

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
            galvar.putExtra("Fotosdis",residRestaurante)
            startActivity(galvar)

        }

        boton.mapasres.setOnClickListener{
            val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+resmapa.toString()))
            startActivity(mapa)
        }

        boton.faceres.setOnClickListener{

                val face=Intent(Intent.ACTION_VIEW,Uri.parse(""+resfacebook.toString()))
                startActivity(face)
        }
        boton.llamadasres.setOnClickListener{
            val myUri= Uri.parse("tel:"+rescelular.toString()).let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
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