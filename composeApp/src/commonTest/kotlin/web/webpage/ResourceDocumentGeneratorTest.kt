package web.webpage

import com.fleeksoft.ksoup.nodes.Document
import io.kotest.matchers.nulls.shouldNotBeNull
import web.webpage.ResourceDocumentGenerator
import kotlin.test.Test

class ResourceDocumentGeneratorTest {

    @Test
    fun `loads document from resource`() {
        val document: Document? = ResourceDocumentGenerator("/damDepth.html").document()
        document.shouldNotBeNull()
    }
}