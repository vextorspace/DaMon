package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class UrlDocumentGeneratorTest {

    @Test
    fun `loads document from url`() {
        val url = "https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f"
        val document = UrlDocumentGenerator(url).document()
        document.shouldNotBeNull()
    }
}