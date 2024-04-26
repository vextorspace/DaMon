package notifications

import android.app.Notification
import android.content.Context

class AndroidNotificationSystem(context: Context?) : NotificationSystem {
    companion object {
        val CHANNEL_ID: String = "dam_monitor"
    }

    override fun sendNotification(title: String, message: String) {
        TODO("Not yet implemented")
    }

    override fun getNotifications(): List<Notification> {
        TODO("Not yet implemented")
    }

}
