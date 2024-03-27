package web

import resources.ResourceLoader
import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document

class WebPage(val document: Document?) {

    companion object {
        fun fromResource(resourcePath: String): WebPage? {
            return documentFromText(
                readFileFromResource(resourcePath)
            )?.let { WebPage(it) }
        }

        private fun readFileFromResource(resourcePath: String): String? {
            return ResourceLoader().readTextFromFile(resourcePath)
        }

        private fun documentFromText(html: String?): Document? {
            return html?.let { Ksoup.parse(it) }
        }
    }
}
