package com.turismo.castilla

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.api.Context

class DatosAdapter(
    private val context: DatosTurismo,
    private val dataList: List<Any>,
    private val tipo: String
) : RecyclerView.Adapter<DatosAdapter.GenericViewHolder>() {



    // Define los tipos como una enumeración
    enum class ItemType {
        TURISMO,
        GASTRONOMIA,
        HOTELES,
        VINEDO
    }

    companion object {
        const val TURISMO = "turismo"
        const val GASTRONOMIA = "gastronomia"
        const val HOTELES = "hoteles"
        const val VINEDOS = "vinedos"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.turismot_aplao, parent, false)
        return GenericViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val item = dataList[position]


        when (tipo) {
            TURISMO -> {
                val turismo = item as Usersturismos
                Glide.with(holder.itemView.context)
                    .load(turismo.img1)  // Verifica que imgturismo sea la propiedad correcta
                    .into(holder.imageView)
                holder.bindTurismo(turismo)
                holder.NombreLugar.text = item.nameturismo
            }
            GASTRONOMIA -> {
                val gastronomy = item as UserGastrono
                Glide.with(holder.itemView.context)
                    .load(gastronomy.img1)
                    .into(holder.imageView)
                holder.bindGastronomy(gastronomy)
                holder.NombreLugar.text = item.namerest
            }
            HOTELES -> {
                val hotel = item as UsersHoteles
                Glide.with(holder.itemView.context)
                    .load(hotel.img1)
                    .into(holder.imageView)
                holder.bindHotel(hotel)
                holder.NombreLugar.text = item.namehotel
            }
            VINEDOS -> {
                val vineyard = item as UsersVinedos
                Glide.with(holder.itemView.context)
                    .load(vineyard.img1)
                    .into(holder.imageView)
                holder.bindVineyard(vineyard)
                holder.NombreLugar.text = item.namevinedos

            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    // ViewHolder genérico
    inner class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Cambiar a "imgturismos" para que coincida con el ID en turismot_aplao.xml
        val imageView: ImageView = itemView.findViewById(R.id.imgturismos)
        val NombreLugar: TextView = itemView.findViewById(R.id.textfirebase)

        fun bindTurismo(turismo: Usersturismos) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idgeneral",turismo.idTurismo)
                intent.putExtra("celularg",turismo.celular)
                intent.putExtra("descripciong",turismo.descripcion)
                intent.putExtra("diasg",turismo.dias)
                intent.putExtra("direcciong",turismo.direccion)
                intent.putExtra("horariog",turismo.horario)
                intent.putExtra("nameg",turismo.nameturismo)
                intent.putExtra("facebookg",turismo.facebook)
                intent.putExtra("mapag",turismo.mapa)
                intent.putExtra("mapag2",turismo.mapa2)
                intent.putExtra("img1",turismo.img1)
                intent.putExtra("img2",turismo.img2)
                intent.putExtra("img3",turismo.img3)
                intent.putExtra("img4",turismo.img4)
                intent.putExtra("idDistrito",turismo.idDistrito)
                context.startActivity(intent)
            }
        }

        fun bindGastronomy(gastronomy: UserGastrono) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idDistrito",gastronomy.idDistrito)
                intent.putExtra("idgeneral",gastronomy.idRestaurante)
                intent.putExtra("celularg",gastronomy.celular)
                intent.putExtra("descripciong",gastronomy.descripcion)
                intent.putExtra("diasg",gastronomy.dias)
                intent.putExtra("direcciong",gastronomy.direccion)
                intent.putExtra("horariog",gastronomy.horario)
                intent.putExtra("nameg",gastronomy.namerest)
                intent.putExtra("facebookg",gastronomy.facebook)
                intent.putExtra("mapag",gastronomy.mapa)
                intent.putExtra("mapag2",gastronomy.mapa2)
                intent.putExtra("img1",gastronomy.img1)
                intent.putExtra("img2",gastronomy.img2)
                intent.putExtra("img3",gastronomy.img3)
                intent.putExtra("img4",gastronomy.img4)
                context.startActivity(intent)
            }
        }

        fun bindHotel(hotel: UsersHoteles) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idgeneral",hotel.idhoteles)
                intent.putExtra("celularg",hotel.celular)
                intent.putExtra("descripciong",hotel.descripcion)
                intent.putExtra("diasg",hotel.dias)
                intent.putExtra("direcciong",hotel.direccion)
                intent.putExtra("horariog",hotel.horario)
                intent.putExtra("nameg",hotel.namehotel)
                intent.putExtra("facebookg",hotel.facebook)
                intent.putExtra("mapag",hotel.mapa)
                intent.putExtra("img1",hotel.img1)
                intent.putExtra("img2",hotel.img2)
                intent.putExtra("img3",hotel.img3)
                intent.putExtra("img4",hotel.img4)
                intent.putExtra("mapag2",hotel.mapa2)

                context.startActivity(intent)
            }
        }

        fun bindVineyard(vineyard: UsersVinedos) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)

                intent.putExtra("idgeneral",vineyard.idVinedos)
                intent.putExtra("celularg",vineyard.celular)
                intent.putExtra("descripciong",vineyard.descripcion)
                intent.putExtra("diasg",vineyard.dias)
                intent.putExtra("direcciong",vineyard.direccion)
                intent.putExtra("horariog",vineyard.horario)
                intent.putExtra("nameg",vineyard.namevinedos)
                intent.putExtra("facebookg",vineyard.facebook)
                intent.putExtra("mapag",vineyard.mapa)
                intent.putExtra("mapag2",vineyard.mapa2)
                intent.putExtra("img1",vineyard.img1)
                intent.putExtra("img2",vineyard.img2)
                intent.putExtra("img3",vineyard.img3)
                intent.putExtra("img4",vineyard.img4)

                context.startActivity(intent)
            }
        }
    }
}