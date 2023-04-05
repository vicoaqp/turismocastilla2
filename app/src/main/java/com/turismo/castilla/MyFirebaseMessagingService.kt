package com.turismo.castilla


    import com.google.firebase.messaging.FirebaseMessagingService
    import com.google.firebase.messaging.RemoteMessage

    class MyFirebaseMessagingService : FirebaseMessagingService() {

        override fun onMessageReceived(remoteMessage: RemoteMessage) {
            // Manejar la recepción de notificaciones
            // Puedes acceder a los datos de la notificación en remoteMessage.data
        }

        override fun onNewToken(token: String) {
            // Manejar la actualización del token de registro
            // Puedes enviar el nuevo token al servidor para recibir notificaciones
        }
    }
