package com.turismo.castilla.modal

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {
    @GET("noticias")
    suspend fun getNoticias(): Response<NoticiaReponse>

    @POST("comentario")
    suspend fun getComentarios(@Body request: ComentarioRequest): Response<ComentarioReponse>
}