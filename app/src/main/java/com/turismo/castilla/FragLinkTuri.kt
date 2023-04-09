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

    var rescelular:String?=""
    var resfacebook:String?=""
    var resmapa:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("dase","entroooo")

        parentFragmentManager.setFragmentResultListener("fraglinkturismo",this,
            FragmentResultListener{reStr:String, data:Bundle ->

                rescelular= data.getString("trcelular")
                resfacebook= data.getString("trfacebook")
                resmapa= data.getString("trmapa")

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
            val face=Intent(Intent.ACTION_VIEW,Uri.parse(""+resfacebook.toString()))
            startActivity(face)
        }


        boton.llamadasturi.setOnClickListener{
            val myUri= Uri.parse("tel:"+rescelular.toString()).let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }

        boton.mapasturi.setOnClickListener{


                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+resmapa.toString()))
                startActivity(mapa)

        }

        boton.galeriaturismo.setOnClickListener{
            val galvar= Intent(context,PortaFotos::class.java)
            galvar.putExtra("Fotosdis","dase")
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