package config

import java.util.prefs.Preferences

class DesktopConfigProvider : ConfigProvider {
    private val preferences = Preferences.userNodeForPackage(this::class.java)

    override var lastDepth: Double
        get() = preferences.getDouble("lastDepth", 0.0)
        set(value) {
            preferences.putDouble("lastDepth", value)
        }
}
