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
import com.turismo.castilla.databinding.FragmentFragDesHotelBinding
import com.turismo.castilla.databinding.FragmentFragDesTuriBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragDesHotel.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragDesHotel : Fragment() {
    lateinit var layout:FragmentFragDesHotelBinding
    private val Binding get() = layout
    var hotelva:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("fraghotel",this,
            FragmentResultListener{ reStr: String, data: Bundle ->
                hotelva= data.getString("hotelva")
                Log.i("resu",hotelva.toString())
                //layout.tdes.text=ndistrito

                val db= Firebase.firestore
                db.collection("hotel")
                    .whereEqualTo("namehotel",hotelva)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            layout.hoteldes.text= document.data.get("descripcion").toString()
                            layout.hoteldireccion.text=document.data.get("direccion").toString()
                            layout.hoteldias.text=document.data.get("dias").toString()
                            layout.hotelhorarios.text=document.data.get("horario").toString()
                            layout.hotelcelulares.text=document.data.get("celular").toString()

                        }
                    }
            }
        )




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout= FragmentFragDesHotelBinding.inflate(inflater,container,false)

        return layout.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragDesHotel.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragDesHotel().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}