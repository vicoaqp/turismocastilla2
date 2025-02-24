package com.turismo.castilla

import com.google.firebase.firestore.GeoPoint

data class RutaCombi(
    val inicio: String,
    val fin: String,
    val imageUrl: String, // URL de la imagen
    val geoinicio: GeoPoint?,
    val geofinal: GeoPoint?
)