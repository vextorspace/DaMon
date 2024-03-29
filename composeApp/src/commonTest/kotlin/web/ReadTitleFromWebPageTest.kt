package web

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ReadTitleFromWebPageTest {

    @Test
    fun `reads title from stored web page`() {
        val webPage = WebPage.fromResource("/damDepth.html")
        webPage?.title()
            .shouldBe("Santa Clara Valley Water | Surface Water Data Portal")
    }

    @Test
    fun `reads title from web page`() {
        val webPage = WebPage.fromUrl("https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f")
        webPage?.title()
            .shouldBe("Santa Clara Valley Water | Surface Water Data Portal")
    }
}