package config

import android.content.Context

private const val CONFIG_KEY = "DA_MON_CONFIG"
private const val LAST_DEPTH_KEY = "LAST_DEPTH"
class AndroidConfigProvider(context: Context) : ConfigProvider {
    private val sharedPreferences = context.getSharedPreferences(
        CONFIG_KEY,
        Context.MODE_PRIVATE
    )
    override var lastDepth: Double
        get() = getSharedLastDepth()
        set(value) {
            setSharedLastDepth(value)
        }

    private fun setSharedLastDepth(value: Double) {
        sharedPreferences?.edit()
            ?.putString(LAST_DEPTH_KEY, value.toString())
            ?.apply()
    }

    private fun getSharedLastDepth(): Double {
        return (sharedPreferences?.getString(LAST_DEPTH_KEY, "0.0")
            ?.toDouble()
            ?: 0.0)
    }
}