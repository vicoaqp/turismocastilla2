package com.turismo.castilla

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarioAdapter(private var context: calendario_castilla, private val userscalendario: List<UsersCalendario>): RecyclerView.Adapter<UserViewHolder12>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder12 {
        mContext = parent.context as calendario_castilla
        return UserViewHolder12(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_calendario,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder12, position: Int) {
        val user =userscalendario[position]
        //Glide.with(context)
          //  .load(user.imghoteles)
            //.into(holder.FotoHotel)
        holder.textodia.text= user.dia
        holder.textodescripcion.text= user.descripcion
        holder.textolugar.text= user.lugar
        holder.textoevento.text= user.nombreevento

            }

    override fun getItemCount(): Int {
        return  userscalendario.size
    }
}

class UserViewHolder12(itemView: View) :RecyclerView.ViewHolder(itemView){
    //val FotoHotel: ImageView =itemView.findViewById(R.id.rimghoteles)
    val textodia: TextView=itemView.findViewById(R.id.textdiaevento)
    val textodescripcion: TextView=itemView.findViewById(R.id.textdesevento)
    val textolugar: TextView=itemView.findViewById(R.id.textlugarevento)
    val textoevento: TextView=itemView.findViewById(R.id.textnameevento)




}
