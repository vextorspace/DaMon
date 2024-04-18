package config

import androidx.test.platform.app.InstrumentationRegistry
import io.kotest.matchers.doubles.shouldBeExactly
import org.junit.Test

class AndroidConfigProviderPersistsDepthTest {

    @Test
    fun configProviderPersistsLastDepthTest() {
        val depth = 1.3
        val context = InstrumentationRegistry.getInstrumentation()
                                             .targetContext
        val androidConfigProvider = AndroidConfigProvider(context)
        Config(androidConfigProvider).lastDepth = depth

        Config(AndroidConfigProvider(context))
            .lastDepth
            .shouldBeExactly(depth)
    }

    @Test
    fun configProviderPersistsSignificantChangeInDepthTest() {
        val change = 17.0

        val context = InstrumentationRegistry.getInstrumentation()
            .targetContext
        val androidConfigProvider = AndroidConfigProvider(context)
        Config(androidConfigProvider).significantChangeInDepth = change

        Config(AndroidConfigProvider(context))
            .significantChangeInDepth
            .shouldBeExactly(change)

    }
}