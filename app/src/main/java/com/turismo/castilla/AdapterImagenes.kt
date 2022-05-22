package com.turismo.castilla

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter
import com.turismo.castilla.databinding.ActivityPortaFotosBinding
import com.turismo.castilla.databinding.PatronrvimgBinding
import io.grpc.Context

class AdaptorImagenes: RecyclerView.Adapter<AdaptorImagenes.MyViewHolder>() {
    var itemList: MutableList<imagen> = ArrayList()
    var context: Context? = null

    class MyViewHolder(val binding: PatronrvimgBinding) : RecyclerView.ViewHolder(binding.root)

    fun AdaptorImagenes(Foto: MutableList<imagen>, context: Context) {

        this.itemList = Foto
        this.context = context
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
        return AdaptorImagenes.MyViewHolder(
            PatronrvimgBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}