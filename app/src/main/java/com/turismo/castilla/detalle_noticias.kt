package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.turismo.castilla.databinding.ActivityDetalleNoticiasBinding
import com.turismo.castilla.databinding.ActivityNoticiascastillaBinding
import com.turismo.castilla.modal.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class detalle_noticias : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleNoticiasBinding
    private lateinit var adapter: comentariosAdapter
    private val comentarioList = mutableListOf<ComentarioModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleNoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var idNoticia = intent.getIntExtra("idNoticia", 0)
        val request = ComentarioRequest(idNoticia)
        initRecyclerView()
        getComentarios(request)
        cargarDatos()
    }

    private fun initRecyclerView() {
        Toast.makeText(this, "DETALLELISTA 95 ${ comentarioList.toString() }", Toast.LENGTH_SHORT).show()
        adapter = comentariosAdapter(baseContext, comentarioList)
        binding.rvComentarios.layoutManager = LinearLayoutManager(this)
        binding.rvComentarios.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://api.municipalidadprovincialcastilla.com/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    private fun getComentarios(idNoticia: ComentarioRequest) {
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).getComentarios(idNoticia)
                val comentarios = call.body()
                runOnUiThread{
                    if (call.isSuccessful) {
                        val comentariosModel = comentarios?.data ?: emptyList()
                        comentarioList.clear()
                        comentarioList.addAll(comentariosModel)
                        Log.e("COMENTARISTALIST", comentarioList.toString())
                        adapter.notifyDataSetChanged()
                    }else{
                        showError()
                    }
                }

            }

    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    private fun cargarDatos() {

        var idUser = intent.getStringExtra("idUser")
        var nameUser = intent.getStringExtra("nameUser")
        var imgUser = intent.getStringExtra("imgUser")

        var bodyNoticia = intent.getStringExtra("bodyNoticia")
        var estadoNoticia = intent.getStringExtra("estadoNoticia")
        var imgNoticia = intent.getStringExtra("imgNoticia")
        var prioridadNoticia = intent.getStringExtra("prioridadNoticia")
        var idCategoria = intent.getStringExtra("idCategoria")
        var created_at = intent.getStringExtra("created_at")
        var updated_at = intent.getStringExtra("updated_at")
        var tituloNoticia = intent.getStringExtra("tituloNoticia")

        binding.tvFecha.setText(created_at)
        binding.tvTitulo.setText(tituloNoticia)
        binding.tvDescripcion.setText(bodyNoticia)
        Picasso.get().load("http://api.municipalidadprovincialcastilla.com/${imgNoticia}").into(binding.ivImage)

    }

}