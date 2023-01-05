package com.example.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "Service"
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From :" + remoteMessage!!.from)
        Log.d(TAG, "Notification From Body  :" + remoteMessage.notification?.body!!)
        sendNotification(remoteMessage)
        val intent = Intent(this@MyFirebaseMessagingService, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("message", remoteMessage.notification?.body!!)
        startActivity(intent)

    }

    private fun sendNotification(remoteMessage: RemoteMessage) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notificationBuilder = NotificationCompat.Builder(this)
            .setContentText(remoteMessage.notification?.body)
            .setAutoCancel(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())


    }


}