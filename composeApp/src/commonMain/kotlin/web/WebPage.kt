package web

import resources.ResourceLoader
import com.fleeksoft.ksoup.*

class WebPage(val document: Document) {

    companion object {
        fun fromResource(resourcePath: String): WebPage? {
            return WebPage(Ksoup.parse(ResourceLoader().readTextFromFile(resourcePath)))
        }
    }
}
