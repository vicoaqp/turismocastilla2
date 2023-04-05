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
            val lanzar2= Intent(mContext,DescriVinedos::class.java)

            lanzar2.putExtra("idVinedos",user.idVinedos)
            lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dias",user.dias)
            lanzar2.putExtra("direccion",user.direccion)
            lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("namevinedos",user.namevinedos)
            lanzar2.putExtra("facebook",user.facebook)
            lanzar2.putExtra("mapa",user.mapa)

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