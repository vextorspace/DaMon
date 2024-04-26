package notifications

import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class NotificationMonitorService : NotificationListenerService() {
    val notifications = mutableListOf<StatusBarNotification>()

    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): NotificationMonitorService = this@NotificationMonitorService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (channelMatchesId(sbn)) {
            notifications.add(sbn)
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        notifications.remove(sbn)
    }

    private fun channelMatchesId(sbn: StatusBarNotification): Boolean {
        return sbn.notification.channelId ==
                AndroidNotificationSystem.CHANNEL_ID
    }
}