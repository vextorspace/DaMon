package web.depth

import com.fleeksoft.ksoup.nodes.Element
import web.dam.DamReading
import web.dam.DamRow

class DepthTable(val element: Element) {
    fun mostRecentDamReading(): DamReading? {
        val firstRow = getGoodFirstRow(element)
        val dateElement = firstRow?.getDate()
        val depthElement = firstRow?.getDepth()

        return depthElement?.let {
            dateElement?.let {
                DamReading(depthElement, dateElement)
            }
        }
    }

    private fun getGoodFirstRow(element: Element): DamRow? {
        if(checkForGoodHeader(element.selectFirst("thead"))) {
            return getFirstRowFromElement(element)
        }

        return null

    }

    private fun getFirstRowFromElement(element: Element): DamRow? {
        return element.selectFirst("tbody")
            ?.selectFirst("tr")
            ?.let {
                DamRow.from(it)
            }
    }

    private fun checkForGoodHeader(headerElement: Element?): Boolean {
        return checkForFirstDate(headerElement) && checkForSecondDepth(headerElement)

    }

    private fun checkForSecondDepth(headerElement: Element?): Boolean {
        return headerElement?.selectFirst("th:nth-child(2)")
            ?.text()
            ?.contains("Elevation", ignoreCase = true)
            ?: false
    }

    private fun checkForFirstDate(headerElement: Element?): Boolean {
        return headerElement?.selectFirst("th")
            ?.text()
            ?.contains("Updated", ignoreCase = true)
            ?: false
    }
}
