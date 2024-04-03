package config

import io.kotest.matchers.doubles.shouldBeExactly
import kotlin.test.Test

class DesktopConfigProviderPersistsTest {

    @Test
    fun `config contains a lastDepth that is a double`() {
        val depth = 1.3
        val desktopConfigProvider = DesktopConfigProvider()
        desktopConfigProvider.lastDepth = depth
        Config(desktopConfigProvider)


        Config(DesktopConfigProvider())
            .lastDepth
            .shouldBeExactly(depth)

    }
}