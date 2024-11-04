package com.turismo.castilla

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
                    .load(turismo.imgturismo)  // Verifica que imgturismo sea la propiedad correcta
                    .into(holder.imageView)
                holder.bindTurismo(turismo)
            }
            GASTRONOMIA -> {
                val gastronomy = item as UserGastrono
                Glide.with(holder.itemView.context)
                    .load(gastronomy.imgRestaurante)
                    .into(holder.imageView)
                holder.bindGastronomy(gastronomy)
            }
            HOTELES -> {
                val hotel = item as UsersHoteles
                Glide.with(holder.itemView.context)
                    .load(hotel.imghoteles)
                    .into(holder.imageView)
                holder.bindHotel(hotel)
            }
            VINEDOS -> {
                val vineyard = item as UsersVinedos
                Glide.with(holder.itemView.context)
                    .load(vineyard.imgVinedos)
                    .into(holder.imageView)
                holder.bindVineyard(vineyard)
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

        fun bindTurismo(turismo: Usersturismos) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idgeneral", turismo.idTurismo)
                intent.putExtra("nameg", turismo.nameturismo)
                context.startActivity(intent)
            }
        }

        fun bindGastronomy(gastronomy: UserGastrono) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idgeneral", gastronomy.idRestaurante)
                intent.putExtra("nameg", gastronomy.namerest)
                context.startActivity(intent)
            }
        }

        fun bindHotel(hotel: UsersHoteles) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idgeneral", hotel.idhoteles)
                intent.putExtra("nameg", hotel.namehotel)
                context.startActivity(intent)
            }
        }

        fun bindVineyard(vineyard: UsersVinedos) {
            itemView.setOnClickListener {
                val intent = Intent(context, InfoGeneral::class.java)
                intent.putExtra("idgeneral", vineyard.idVinedos)
                intent.putExtra("nameg", vineyard.namevinedos)
                context.startActivity(intent)
            }
        }
    }
}