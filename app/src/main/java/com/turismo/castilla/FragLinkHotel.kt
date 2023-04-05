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
import com.turismo.castilla.databinding.FragmentFragDesHotelBinding
import com.turismo.castilla.databinding.FragmentFragLinkHotelBinding
import com.turismo.castilla.databinding.FragmentFragLinkResBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragLinkHotel.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragLinkHotel : Fragment() {

    lateinit var layout: FragmentFragLinkHotelBinding

    var rescelular:String?=""
    var resfacebook:String?=""
    var resmapa:String?=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("fraglinkhotel",this,
            FragmentResultListener{reStr:String, data:Bundle ->

                rescelular= data.getString("HTcelular")
                resfacebook= data.getString("HTfacebook")
                resmapa= data.getString("HTmapa")

            }

        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val boton= FragmentFragLinkHotelBinding.inflate(layoutInflater)

        boton.galleriahotel.setOnClickListener{

            val galvar= Intent(context,PortaFotos::class.java)
            //galvar.putExtra("Fotosdis",linkf)
            startActivity(galvar)

        }

        boton.mapp.setOnClickListener{
            val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+resmapa.toString()))
            startActivity(mapa)
        }

        boton.facep.setOnClickListener{

            val face=Intent(Intent.ACTION_VIEW,Uri.parse(""+resfacebook.toString()))
            startActivity(face)
        }
        boton.llamadap.setOnClickListener{
            val myUri= Uri.parse("tel:"+rescelular.toString()).let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }
        return boton.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragLinkHotel.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragLinkHotel().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}