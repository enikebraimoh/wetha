package com.enike.wetha.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.enike.wetha.R

// Notification ID.
private val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {

// Build the notification
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.notification_channel_id)
    ).setSmallIcon(R.drawable.clouds_wetha)
        .setContentTitle(
            applicationContext
                .getString(R.string.app_name)
        )
        .setContentText(messageBody)

    notify(NOTIFICATION_ID,builder.build())
}