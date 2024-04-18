package config

class TestConfigProvider(private var _lastDepth: Double = 0.0) : ConfigProvider {

    fun withLastDepth(depth: Double): ConfigProvider {
        return TestConfigProvider(depth)
    }

    override var lastDepth: Double
        get() = _lastDepth
        set(value) {
            _lastDepth = value
        }
}
