package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TurismoAdapter(private var context: Turismo, private val usersturi: List<Usersturismos>): RecyclerView.Adapter<UserViewHolder9>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder9 {
        mContext = parent.context as Turismo
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
            val lanzar2= Intent(mContext,DescriTurismo::class.java)

            lanzar2.putExtra("idTurismo",user.idTurismo)
            lanzar2.putExtra("celular",user.celular)
            lanzar2.putExtra("descripcion",user.descripcion)
            lanzar2.putExtra("dias",user.dias)
            lanzar2.putExtra("direccion",user.direccion)
            lanzar2.putExtra("horario",user.horario)
            lanzar2.putExtra("nameturismo",user.nameturismo)
            lanzar2.putExtra("facebook",user.facebook)
            lanzar2.putExtra("mapa",user.mapa)
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