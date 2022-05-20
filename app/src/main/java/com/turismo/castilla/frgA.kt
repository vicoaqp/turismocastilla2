package com.turismo.castilla

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.turismo.castilla.databinding.ActivityHistoriaAplBinding
import com.turismo.castilla.databinding.FragmentFrgABinding


class frgA : Fragment() {

    lateinit var layout:FragmentFrgABinding
    private val binding get() = layout
    var ndistrito:String?=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("paquete1",this,
            FragmentResultListener { reStr: String, data: Bundle ->
                ndistrito= data.getString("DISTRITO")
                //Log.i("resu",ndistrito.toString())
                //layout.tdes.text=ndistrito
                val db= Firebase.firestore
                db.collection("distritos")
                    .whereEqualTo("namedistrito",ndistrito)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            layout.tdes.text= document.data.get("descripcion").toString()
                            layout.talcalde.text=document.data.get("alcalde").toString()
                            layout.tdireccion.text=document.data.get("direccion").toString()
                            layout.tanexos.text=document.data.get("anexos").toString()
                            layout.tfestividades.text=document.data.get("festividades").toString()
                            layout.tcelulares.text=document.data.get("celular").toString()
                        }
                    }
            }
        )

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layout= FragmentFrgABinding.inflate(inflater,container,false)

        return layout.root

    }


}