package com.turismo.castilla

import android.content.Intent
import android.net.Uri
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
import com.turismo.castilla.databinding.FragmentFrgABinding
import com.turismo.castilla.databinding.FragmentFrgDBinding


class frgD : Fragment() {

    lateinit var fragment:FragmentFrgDBinding

    var ndistrito:String?=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("paquete2",this,
            FragmentResultListener{ reStr:String, data:Bundle ->
                ndistrito=data.getString("DISTRITO2")

            }
        )

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val boton= FragmentFrgDBinding.inflate(layoutInflater)



        boton.bllamada.setOnClickListener{
            val myUri= Uri.parse("tel:969734486").let { numeroTelefonoUri ->
                Intent(Intent.ACTION_DIAL,numeroTelefonoUri)
            }
            startActivity(myUri)
        }
        boton.bwas.setOnClickListener{

            val galvar= Intent(context,PortaFotos::class.java)
            galvar.putExtra("Fotosdis",ndistrito)
            startActivity(galvar)

        }
        boton.bface.setOnClickListener{
            if (ndistrito == "aplao") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/municipiocastilla"))
                startActivity(face)
            } else if (ndistrito == "huancarqui") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100088985456991"))
                startActivity(face)
            } else if (ndistrito == "uraca") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/muniuracacorire"))
                startActivity(face)
            } else if (ndistrito == "viraco") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100089164608292"))
                startActivity(face)
            }else if (ndistrito == "pampacolca") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100089193193304"))
                startActivity(face)
            } else if (ndistrito == "machahuay") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/MunicipalidadDistritaldeMachaguay"))
                startActivity(face)
            } else if (ndistrito == "andagua") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/muniandagua1"))
                startActivity(face)
            } else if (ndistrito == "chilcaymarca") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100089165442821"))
                startActivity(face)
            } else if (ndistrito == "unon") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100089876804099"))
                startActivity(face)
            } else if (ndistrito == "choco") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Choco.municipalidad"))
                startActivity(face)
            } else if (ndistrito == "chachas") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100067592148116"))
                startActivity(face)
            } else if (ndistrito == "tipan") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100089052917379"))
                startActivity(face)
            } else if (ndistrito == "ayo") {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Municipalidad-Distrital-de-Ayo-Gesti%C3%B3n-2023-2026-114155051560552"))
                startActivity(face)
            }
            else {
                val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Municipalidad.Orcopampa"))
                startActivity(face)
            }





            //val face=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/turismoaplao"))
            //startActivity(face)
        }

        boton.bmapa.setOnClickListener{

            if (ndistrito == "aplao") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.07650487495793, -72.49202269945047"))
                startActivity(mapa)
            } else if (ndistrito == "huancarqui") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.09634520289844, -72.47246857813852"))
                startActivity(mapa)
            } else if (ndistrito == "uraca") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.223458325520998, -72.47015252688409"))
                startActivity(mapa)
            } else if (ndistrito == "viraco") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.658187623754264, -72.52463916151703"))
                startActivity(mapa)
            }else if (ndistrito == "pampacolca") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.714330751314188, -72.57350413833676"))
                startActivity(mapa)
            } else if (ndistrito == "machahuay") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.650555822683621, -72.50563536712318"))
                startActivity(mapa)
            } else if (ndistrito == "andagua") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.49880292228395, -72.35575692930904"))
                startActivity(mapa)
            } else if (ndistrito == "chilcaymarca") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.338286418574715, -72.40152559045723"))
                startActivity(mapa)
            } else if (ndistrito == "unon") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.728044829907185, -72.43254934988714"))
                startActivity(mapa)
            } else if (ndistrito == "choco") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.576935532467973, -72.12883428478798"))
                startActivity(mapa)
            } else if (ndistrito == "chachas") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.501364676893843, -72.27012840058333"))
                startActivity(mapa)
            } else if (ndistrito == "tipan") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.722776544860007, -72.50198339309492"))
                startActivity(mapa)
            } else if (ndistrito == "ayo") {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.682549482206383, -72.2721439053052"))
                startActivity(mapa)
            }
            else {
                val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-15.267204579677278, -72.34358007883506"))
                startActivity(mapa)
             }



           // val mapa=Intent(Intent.ACTION_VIEW,Uri.parse("geo:-16.076952434492625, -72.49054343707711?z=17"))
           // startActivity(mapa)

        }


        return boton.root
    }


}