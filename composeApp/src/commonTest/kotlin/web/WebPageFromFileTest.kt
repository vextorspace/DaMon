package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class WebPageFromFileTest {

    @Test
    fun `webpage loads document from resource`() {
        val webPage = WebPage.fromResource("/damDepth.html")
        webPage.shouldNotBeNull()
    }

    @Test
    fun `loads document from resource`() {
        val webPage = WebPage.fromResource("/damDepth.html")
        webPage.document.shouldNotBeNull()
    }
}