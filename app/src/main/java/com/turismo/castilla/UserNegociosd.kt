package com.turismo.castilla

class UserNegociosd (
    val categoria: String,
    val celular: String,
    val descripcion: String,
    val dias: String,
    val direccion: String,
    val distrito: String,
    val facebook: String,
    val horario: String,
    val idDistrito: String,
    val nombre: String,
    val img1: String
){
    constructor():this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
}