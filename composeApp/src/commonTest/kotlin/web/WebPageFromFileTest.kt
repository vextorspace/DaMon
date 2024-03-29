package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class WebPageFromFileTest {

    @Test
    fun `loads document from resource`() {
        WebPage.fromResource("/damDepth.html")
            .shouldNotBeNull()
            .document
            .shouldNotBeNull()
    }
}