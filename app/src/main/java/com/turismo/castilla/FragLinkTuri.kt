package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.turismo.castilla.databinding.FragmentFragLinkTuriBinding
import com.turismo.castilla.databinding.FragmentFrgDBinding


class FragLinkTuri : Fragment() {

    lateinit var fragment:FragmentFragLinkTuriBinding

    var vaturismo:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("dase","entroooo")

        parentFragmentManager.setFragmentResultListener("fturismo",this,
            FragmentResultListener{reStr:String, data:Bundle ->
                vaturismo=data.getString("turisdescrip")
                Log.i("dase",vaturismo.toString())
            }

            )

        //parentFragmentManager.setFragmentResultListener("fragturismo",this,
         //   FragmentResultListener{ reStr:String, data:Bundle ->
           //     vaturismo=data.getString("turismova")
            //    Log.i("dase2",vaturismo.toString())
           // }
       // )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val boton= FragmentFragLinkTuriBinding.inflate(layoutInflater)


        boton.faceturi.setOnClickListener{
            val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/municipiocastilla"))
            startActivity(face)
        }


        boton.llamadasturi.setOnClickListener{
            val myUri= Uri.parse("tel:969734486").let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }

        boton.mapasturi.setOnClickListener{

            if (vaturismo == "castillo") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.978449075791202, -72.53338283063333"))
                startActivity(mapa)

            } else if (vaturismo == "rostrocristo") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.05683247508051, -72.48795624479501"))
                startActivity(mapa)

            }
            else if (vaturismo == "dinosaurio") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.160979873666925, -72.48823058720266"))
                startActivity(mapa)

            }
            else {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.07062750845966, -72.49267661662425"))
                startActivity(mapa)
            }
        }

        boton.galeriaturismo.setOnClickListener{
            val galvar= Intent(context,PortaFotos::class.java)
            galvar.putExtra("Fotosdis",vaturismo)
            startActivity(galvar)
        }


        // Inflate the layout for this fragment
        return boton.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragLinkTuri().apply {
                arguments = Bundle().apply {

                }
            }
    }
}