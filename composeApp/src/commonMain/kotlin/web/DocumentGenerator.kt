package web

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import resources.ResourceLoader

open class DocumentGenerator(private val document: Document?) {
    open fun document(): Document? {
        return document
    }

    companion object {


        fun fromUrl(url: String): DocumentGenerator {
            return DocumentGenerator(
                Ksoup.parse(url)
            )
        }
    }
}
