package web

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import resources.ResourceLoader

class ResourceDocumentGenerator(val resourcePath: String): DocumentGenerator {
    override fun document(): Document? {
        return getDocumentFromText(readFileFromResource(resourcePath))
    }

    companion object {

        private fun getDocumentFromText(html: String?): Document? {
            return html?.let { Ksoup.parse(it) }
        }

        private fun readFileFromResource(resourcePath: String): String? {
            return ResourceLoader().readTextFromFile(resourcePath)
        }
    }
}
