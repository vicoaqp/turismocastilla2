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

class noticiasAdapter(private val context: Context, private val noticias: List<NoticiaModel>): RecyclerView.Adapter<noticiaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noticiaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return noticiaViewHolder(layoutInflater.inflate(R.layout.item_noticias, parent, false))
    }

    override fun onBindViewHolder(holder: noticiaViewHolder, position: Int) {
        val noticia: NoticiaModel = noticias[position]
        holder.bind(noticia.noticia_titulo, noticia.noticia_body, noticia.created_at, noticia.noticia_img)
        holder.itemView.setOnClickListener{
            val dataNoticia = Intent(context, detalle_noticias::class.java)
                dataNoticia.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                dataNoticia.putExtra("idUser", noticia.user_id)
                dataNoticia.putExtra("nameUser", noticia.user_name)
                dataNoticia.putExtra("imgUser", noticia.user_img)
                dataNoticia.putExtra("idNoticia", noticia.noticia_id)
                dataNoticia.putExtra("bodyNoticia", noticia.noticia_body)
                dataNoticia.putExtra("estadoNoticia", noticia.noticia_estado)
                dataNoticia.putExtra("imgNoticia", noticia.noticia_img)
                dataNoticia.putExtra("prioridadNoticia", noticia.noticia_prioridad)
                dataNoticia.putExtra("idCategoria", noticia.categoria_id)
                dataNoticia.putExtra("created_at", noticia.created_at)
                dataNoticia.putExtra("updated_at", noticia.updated_at)
                dataNoticia.putExtra("tituloNoticia", noticia.noticia_titulo)
            context.startActivity(dataNoticia)
        }
    }

    override fun getItemCount(): Int = noticias.size
}