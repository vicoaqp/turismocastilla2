package com.turismo.castilla

import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.turismo.castilla.databinding.FragmentFragDesHotelBinding
import com.turismo.castilla.databinding.FragmentFragDesTuriBinding

import kotlin.math.log

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
    var reshcelular:String?=""
    var reshdescripcion:String?=""
    var reshdias:String?=""
    var reshdireccion:String?=""
    var reshhorario:String?=""
    var reshidhotel:String?=""
    var reshnamehotel:String?=""
    var img1:String?=""
    var img2:String?=""
    var img3:String?=""
    var img4:String?=""


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)


        //parentFragmentManager.setFragmentResultListener("fraghotel",this,
          //  FragmentResultListener{ reStr: String, data: Bundle ->

            //    reshcelular= data.getString("Hcelular")
              //  reshdescripcion= data.getString("Hdescripcion")
                //reshdias= data.getString("Hdias")
                //reshdireccion= data.getString("Hdireccion")
                //reshhorario= data.getString("Hhorario")
                //reshidhotel= data.getString("HidHotel")
                //reshnamehotel= data.getString("Hnamehotel")
                //img1= data.getString("img1")
                //img2= data.getString("img2")
                //img3= data.getString("img3")
                //img4= data.getString("img4")



               // layout.hotelcelulares.text=reshcelular.toString()
               // layout.hoteldes.text=reshdescripcion.toString()
             //   layout.hoteldias.text=reshdias.toString()
             //   layout.hoteldireccion.text=reshdireccion.toString()
             //   layout.hotelhorarios.text=reshhorario.toString()

               // layout.imageSlider?.setImageList(imageList)
            //}
        //)




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