package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class negociosadapter(private var context: NeFarmacia, private val userscal: List<UserGastrono>): RecyclerView.Adapter<UserViewHolder25>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder25 {
        mContext = parent.context as NeFarmacia
        return UserViewHolder25(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rgastro_aplao,parent,false)
        )
    }
    override fun onBindViewHolder(holder: UserViewHolder25, position: Int) {

        val user =userscal[position]
        Glide.with(context)
            .load(user.imgRestaurante)
            .into(holder.FotoEvento)

        holder.FotoEvento.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            val lanzar2= Intent(mContext,InfoNegocios::class.java)

            lanzar2.putExtra("idDistrito",user.idDistrito)
            lanzar2.putExtra("idRestaurante",user.idRestaurante)
            lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dias",user.dias)
            lanzar2.putExtra("direccion",user.direccion)
            lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("namerest",user.namerest)
            lanzar2.putExtra("facebook",user.facebook)
            lanzar2.putExtra("mapa",user.mapa)
            lanzar2.putExtra("mapa2",user.mapa2)
            lanzar2.putExtra("img1",user.img1)
            lanzar2.putExtra("img2",user.img2)
            lanzar2.putExtra("img3",user.img3)
            lanzar2.putExtra("img4",user.img4)

            mContext.startActivity(lanzar2)

        }

    }
    override fun getItemCount(): Int {
        return userscal.size
    }
}
    class UserViewHolder25(itemView: View) :RecyclerView.ViewHolder(itemView){
        val FotoEvento: ImageView =itemView.findViewById(R.id.imgturismos)
    }