package web

import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class WebPageFromFileTest {
    val document = ResourceDocumentGenerator("/damDepth.html").document()

    @Test
    fun `webpage loads document from resource`() {
        document?.let { WebPage(it) }
            .shouldNotBeNull()
    }

    @Test
    fun `loads document from resource`() {
        document?.let { WebPage(it) }
            ?.document
            .shouldNotBeNull()
    }
}