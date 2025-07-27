package com.turismo.castilla.modal

class UsersDocumentos (
    val iddoc: String,
    val imgdocumento: String,
    val urldoc: String,
    val texto: String
){
    constructor():this(
        "",
        "",
        "",
        ""
    )
}