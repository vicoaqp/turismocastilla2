package com.turismo.castilla.modal

import com.google.gson.annotations.SerializedName

data class ComentarioReponse (
    @SerializedName("status")
    var status: String,
    @SerializedName("msg")
    var mensaje: String,

    @SerializedName("data")
    var data: List<ComentarioModel>

        )