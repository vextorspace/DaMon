package config

import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class PlatformConfigStoresAndLoadsTest {

    @Test
    fun `platform config stores and loads depth`() {
        var config: Config = PlatformConfig()
        val depth = 123.45
        config.setLastDepth(depth)
        config = PlatformConfig()
        config.getLastDepth()
            .shouldNotBeNull()
            .shouldBeExactly(depth)
    }
}