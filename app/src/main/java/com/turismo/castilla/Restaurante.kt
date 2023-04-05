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
import com.turismo.castilla.databinding.FragmentRestauranteBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Restaurante.newInstance] factory method to
 * create an instance of this fragment.
 */
class Restaurante : Fragment() {
   lateinit var layout:FragmentRestauranteBinding
   private val binding get()= layout
    var rescelular:String?=""
    var resdescripcion:String?=""
    var resdias:String?=""
    var resdireccion:String?=""
    var reshorario:String?=""
    var residDistrito:String?=""
    var resnamerest:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("fragresta",this,
            FragmentResultListener { reStr: String, data: Bundle ->

                rescelular= data.getString("Fcelular")
                Log.i("dasesa",rescelular.toString())
                resdescripcion= data.getString("Fdescripcion")
                resdias= data.getString("Fdias")
                resdireccion= data.getString("Fdireccion")
                reshorario= data.getString("Fhorario")
                residDistrito= data.getString("FidDistrito")
                resnamerest= data.getString("Fnamerest")

                layout.trcelulares.text=rescelular.toString()
                layout.trdes.text=resdescripcion.toString()
                layout.trdias.text=resdias.toString()
                layout.trdireccion.text=resdireccion.toString()
                layout.trhorarios.text=reshorario.toString()


                //layout.tdes.text=ndistrito

                /*val db= Firebase.firestore
                db.collection("restauran")
                    .whereEqualTo("namerest",restafr)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            layout.trdes.text= document.data.get("descripcion").toString()
                            layout.trdireccion.text=document.data.get("direccion").toString()
                            layout.trdias.text=document.data.get("dias").toString()
                            layout.trhorarios.text=document.data.get("horario").toString()
                            layout.trcelulares.text=document.data.get("celular").toString()

                        }
                    }

                 */


            }
        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout= FragmentRestauranteBinding.inflate(inflater,container,false)

        return layout.root

    }


}