package config

import io.kotest.matchers.doubles.shouldBeExactly
import kotlin.test.Test

class ConfigTest {

    @Test
    fun `config contains a lastDepth that is a double`() {
        val depth = 1.3
        val config = Config(TestConfigProvider(depth))

        config.lastDepth
            .shouldBeExactly(depth)

    }
}