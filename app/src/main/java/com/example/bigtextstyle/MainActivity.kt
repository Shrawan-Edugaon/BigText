package com.example.bigtextstyle

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    var CHANNEL_ID_ANDROID = "com.darshakomu.kotlinforndroidexample.ANDROID"
    var CHANNEL_NAME ="ANDROID _CHANNEL"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNotification = findViewById<Button>(R.id.button)
        btnNotification.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                val imp = NotificationManager.IMPORTANCE_HIGH
                val mNotificationChannel = NotificationChannel(CHANNEL_ID_ANDROID,CHANNEL_NAME,imp)
                val ic = BitmapFactory.decodeResource(resources,R.drawable.kotlin)
                val bigTextNotification:Notification.BigTextStyle = Notification .BigTextStyle()
                bigTextNotification.bigText("This demo of BigTextStyle Notification this text notification has to be lognin order to see the  full effects of Big TextStyle Notification,It has three Section under notification content title which is 'Big Text Notification',then actual place for big text below content title and at last summary text which shows the author of the text")
                bigTextNotification.setBigContentTitle("Big Text Notification.....")
                bigTextNotification.setSummaryText("By:Darshan")

                val notificationBuilder:Notification.Builder = Notification.Builder(this,CHANNEL_ID_ANDROID)
                    .setContentText("Big Text Notification.....")
                    .setSmallIcon(R.drawable.kotlin)
                    .setLargeIcon(ic)
                    .setStyle(bigTextNotification)
                    .setContentText("This is Big Text Notification.....")

                val notificationManager:NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(mNotificationChannel)
                notificationManager.notify(O,notificationBuilder.build())
        }
            else
            {
                val ic = BitmapFactory.decodeResource(resources,R.drawable.kotlin)
                val bigTextNotification:NotificationCompat.BigTextStyle = NotificationCompat.BigTextStyle()
                bigTextNotification.bigText("This demo of BigTextStyle Notification this text notification has to be lognin order to see the  full effects of Big TextStyle Notification,It has three Section under notification content title which is 'Big Text Notification',then actual place for big text below content title and at last summary text which shows the author of the text")
                bigTextNotification.setBigContentTitle("Big Text Notification.....")
                bigTextNotification.setSummaryText("By : Darshan")

                val notificationBuilder:NotificationCompat.Builder = NotificationCompat.Builder(this)
                    .setContentText("Big Text Notification.....")
                    .setSmallIcon(R.drawable.kotlin)
                    .setLargeIcon(ic)
                    .setStyle(bigTextNotification)
                    .setContentText("This is Big Text Notification....")
                val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(O,notificationBuilder.build())
            }
        }
    }
}