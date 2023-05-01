package com.turismo.castilla.modal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.turismo.castilla.databinding.ItemComentariosBinding
import com.turismo.castilla.databinding.ItemNoticiasBinding

class comentarioViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemComentariosBinding.bind(view)
    fun bind(user_img: String, user_name: String, comentario_body: String, created_at: String){
        binding.tvTitle.setText(user_name)
        binding.tvDescripcion.setText(comentario_body)
        binding.tvFecha.setText(created_at)
        Picasso.get().load("http://api.municipalidadprovincialcastilla.com/${user_img}").into(binding.ivImage)

    }
}