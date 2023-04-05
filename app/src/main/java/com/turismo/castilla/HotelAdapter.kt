package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HotelAdapter(private var context: Hoteles, private val usershotel: List<UsersHoteles>): RecyclerView.Adapter<UserViewHolder7>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder7 {
        mContext = parent.context as Hoteles
        return UserViewHolder7(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.hotelesaplao,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder7, position: Int) {
        val user =usershotel[position]
        Glide.with(context)
            .load(user.imghoteles)
            .into(holder.FotoHotel)

        holder.FotoHotel.setOnClickListener{
            //Log.e("distritova",user.idDistrito)
            val lanzar2= Intent(mContext,DescriHotel::class.java)

            lanzar2.putExtra("idHotel",user.idhoteles)
            lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dias",user.dias)
            lanzar2.putExtra("direccion",user.direccion)
            lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("namehotel",user.namehotel)
            lanzar2.putExtra("facebook",user.facebook)
            lanzar2.putExtra("mapa",user.mapa)

            mContext.startActivity(lanzar2)

        }
    }

    override fun getItemCount(): Int {
        return usershotel.size
    }


}
class UserViewHolder7(itemView: View) :RecyclerView.ViewHolder(itemView){
    val FotoHotel: ImageView =itemView.findViewById(R.id.rimghoteles)

}