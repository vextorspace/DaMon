package config

class Config(val configProvider: ConfigProvider) {
    var lastDepth by configProvider::lastDepth
    var significantChangeInDepth by configProvider::significantChangeInDepth
}
