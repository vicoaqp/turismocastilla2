package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class VinedosAdapter(private var context: Vinedos, private val usersvine: List<UsersVinedos>): RecyclerView.Adapter<UserViewHolder8>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder8 {
        mContext = parent.context as Vinedos
        return UserViewHolder8(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vinedos_aplao,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder8, position: Int) {
        val user =usersvine[position]
        Glide.with(context)
            .load(user.imgVinedos)
            .into(holder.FotoVinedo)

        holder.FotoVinedo.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            val lanzar2= Intent(mContext,InfoGeneral::class.java)

            lanzar2.putExtra("idgeneral",user.idVinedos)
            lanzar2.putExtra("celularg",user.celular)
            lanzar2.putExtra("descripciong",user.descripcion)
            lanzar2.putExtra("diasg",user.dias)
            lanzar2.putExtra("direcciong",user.direccion)
            lanzar2.putExtra("horariog",user.horario)
            lanzar2.putExtra("nameg",user.namevinedos)
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
        return usersvine.size
    }


}
class UserViewHolder8(itemView: View) : RecyclerView.ViewHolder(itemView){
    val FotoVinedo: ImageView =itemView.findViewById(R.id.limgvinedos)

}