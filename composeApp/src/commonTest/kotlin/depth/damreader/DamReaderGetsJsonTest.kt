package depth.damreader

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class DamReaderGetsJsonTest {
    @Test
    fun `should get json from dam`() {
        val damReader = DamReader("https://alertdata.valleywater.org/sensorData/4002/")

        val json = damReader.readingsResponseString()

        json.shouldNotBeNull()
            .shouldBeInstanceOf<String>()
            .trim()
            .shouldStartWith("{")
            .shouldEndWith("}")
    }

    @Test
    fun `should get null from non-dam url`() {
        val damReader = DamReader("https://notmydam.com/")

        val json = damReader.readingsResponseString()

        json.shouldBeNull()
    }
}