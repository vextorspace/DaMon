package web

import com.fleeksoft.ksoup.nodes.Element

class DamRow(val element: Element) {
    fun getDepth(): Double? {
        return element.select("td:nth-child(2)")
            .firstOrNull()
            ?.text()
            ?.toDoubleOrNull()
    }

    fun getDate(): DamTime? {
        return element.select("td:first-child")
            .firstOrNull()
            ?.let {
                DamTime.from(it.text())
            }
    }

    companion object {
        fun from(it: Element?): DamRow? {
            return it?.let {
                DamRow(it)
            }
        }
    }
}
