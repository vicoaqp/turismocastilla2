package com.turismo.castilla
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso



class TransporteAdapter(private val context: Context, private val transportes: List<Transporte>) :
    RecyclerView.Adapter<TransporteAdapter.TransporteViewHolder>() {

    class TransporteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewFoto: ImageView = itemView.findViewById(R.id.imageViewFoto)
        val textViewNombres: TextView = itemView.findViewById(R.id.textViewNombres)
        val textViewApellidos: TextView = itemView.findViewById(R.id.textViewApellidos)
        val textViewPlaca: TextView = itemView.findViewById(R.id.textViewPlaca)
        val textViewEmpresa: TextView = itemView.findViewById(R.id.textViewEmpresa)
        val buttonLlamar: Button = itemView.findViewById(R.id.buttonLlamar)
        val buttonWhatsapp: Button = itemView.findViewById(R.id.buttonWhatsapp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransporteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transporte, parent, false)
        return TransporteViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransporteViewHolder, position: Int) {
        val transporte = transportes[position]

        holder.textViewNombres.text = transporte.nombres
        holder.textViewApellidos.text = transporte.apellidos
        holder.textViewPlaca.text = transporte.placa
        holder.textViewEmpresa.text = transporte.empresa

        // Carga la imagen usando Picasso (o Glide)
        Picasso.get()
            .load(transporte.foto)
            .placeholder(android.R.drawable.ic_menu_gallery) // Imagen de placeholder
            .error(android.R.drawable.ic_dialog_alert) // Imagen de error
            .into(holder.imageViewFoto)

        // Configura el botón Llamar
        holder.buttonLlamar.setOnClickListener {
            val numero = transporte.celular
            if (!numero.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numero"))
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Número de teléfono no disponible", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura el botón WhatsApp
        holder.buttonWhatsapp.setOnClickListener {
            val numero = transporte.celular
            if (!numero.isNullOrEmpty()) {
                val message = "Hola, solicito un servicio de transporte."
                val uri = Uri.parse("https://api.whatsapp.com/send?phone=${numero}&text=${Uri.encode(message)}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Número de teléfono no disponible", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return transportes.size
    }
}