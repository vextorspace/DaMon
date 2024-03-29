package web

import com.fleeksoft.ksoup.nodes.Document
import com.fleeksoft.ksoup.nodes.Element

class WebPage(val document: Document?) {
    fun title(): String? {
        return document?.title()
    }

    fun findDepthTable(): DepthTable? {
        return findTableByClass("sensor-table")
    }

    fun findTableByClass(classTag: String): DepthTable? {
        return findElementByTag(classTag)?.let { DepthTable(it) }
    }

    fun findElementByTag(classTag: String): Element? {
        return document?.body()?.selectFirst(".$classTag")
    }

    companion object {
        fun fromUrl(url: String): WebPage? {
            return try {
                WebPage(UrlDocumentGenerator(url).document())
            } catch (e: Exception) {
                null
            }
        }

        fun fromResource(resourcePath: String): WebPage? {
            return WebPage(ResourceDocumentGenerator(resourcePath).document())
        }
    }
}
