package depth.damreader

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class DamReaderGetsJsonTest {
    @Test
    fun `should get json from dam`() {
        val damReader = DamReader()

        val json = damReader.readingsResponseString()

        json.shouldNotBeNull()
            .shouldBeInstanceOf<String>()
            .trim()
            .shouldStartWith("{")
            .shouldEndWith("}")
    }


}