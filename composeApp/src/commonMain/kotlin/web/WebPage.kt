package web

import com.fleeksoft.ksoup.nodes.Document

class WebPage(val document: Document?) {
    fun title(): String? {
        return document?.title()
    }


}
