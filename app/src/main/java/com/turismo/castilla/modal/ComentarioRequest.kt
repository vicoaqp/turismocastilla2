package com.turismo.castilla.modal

import com.google.gson.annotations.SerializedName

data class ComentarioRequest(
    @SerializedName("noticia_id")
    val noticiaId: Int
)
