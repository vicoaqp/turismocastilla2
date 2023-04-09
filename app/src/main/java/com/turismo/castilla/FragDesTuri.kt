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
import com.turismo.castilla.databinding.FragmentRestauranteBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragDesTuri.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragDesTuri : Fragment() {
    lateinit var layout:FragmentFragDesTuriBinding
    private val Binding get() = layout
    var reshcelular:String?=""
    var reshdescripcion:String?=""
    var reshdias:String?=""
    var reshdireccion:String?=""
    var reshhorario:String?=""
    var reshidhotel:String?=""
    var reshnamehotel:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        parentFragmentManager.setFragmentResultListener("fragturismos",this,
            FragmentResultListener{ reStr: String, data: Bundle ->

                reshcelular= data.getString("tcelular")
                reshdescripcion= data.getString("tdescripcion")
                reshdias= data.getString("tdias")
                reshdireccion= data.getString("tdireccion")
                reshhorario= data.getString("thorario")
                reshidhotel= data.getString("tidTurismo")
                reshnamehotel= data.getString("tnameturismo")

                layout.turicelulares.text=reshcelular.toString()
                layout.turides.text=reshdescripcion.toString()
                layout.turidias.text=reshdias.toString()
                layout.turidireccion.text=reshdireccion.toString()
                layout.turihorarios.text=reshhorario.toString()


            }
        )



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout= FragmentFragDesTuriBinding.inflate(inflater,container,false)

        return layout.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragDesTuri.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragDesTuri().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}