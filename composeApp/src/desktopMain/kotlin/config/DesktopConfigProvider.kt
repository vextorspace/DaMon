package config

import java.util.prefs.Preferences

class DesktopConfigProvider : ConfigProvider {
    private val preferences = Preferences.userNodeForPackage(this::class.java)

    override var lastDepth: Double
        get() = preferences.getDouble(LAST_DEPTH_KEY, 0.0)
        set(value) {
            preferences.putDouble(LAST_DEPTH_KEY, value)
        }

    override var significantChangeInDepth: Double
        get() = preferences.getDouble(SIGNIFICANT_CHANGE_IN_DEPTH_KEY, Double.POSITIVE_INFINITY)
        set(value) {
            preferences.putDouble(SIGNIFICANT_CHANGE_IN_DEPTH_KEY, value)
        }
}
