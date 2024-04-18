package config

const val SIGNIFICANT_CHANGE_IN_DEPTH_KEY = "significantChangeInDepth"
const val LAST_DEPTH_KEY = "lastDepth"

interface ConfigProvider {
    var lastDepth: Double
    var significantChangeInDepth: Double
}
