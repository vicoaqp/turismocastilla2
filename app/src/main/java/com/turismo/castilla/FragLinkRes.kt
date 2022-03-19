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
import com.turismo.castilla.databinding.FragmentFragLinkResBinding
import com.turismo.castilla.databinding.FragmentRestauranteBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragLinkRes.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragLinkRes : Fragment() {
    lateinit var layout:FragmentFragLinkResBinding
    private val binding get()=layout
    var linkf:String?=""

    lateinit var cadenare:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {





        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout= FragmentFragLinkResBinding.inflate(inflater,container,false)
        var datolink:String?=""

        parentFragmentManager.setFragmentResultListener("fragresta",this,
            FragmentResultListener { reStr: String, data: Bundle ->
                linkf= data.getString("restapa")
                Log.i("resu","oli"+linkf.toString())
                //layout.tdes.text=ndistrito

                val db= Firebase.firestore
                db.collection("facebook")
                    .whereEqualTo("nameface",linkf)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            cadenare= document.data.get("url").toString()
                            Log.i("resu","dae"+cadenare.toString())

                        }
                        layout.linkrez.text=cadenare


                    }

            }
        )

        return layout.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragLinkRes.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragLinkRes().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}