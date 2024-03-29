package web

import com.fleeksoft.ksoup.nodes.Element

class DepthTable(val element: Element) {
    fun mostRecentDamReading(): DamReading? {
        val firstRow = getFirstRow(element)
        val dateElement = getDateElement(firstRow)
        val depthElement = getDepthElement(firstRow)

        return depthElement?.let {
            dateElement?.let {
                DamReading(depthElement, dateElement)
            }
        }
    }

    private fun getDepthElement(firstRow: Element?): Double? {
        return firstRow?.select("td:nth-child(2)")?.firstOrNull()?.text()?.toDoubleOrNull()
    }

    private fun getDateElement(firstRow: Element?): DamTime? {
        return firstRow?.select("td:first-child")?.firstOrNull()?.let { DamTime.from(it.text()) }
    }

    private fun getFirstRow(element: Element): Element? {
        return element.select("tr:first-child").firstOrNull()
    }
}
