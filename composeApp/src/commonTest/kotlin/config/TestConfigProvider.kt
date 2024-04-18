package config

class TestConfigProvider(private var _lastDepth: Double = 0.0, private var _significantChangeInDepth: Double = Double.POSITIVE_INFINITY) : ConfigProvider {

    fun withLastDepth(depth: Double): ConfigProvider {
        return TestConfigProvider(depth, this._significantChangeInDepth)
    }

    fun withSignificantChangeInDepth(significantChangeInDepth: Double): ConfigProvider {
        return TestConfigProvider(this._lastDepth, significantChangeInDepth)
    }

    override var lastDepth: Double
        get() = _lastDepth
        set(value) {
            _lastDepth = value
        }

    override var significantChangeInDepth: Double
        get() = _significantChangeInDepth
        set(value) {
            _significantChangeInDepth = value
        }
}
