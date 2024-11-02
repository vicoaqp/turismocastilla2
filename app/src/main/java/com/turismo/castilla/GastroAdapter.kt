package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class GastroAdapter(private var context: GastroAplaoRec, private val usersgas: List<UserGastrono>): RecyclerView.Adapter<UserViewHolder5>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder5 {
        mContext = parent.context as GastroAplaoRec
        return UserViewHolder5(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rgastro_aplao,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder5, position: Int) {

        val user =usersgas[position]
        Glide.with(context)
            .load(user.imgRestaurante)
            .into(holder.FotoEvento)

        holder.FotoEvento.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            val lanzar2= Intent(mContext,InfoGeneral::class.java)

            lanzar2.putExtra("idDistrito",user.idDistrito)
            lanzar2.putExtra("idgeneral",user.idRestaurante)
            lanzar2.putExtra("celularg",user.celular)
            lanzar2.putExtra("descripciong",user.descripcion)
            lanzar2.putExtra("diasg",user.dias)
            lanzar2.putExtra("direcciong",user.direccion)
            lanzar2.putExtra("horariog",user.horario)
            lanzar2.putExtra("nameg",user.namerest)
            lanzar2.putExtra("facebookg",user.facebook)
            lanzar2.putExtra("mapag",user.mapa)
            lanzar2.putExtra("mapag2",user.mapa2)
            lanzar2.putExtra("img1",user.img1)
            lanzar2.putExtra("img2",user.img2)
            lanzar2.putExtra("img3",user.img3)
            lanzar2.putExtra("img4",user.img4)

            mContext.startActivity(lanzar2)

        }


    }

        override fun getItemCount(): Int {
            return usersgas.size
        }


}


class UserViewHolder5(itemView: View) :RecyclerView.ViewHolder(itemView){
    val FotoEvento: ImageView =itemView.findViewById(R.id.imagenrestaurante)

}
