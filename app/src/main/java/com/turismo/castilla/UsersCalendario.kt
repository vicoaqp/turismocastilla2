package com.turismo.castilla

class UsersCalendario(
    val descripcion: String,
    val dia: String,
    val idcalendario: String,
    val idmes: String,
    val lugar: String,
    val nombreevento: String)
{
    constructor():this(
        "",
        "",
        "",
        "",
        "",
        ""
    )
}