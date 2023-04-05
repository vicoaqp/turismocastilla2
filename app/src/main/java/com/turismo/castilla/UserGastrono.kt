package com.turismo.castilla

class UserGastrono (
    val imgRestaurante: String,
    val celular: String,
    val descripcion: String,
    val idDistrito: String,
    val dias: String,
    val direccion: String,
    val horario: String,
    val idRestaurante: String,
    val namerest: String,
    val facebook: String,
    val mapa: String


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