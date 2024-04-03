package config

class TestConfigProvider(var depth: Double) : ConfigProvider {
    override var lastDepth: Double
        get() = depth
        set(value) {
            depth = value
        }
}
