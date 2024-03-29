package web

import com.fleeksoft.ksoup.nodes.Document
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class ResourceDocumentGeneratorTest {

    @Test
    fun `loads document from resource`() {
        val document: Document? = ResourceDocumentGenerator("/damDepth.html").document()
        document.shouldNotBeNull()
    }
}