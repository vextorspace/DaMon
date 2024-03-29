package web

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ReadTitleFromWebPageTest {

    @Test
    fun `reads title from stored web page`() {
        val webPage = WebPage(ResourceDocumentGenerator("/damDepth.html").document())
        webPage.title().shouldBe("Santa Clara Valley Water | Surface Water Data Portal")
    }

    @Test
    fun `reads title from web page`() {
        val webPage = WebPage(UrlDocumentGenerator("https://alert.valleywater.org/map?p=sensor&sid=4002&disc=f").document())
        webPage.title().shouldBe("Santa Clara Valley Water | Surface Water Data Portal")
    }

}