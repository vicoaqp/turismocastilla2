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
            val lanzar2= Intent(mContext,DescriRestaurante::class.java)

            lanzar2.putExtra("idDistrito",user.idDistrito)
            lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dias",user.dias)
            lanzar2.putExtra("direccion",user.direccion)
            lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("namerest",user.namerest)
            lanzar2.putExtra("facebook",user.facebook)
            lanzar2.putExtra("mapa",user.mapa)

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
