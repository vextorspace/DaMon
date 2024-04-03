package config

interface Config {
    fun setLastDepth(lastDepth: Double)
    fun getLastDepth(): Double?
}
