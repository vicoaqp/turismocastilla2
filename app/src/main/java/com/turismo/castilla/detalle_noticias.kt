package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
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
        adapter = comentariosAdapter(baseContext, comentarioList)
        binding.rvComentarios.layoutManager = LinearLayoutManager(this)
        binding.rvComentarios.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://municipalidadprovincialcastilla.com/public/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    private fun getComentarios(idNoticia: ComentarioRequest) {
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).getComentarios(idNoticia)
                val comentarios = call.body()
                Log.e("DETALLENOTICIA", "Mensaje $call")
                runOnUiThread{
                    if (call.isSuccessful) {
                        val comentariosModel = comentarios?.data ?: emptyList()
                        comentarioList.clear()
                        comentarioList.addAll(comentariosModel)
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

        var idUser = intent.getIntExtra("idUser", 1)
        var nameUser = intent.getStringExtra("nameUser")
        var imgUser = intent.getStringExtra("imgUser")

        var bodyNoticia = intent.getStringExtra("bodyNoticia")
        var estadoNoticia = intent.getBooleanExtra("estadoNoticia", true)
        var imgNoticia = intent.getStringExtra("imgNoticia")
        var img_1 = intent.getStringExtra("img_1")
        var img_2 = intent.getStringExtra("img_2")
        var img_3 = intent.getStringExtra("img_3")
        var img_4 = intent.getStringExtra("img_4")
        var prioridadNoticia = intent.getStringExtra("prioridadNoticia")
        var idCategoria = intent.getIntExtra("idCategoria", 1)
        var created_at = intent.getStringExtra("created_at")
        var updated_at = intent.getStringExtra("updated_at")
        var tituloNoticia = intent.getStringExtra("tituloNoticia")

        binding.tvFecha.setText(created_at)
        binding.tvTitulo.setText(tituloNoticia)
        binding.tvDescripcion.setText(bodyNoticia)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("http://municipalidadprovincialcastilla.com/public/${imgNoticia}", ScaleTypes.CENTER_CROP))
        if (!img_1.isNullOrEmpty()) {
            imageList.add(SlideModel("http://municipalidadprovincialcastilla.com/public/${img_1}", ScaleTypes.CENTER_CROP))
        }
        if (!img_2.isNullOrEmpty()) {
            imageList.add(SlideModel("http://municipalidadprovincialcastilla.com/public/${img_2}", ScaleTypes.CENTER_CROP))
        }
        if (!img_3.isNullOrEmpty()) {
            imageList.add(SlideModel("http://municipalidadprovincialcastilla.com/public/${img_3}", ScaleTypes.CENTER_CROP))
        }
        if (!img_4.isNullOrEmpty()) {
            imageList.add(SlideModel("http://municipalidadprovincialcastilla.com/public/${img_4}", ScaleTypes.CENTER_CROP))
        }
        binding.imageslider?.setImageList(imageList)
    }

}