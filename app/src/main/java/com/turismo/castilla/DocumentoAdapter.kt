package com.turismo.castilla

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turismo.castilla.modal.UsersDocumentos

class DocumentoAdapter(private var context:documentos, private val usersDocumentos: List<UsersDocumentos>):RecyclerView.Adapter<UserViewHolder15>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder15 {
        mContext = parent.context as documentos
        return UserViewHolder15(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.hotelesaplao,parent,false)
        )
    }
    override fun onBindViewHolder(holder: UserViewHolder15, position: Int) {
        val user =usersDocumentos[position]
        Glide.with(context)
            .load(user.imgdocumento)
            .into(holder.FotoHotel)

        holder.FotoHotel.setOnClickListener{

            val documentoenvio= Intent(Intent.ACTION_VIEW, Uri.parse(user.urldoc))
            mContext.startActivity(documentoenvio)

        }
    }

    override fun getItemCount(): Int {
        return usersDocumentos.size
    }

}
class UserViewHolder15(itemView: View) :RecyclerView.ViewHolder(itemView){
    val FotoHotel: ImageView =itemView.findViewById(R.id.rimghoteles)
}