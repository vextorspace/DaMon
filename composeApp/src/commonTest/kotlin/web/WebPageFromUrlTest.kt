package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class WebPageFromUrlTest {
    val url = "https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f"

    @Test
    fun `loads document from url`() {
        WebPage.fromUrl(url)
            .shouldNotBeNull()
            .document
            .shouldNotBeNull()
    }
}