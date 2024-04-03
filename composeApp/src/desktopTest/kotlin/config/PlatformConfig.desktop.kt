package config

import java.util.prefs.Preferences

actual class PlatformConfig actual constructor() : Config {
    private val preferences = Preferences.userRoot()
                                  .node(this::class.java.name)

    override fun setLastDepth(lastDepth: Double) {
        preferences.putDouble("LAST_DEPTH", lastDepth)
    }

    override fun getLastDepth(): Double? {
        return preferences.getDouble("LAST_DEPTH", 0.0)
    }
}