package com.turismo.castilla

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.contracts.Returns

class UserAdapter(private val context: PortaFotos, private val users: List<UserModel>): RecyclerView.Adapter<UserViewHolder>() {

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user =users[position]
        holder.userName.text = user.turismo
        Glide.with(context)
            .load(user.imgturismo)
            .into(holder.userImage)

        holder.userImage.setOnClickListener {
            val intent = Intent(context, FullScreenImage::class.java)
            intent.putExtra("imageUrl", user.imgturismo)
            context.startActivity(intent)
        }

    }

}
    class UserViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        //val userName: TextView = itemView.findViewById(R.id.textView_username)
        val userImage: ImageView =itemView.findViewById(R.id.imageView_user)
        val userName: TextView = itemView.findViewById(R.id.TextView_Fotos)
    }