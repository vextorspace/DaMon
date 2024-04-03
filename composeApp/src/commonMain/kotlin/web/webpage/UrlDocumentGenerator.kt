package web.webpage

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.network.parseGetRequestBlocking
import com.fleeksoft.ksoup.nodes.Document

class UrlDocumentGenerator(val url: String): DocumentGenerator {
    private val document : Document? by lazy {
        Ksoup.parseGetRequestBlocking(url)
    }
    override fun document(): Document? {
        return document
    }
}
