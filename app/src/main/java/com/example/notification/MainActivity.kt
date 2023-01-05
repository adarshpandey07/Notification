package com.example.notification

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val message = intent.getStringExtra("message")
        if (!message.isNullOrEmpty()) {
            AlertDialog.Builder(this)
                .setTitle("Notification")
                .setMessage(message)
                .setPositiveButton("Ok", { dialog, which -> }).show()
        }
//        Firebase.messaging.subscribeToTopic("general")
//            .addOnCompleteListener { task ->
//                var msg = "Subscribed"
//                if (!task.isSuccessful) {
//                    msg = "Subscribe failed"
//                }
//                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
//            }
    }
}