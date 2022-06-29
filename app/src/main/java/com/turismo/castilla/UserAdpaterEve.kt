package com.turismo.castilla

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdpaterEve(private val context: EventosInfo, private val users: List<UserEventos>): RecyclerView.Adapter<UserViewHolder2>() {

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder2 {
        return UserViewHolder2(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_eventos,parent,false)
        )
    }


    override fun onBindViewHolder(holder: UserViewHolder2, position: Int) {
        val user =users[position]
        holder.TextoEvento.text = user.TextoEvento
        Glide.with(context)
            .load(user.FotoEvento)
            .into(holder.FotoEvento)
    }


}
    class UserViewHolder2(itemView: View) :RecyclerView.ViewHolder(itemView){
        val TextoEvento: TextView = itemView.findViewById(R.id.textEvento)
        val FotoEvento: ImageView =itemView.findViewById(R.id.imageEvento)

    }