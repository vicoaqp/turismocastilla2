package com.turismo.castilla

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentResultListener
import com.turismo.castilla.databinding.FragmentFragLinkHotelBinding
import com.turismo.castilla.databinding.FragmentFragLinkVinedosBinding


class FragLinkVinedos : Fragment() {

    lateinit var layout: FragmentFragLinkVinedosBinding
    var rescelular:String?=""
    var resfacebook:String?=""
    var resmapa:String?=""
    var residVinedos:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("fraglinkvino",this,
            FragmentResultListener{ reStr:String, data:Bundle ->

                rescelular= data.getString("vtcelular")
                resfacebook= data.getString("vtfacebook")
                resmapa= data.getString("vtmapa")
                residVinedos=data.getString("vtidVinedos")

            }

        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val boton= FragmentFragLinkVinedosBinding.inflate(layoutInflater)


        boton.galleriavinedo.setOnClickListener{

            val galvar= Intent(context,PortaFotos::class.java)
            galvar.putExtra("Fotosdis",residVinedos.toString())
            startActivity(galvar)

        }

        boton.mapvinedo.setOnClickListener{
            val mapa= Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+resmapa.toString()))
            startActivity(mapa)
        }

        boton.facevinedo.setOnClickListener{

            val face= Intent(Intent.ACTION_VIEW, Uri.parse(""+resfacebook.toString()))
            startActivity(face)
        }
        boton.llamadavinedo.setOnClickListener{
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
         * @return A new instance of fragment FragLinkVinedos.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragLinkVinedos().apply {
                arguments = Bundle().apply {

                }
            }
    }
}