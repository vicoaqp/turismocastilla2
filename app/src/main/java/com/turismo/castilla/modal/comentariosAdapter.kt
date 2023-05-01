package com.turismo.castilla.modal

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.turismo.castilla.DescriRestaurante
import com.turismo.castilla.R
import com.turismo.castilla.databinding.ActivityDetalleNoticiasBinding
import com.turismo.castilla.detalle_noticias

class comentariosAdapter(private val context: Context, private val comentarios: List<ComentarioModel>): RecyclerView.Adapter<comentarioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): comentarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return comentarioViewHolder(layoutInflater.inflate(R.layout.item_comentarios, parent, false))
    }

    override fun onBindViewHolder(holder: comentarioViewHolder, position: Int) {
        val comentario: ComentarioModel = comentarios[position]
        holder.bind(comentario.user_img, comentario.user_name, comentario.comentario_body, comentario.created_at)
    }

    override fun getItemCount(): Int = comentarios.size
}