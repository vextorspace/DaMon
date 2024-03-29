package web

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ReadTitleFromWebPageTest {

    @Test
    fun `reads title from stored web page`() {
        val webPage = WebPage(ResourceDocumentGenerator("/damDepth.html").document())
        webPage.title().shouldBe("Santa Clara Valley Water | Surface Water Data Portal")
    }

}