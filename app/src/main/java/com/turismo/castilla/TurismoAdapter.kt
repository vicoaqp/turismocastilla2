package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TurismoAdapter(private var context: Context, private val usersturi: List<Usersturismos>): RecyclerView.Adapter<UserViewHolder9>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder9 {
        mContext = context
        return UserViewHolder9(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.turismot_aplao,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder9, position: Int) {
        val user =usersturi[position]
        Glide.with(context)
            .load(user.imgturismo)
            .into(holder.FotoTurismo)

        holder.FotoTurismo.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            val lanzar2= Intent(mContext,InfoGeneral::class.java)

            lanzar2.putExtra("idgeneral",user.idTurismo)
            lanzar2.putExtra("celularg",user.celular)
            lanzar2.putExtra("descripciong",user.descripcion)
            lanzar2.putExtra("diasg",user.dias)
            lanzar2.putExtra("direcciong",user.direccion)
            lanzar2.putExtra("horariog",user.horario)
            lanzar2.putExtra("nameg",user.nameturismo)
            lanzar2.putExtra("facebookg",user.facebook)
            lanzar2.putExtra("mapag",user.mapa)
            lanzar2.putExtra("mapag2",user.mapa2)
            lanzar2.putExtra("img1",user.img1)
            lanzar2.putExtra("img2",user.img2)
            lanzar2.putExtra("img3",user.img3)
            lanzar2.putExtra("img4",user.img4)
            lanzar2.putExtra("idDistrito",user.idDistrito)

            mContext.startActivity(lanzar2)

        }
    }

    override fun getItemCount(): Int {
        return usersturi.size
    }


}
class UserViewHolder9(itemView: View) : RecyclerView.ViewHolder(itemView){
    val FotoTurismo: ImageView =itemView.findViewById(R.id.imgturismos)

}