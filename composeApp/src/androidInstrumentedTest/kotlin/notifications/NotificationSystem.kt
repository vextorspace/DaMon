package notifications

import android.app.Notification

interface NotificationSystem {
    fun sendNotification(title: String, message: String)
    fun getNotifications(): List<Notification>

}
