package com.turismo.castilla.modal

import com.google.gson.annotations.SerializedName

data class NoticiaModel(
    @SerializedName("user_id")
    var user_id: Int,
    @SerializedName("user_name")
    var user_name: String,
    @SerializedName("user_img")
    var user_img: String,
    @SerializedName("id")
    var noticia_id: Int,
    @SerializedName("body")
    var noticia_body: String,
    @SerializedName("estado")
    var noticia_estado: Boolean,
    @SerializedName("img")
    var noticia_img: String,
    @SerializedName("prioridad")
    var noticia_prioridad: String,
    @SerializedName("categoria_id")
    var categoria_id: Int,
    @SerializedName("created_at")
    var created_at: String,
    @SerializedName("updated_at")
    var updated_at: String,
    @SerializedName("titulo")
    var noticia_titulo: String
)
