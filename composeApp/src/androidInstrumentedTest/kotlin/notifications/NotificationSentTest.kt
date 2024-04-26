package notifications

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.service.notification.StatusBarNotification
import android.telephony.TelephonyManager.TimeoutException
import androidx.core.app.NotificationCompat
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ServiceTestRule
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

class NotificationSentTest {
    @get:Rule
    val serviceRule = ServiceTestRule()

    @Test
    fun sentNotificationsReceivedTest() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val serviceIntent = Intent(context, NotificationMonitorService::class.java)

        val serviceConnection = object : ServiceConnection {
            var service: NotificationMonitorService? = null

            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                val binder = binder as NotificationMonitorService.LocalBinder
                service = binder.getService()
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                service = null
            }
        }

        try {
            serviceRule.bindService(
                serviceIntent,
                serviceConnection,
                Service.BIND_AUTO_CREATE
            )

            val notificationSystem: NotificationSystem =
                AndroidNotificationSystem(context)

            notificationSystem.sendNotification(
                "Test Notification",
                "This is a test notification"
            )
            val notifications: List<StatusBarNotification> =
                serviceConnection.service!!.notifications

            notifications.shouldHaveSize(1)
            val notification = notifications.first().notification

            notification.shouldNotBeNull()
                .extras
                .getString(NotificationCompat.EXTRA_TITLE)
                .shouldBe("Test Notification")
            notification.extras
                .getString(NotificationCompat.EXTRA_TEXT)
                .shouldBe("This is a test notification")
        } catch (e: TimeoutException) {
            fail("Service connection timed out")
        } finally {
            serviceRule.unbindService()
        }
    }
}