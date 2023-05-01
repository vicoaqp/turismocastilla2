package com.turismo.castilla.modal

import com.google.gson.annotations.SerializedName

data class ComentarioModel(
    @SerializedName("user_id")
    var user_id: Int,
    @SerializedName("user_name")
    var user_name: String,
    @SerializedName("user_img")
    var user_img: String,
    @SerializedName("id")
    var comentario_id: Int,
    @SerializedName("noticia_id")
    var noticia_id: String,
    @SerializedName("body")
    var comentario_body: String,
    @SerializedName("estado")
    var comentario_estado: Boolean,
    @SerializedName("created_at")
    var created_at: String,
    @SerializedName("updated_at")
    var updated_at: String
)
