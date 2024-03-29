package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class WebPageFromUrlTest {
    val url = "https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f"
    val document = UrlDocumentGenerator(url).document()

    @Test
    fun `webpage loads document from url`() {
        WebPage(document.shouldNotBeNull())
            .shouldNotBeNull()
    }

    @Test
    fun `loads document from url`() {
            WebPage(document.shouldNotBeNull())
                .document.shouldNotBeNull()
    }
}