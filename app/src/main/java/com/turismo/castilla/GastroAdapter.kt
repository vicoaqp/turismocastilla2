package com.turismo.castilla

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GastroAdapter(private val context: GastroAplaoRec,private val users: List<UserGastrono>): RecyclerView.Adapter<UserViewHolder>() {

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rgastro_aplao,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user =users[position]
        //holder.userName.text = user.userName
        Glide.with(context)
            .load(user.fotorestaurante)
            .into(holder.userImage)
    }

}

