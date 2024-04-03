package web.webpage

import com.fleeksoft.ksoup.nodes.Document

interface DocumentGenerator {
    fun document(): Document?
}
