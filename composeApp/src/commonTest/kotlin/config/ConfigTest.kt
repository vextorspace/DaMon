package config

import io.kotest.matchers.doubles.shouldBeExactly
import kotlin.test.Test

class ConfigTest {

    @Test
    fun `config contains a lastDepth that is a double`() {
        val depth = 1.3
        val config = Config(TestConfigProvider().withLastDepth(depth))

        config.lastDepth
            .shouldBeExactly(depth)

    }

    @Test
    fun `config contains change in depth that results in a notification`() {
        val significantChangeInDepth = 5.5
        val config = Config(TestConfigProvider(0.0))
    }
}