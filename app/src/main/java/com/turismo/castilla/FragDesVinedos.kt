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
    var vinedosva:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("fragvinedos",this,
            FragmentResultListener{ reStr: String, data: Bundle ->
                vinedosva= data.getString("vinedosva")
                Log.i("resu",vinedosva.toString())
                //layout.tdes.text=ndistrito

                val db= Firebase.firestore
                db.collection("vinedos")
                    .whereEqualTo("namevinedos",vinedosva)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            layout.vinedosdes.text= document.data.get("descripcion").toString()
                            layout.vinedosdireccion.text=document.data.get("direccion").toString()
                            layout.vinedosdias.text=document.data.get("dias").toString()
                            layout.vinedoshorarios.text=document.data.get("horario").toString()
                            layout.vinedoscelulares.text=document.data.get("celular").toString()

                        }
                    }
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