package com.turismo.castilla

data class Transporte(
    val foto: String? = null, // URL de la imagen en Firebase Storage
    val nombres: String? = null,
    val apellidos: String? = null,
    val placa: String? = null,
    val empresa: String? = null,
    val celular: String? = null
)