package com.turismo.castilla.modal

import com.google.gson.annotations.SerializedName

data class NoticiaReponse (
    @SerializedName("status")
    var status: String,
    @SerializedName("msg")
    var mensaje: String,

    @SerializedName("data")
    var data: List<NoticiaModel>

        )