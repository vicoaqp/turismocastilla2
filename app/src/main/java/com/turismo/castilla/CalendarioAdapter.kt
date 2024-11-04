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

class CalendarioAdapter(private var context: eleccionmes, private val userscalendario: List<UsersCalendario>): RecyclerView.Adapter<UserViewHolder12>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder12 {
        mContext = parent.context as eleccionmes
        return UserViewHolder12(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.turismot_aplao,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder12, position: Int) {
        val user =userscalendario[position]
        Glide.with(context)
            .load(user.imgcalendario)
            .into(holder.FotoEleccionmes)

        holder.FotoEleccionmes.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            //val lanzar2= Intent(mContext,DescriHotel::class.java)
            val lanzar2= Intent(mContext,InfoCalendario::class.java)

            lanzar2.putExtra("idMes",user.idmes)
           // lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dia",user.dia)
            lanzar2.putExtra("direccion",user.direccion)
           // lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("nombreevento",user.nombreevento)
            //lanzar2.putExtra("facebook",user.facebook)
            //lanzar2.putExtra("mapa",user.mapa)
            lanzar2.putExtra("img1",user.img1)
            lanzar2.putExtra("img2",user.img2)
            lanzar2.putExtra("img3",user.img3)
            lanzar2.putExtra("img4",user.img4)

            mContext.startActivity(lanzar2)
                }
        }

    override fun getItemCount(): Int {
        return  userscalendario.size
    }
}

class UserViewHolder12(itemView: View) :RecyclerView.ViewHolder(itemView){
    val FotoEleccionmes: ImageView =itemView.findViewById(R.id.imgturismos)




}
