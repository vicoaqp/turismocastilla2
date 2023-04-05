package com.turismo.castilla

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.turismo.castilla.databinding.FragmentFragDesTuriBinding
import com.turismo.castilla.databinding.FragmentFragDesVinedosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragDesVinedos.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragDesVinedos : Fragment() {
    lateinit var layout: FragmentFragDesVinedosBinding
    private val Binding get() = layout
    var vincelular:String?=""
    var vindescripcion:String?=""
    var vindias:String?=""
    var vindireccion:String?=""
    var vinhorario:String?=""
    var vinidvinedos:String?=""
    var vinnamevinedos:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("fragvino",this,
            FragmentResultListener{ reStr: String, data: Bundle ->

                vincelular= data.getString("vcelular")
                vindescripcion= data.getString("vdescripcion")
                vindias= data.getString("vdias")
                vindireccion= data.getString("vdireccion")
                vinhorario= data.getString("vhorario")
                vinidvinedos= data.getString("vidVinedos")
                vinnamevinedos= data.getString("vnamevinedos")

                layout.vinedoscelulares.text=vincelular.toString()
                layout.vinedosdes.text=vindescripcion.toString()
                layout.vinedosdias.text=vindias.toString()
                layout.vinedosdireccion.text=vindireccion.toString()
                layout.vinedoshorarios.text=vinhorario.toString()

            }
        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout= FragmentFragDesVinedosBinding.inflate(inflater,container,false)

        return layout.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragDesVinedos.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragDesVinedos().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}