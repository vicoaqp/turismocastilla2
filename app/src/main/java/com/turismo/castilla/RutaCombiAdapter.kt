package com.turismo.castilla
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class RutaCombiAdapter(private val rutas: List<RutaCombi>) :
    RecyclerView.Adapter<RutaCombiAdapter.RutaCombiViewHolder>() {

    class RutaCombiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewRutaCombi)
        val textViewInicio: TextView = itemView.findViewById(R.id.textViewInicio)
        val textViewFin: TextView = itemView.findViewById(R.id.textViewFin)
        val buttonVerMapa: Button = itemView.findViewById(R.id.buttonVerMapa) // Obtener referencia al botón
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RutaCombiViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.ruta_combi_item, parent, false)
        return RutaCombiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RutaCombiViewHolder, position: Int) {
        val ruta = rutas[position]

        holder.textViewInicio.text = "Inicio: ${ruta.inicio}"
        holder.textViewFin.text = "Fin: ${ruta.fin}"

        // Usar Glide para cargar la imagen desde la URL
        Glide.with(holder.itemView.context)
            .load(ruta.imageUrl)
            .placeholder(R.drawable.ic_launcher_background) // Imagen de placeholder mientras carga
            .error(R.drawable.ic_launcher_background) // Imagen si hay error al cargar
            .into(holder.imageView)


        holder.buttonVerMapa.setOnClickListener {
            val intent = Intent(holder.itemView.context, MapaDeRuta::class.java)
            intent.putExtra("inicio", ruta.inicio)
            intent.putExtra("fin", ruta.fin)
            intent.putExtra("geoinicio_latitude", ruta.geoinicio?.latitude) // Pasar latitud
            intent.putExtra("geoinicio_longitude", ruta.geoinicio?.longitude) // Pasar longitud
            intent.putExtra("geofinal_latitude", ruta.geofinal?.latitude) // Pasar latitud
            intent.putExtra("geofinal_longitude", ruta.geofinal?.longitude) // Pasar longitud
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = rutas.size
}