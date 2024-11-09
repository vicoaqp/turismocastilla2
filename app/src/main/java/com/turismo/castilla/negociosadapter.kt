package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class negociosadapter(private var context: NeFarmacia, private val userscal: List<UserNegociosd>): RecyclerView.Adapter<UserViewHolder25>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder25 {
        mContext = parent.context as NeFarmacia
        return UserViewHolder25(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.turismot_aplao,parent,false)
        )
    }
    override fun onBindViewHolder(holder: UserViewHolder25, position: Int) {

        val user =userscal[position]
        Glide.with(context)
            .load(user.img1)
            .into(holder.FotoEvento)

        holder.NombreNegocio.text = user.nombre

        holder.FotoEvento.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            val lanzar2= Intent(mContext,InfoNegocios::class.java)

            lanzar2.putExtra("idDistrito",user.idDistrito)
            lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dias",user.dias)
            lanzar2.putExtra("direccion",user.direccion)
            lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("namenegocio",user.nombre)
            lanzar2.putExtra("facebook",user.facebook)
            lanzar2.putExtra("mapa",user.mapa)
            lanzar2.putExtra("mapa2",user.mapa2)
            lanzar2.putExtra("img1",user.img1)

            mContext.startActivity(lanzar2)

        }

    }
    override fun getItemCount(): Int {
        return userscal.size
    }
}
    class UserViewHolder25(itemView: View) :RecyclerView.ViewHolder(itemView){
        val FotoEvento: ImageView =itemView.findViewById(R.id.imgturismos)
        val NombreNegocio: TextView = itemView.findViewById(R.id.textfirebase)
    }