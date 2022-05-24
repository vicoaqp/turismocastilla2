package com.turismo.castilla

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.turismo.castilla.databinding.PatronrvimgBinding
import io.grpc.Context

class AdapterImagenes () {
/*
    var itemList: MutableList<Imagenes> = ArrayList()
    var context: Context? = null

    class MyViewHolder(val binding: PatronrvimgBinding) : RecyclerView.ViewHolder(binding.root)

    fun AdaptadorImagenes(Foto: MutableList<Imagenes>, context: Context) {
        this.itemList = Foto
        this.context= context
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = itemList?.get(position)

        Glide.with(context)
            .load(item?.imagenUrl)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.binding.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return AdapterImagenes.MyViewHolder(
            PatronrvimgBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
*/
}