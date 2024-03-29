package web

import com.fleeksoft.ksoup.nodes.Element

class DepthTable(val element: Element) {
    fun mostRecentDamReading(): DamReading? {
        val firstRow = getFirstRow(element)
        val dateElement = firstRow?.getDate()
        val depthElement = firstRow?.getDepth()

        return depthElement?.let {
            dateElement?.let {
                DamReading(depthElement, dateElement)
            }
        }
    }

    private fun getFirstRow(element: Element): DamRow? {
        return element.selectFirst("tbody")
            ?.selectFirst("tr")
            ?.let {
                DamRow.from(it)
            }
    }
}
