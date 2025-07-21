package com.turismo.castilla

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.view.View
import android.content.Context

class ImageSliderAdapter(private val listaImagenes: List<String>, private val context: Context) :
    RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen = itemView.findViewById<ImageView>(R.id.imgItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_imagen_slider, parent, false)
        return ImageViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(context).load(listaImagenes[position]).into(holder.imagen)
    }

    override fun getItemCount(): Int = listaImagenes.size
}