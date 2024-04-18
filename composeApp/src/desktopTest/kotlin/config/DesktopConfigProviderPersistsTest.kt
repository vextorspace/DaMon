package config

import io.kotest.matchers.doubles.shouldBeExactly
import kotlin.test.Test

class DesktopConfigProviderPersistsTest {

    @Test
    fun `config contains a lastDepth that is a double`() {
        val depth = 1.3
        val desktopConfigProvider = DesktopConfigProvider()
        Config(desktopConfigProvider).lastDepth = depth


        Config(DesktopConfigProvider())
            .lastDepth
            .shouldBeExactly(depth)
    }

    @Test
    fun `config contains a significantChangeInDepth that is a double`() {
        val change = 173.0
        val desktopConfigProvider = DesktopConfigProvider()
        Config(desktopConfigProvider).significantChangeInDepth = change


        Config(DesktopConfigProvider())
            .significantChangeInDepth
            .shouldBeExactly(change)
    }
}