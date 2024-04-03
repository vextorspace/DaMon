package config

class TestConfig : Config {
    var _lastDepth = 0.0
    override fun setLastDepth(lastDepth: Double) {
        this._lastDepth = lastDepth
    }

    override fun getLastDepth(): Double {
        return _lastDepth
    }
}
