package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class WebPageFromUrlTest {
    @Test
    fun `webpage loads document from url`() {
        val webPage = WebPage.fromUrl("https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f")
        webPage.shouldNotBeNull()
    }
}