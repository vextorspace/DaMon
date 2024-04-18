package config

import android.content.Context

private const val CONFIG_KEY = "DA_MON_CONFIG"

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

    override var significantChangeInDepth: Double
        get() = getSharedSignificantChangeInDepth()
        set(value) {
            setSharedSignificantChangeInDepth(value)
        }

    private fun setSharedSignificantChangeInDepth(value: Double) {
        sharedPreferences?.edit()
            ?.putString(SIGNIFICANT_CHANGE_IN_DEPTH_KEY, value.toString())
            ?.apply()
    }

    private fun getSharedSignificantChangeInDepth(): Double {
        return (sharedPreferences?.getString(SIGNIFICANT_CHANGE_IN_DEPTH_KEY, "100000.0")
            ?.toDouble()
            ?: Double.POSITIVE_INFINITY)
    }
}