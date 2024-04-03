package config

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class ConfigTest {

    @Test
    fun `config has last depth double`() {
        val config: Config = TestConfig()
        config.getLastDepth()
            .shouldNotBeNull()
            .shouldBeInstanceOf<Double>()
    }
}