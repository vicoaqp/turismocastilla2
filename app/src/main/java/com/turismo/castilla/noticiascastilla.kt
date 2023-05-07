package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.turismo.castilla.databinding.ActivityMainBinding
import com.turismo.castilla.databinding.ActivityNoticiascastillaBinding
import com.turismo.castilla.modal.APIService
import com.turismo.castilla.modal.NoticiaModel
import com.turismo.castilla.modal.noticiasAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class noticiascastilla : AppCompatActivity() {
    private lateinit var binding:ActivityNoticiascastillaBinding
    private lateinit var adapter: noticiasAdapter
    private val noticiasList = mutableListOf<NoticiaModel>()
    //lateinit var visor: WebView
    lateinit var ivImagen: ImageView
    lateinit var tvCategoria: TextView
    lateinit var tvFecha: TextView
    lateinit var tvTitulo: TextView
    lateinit var tvDescripcion: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiascastillaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        getNoticias()
    }

    private fun initRecyclerView(){
        adapter = noticiasAdapter(baseContext, noticiasList)
        binding.rvNoticias.layoutManager = LinearLayoutManager(this)
        binding.rvNoticias.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://municipalidadprovincialcastilla.com/public/api/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun getNoticias() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getNoticias()
            val noticias = call.body()
            runOnUiThread{
                if (call.isSuccessful) {
                    val noticiasModel = noticias?.data ?: emptyList()
                    noticiasList.clear()
                    noticiasList.addAll(noticiasModel)
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



}