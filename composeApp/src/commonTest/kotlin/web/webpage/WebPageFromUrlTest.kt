package web.webpage

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import web.webpage.WebPage
import kotlin.test.Test

class WebPageFromUrlTest {
    @Test
    fun `loads document from url`() {
        val url = "https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f"

        WebPage.fromUrl(url)
            .shouldNotBeNull()
            .document
            .shouldNotBeNull()
    }

    @Test
    fun `bad url gives null WebPage`() {
        val badUrl = "https://does.not.exist.valleywater.org/map"

        WebPage.fromUrl(badUrl)
            .shouldBeNull()
    }
}