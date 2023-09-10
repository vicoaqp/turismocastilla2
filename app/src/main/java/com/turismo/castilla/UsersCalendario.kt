package com.turismo.castilla

class UsersCalendario(
    val descripcion: String,
    val dia: String,
    val idcalendario: String,
    val idmes: String,
    val lugar: String,
    val imgcalendario:String,
    val img1:String,
    val img2:String,
    val img3:String,
    val img4:String,
    val nombreevento: String)
{
    constructor():this(
        "",
        "",
        "",
        "",
        "",
        "",
        ",",
        "",
        "",
        "",
        ""
    )
}