package com.turismo.castilla.modal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.turismo.castilla.databinding.ItemNoticiasBinding

class noticiaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemNoticiasBinding.bind(view)
    fun bind(titulo: String, descripcion: String, fecha: String, img: String){
        binding.tvTitle.setText(titulo)
        binding.tvDescripcion.setText(descripcion)
        binding.tvFecha.setText(fecha)
        Picasso.get().load("http://municipalidadprovincialcastilla.com/public/${img}").into(binding.ivImage)

    }
}