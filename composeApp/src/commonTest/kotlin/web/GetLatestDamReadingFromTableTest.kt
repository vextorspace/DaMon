package web

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Element
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class GetLatestDamReadingFromTableTest {

    @Test
    fun `empty table gives null dam reading`() {
        val table = DepthTable(Element("table"))
        val damReading = table.mostRecentDamReading()
        damReading.shouldBeNull()
    }

    @Test
    fun `table with one row gives dam reading`() {
        val htmlWithTable = """
            <table class="sensor-table">
                <tr>
                    <td>3/29/2024 10:15 AM</td>
                    <td>1.0</td>
                </tr>
            </table>
        """.trimIndent()
        val table = WebPage(Ksoup.parse(htmlWithTable)).findTableByClass("sensor-table")
        val damReading = table?.mostRecentDamReading()
        damReading.shouldNotBeNull()
            .depth
            .shouldBeExactly(1.0)
    }

    @Test
    fun `row with missing depth gives null dam reading`() {
        val htmlWithTable = """
            <table class="sensor-table">
                <tr>
                    <td>3/29/2024 10:15 AM</td>
                    <td></td>
                </tr>
            </table>
        """.trimIndent()
        val table = WebPage(Ksoup.parse(htmlWithTable)).findTableByClass("sensor-table")
        val damReading = table?.mostRecentDamReading()
        damReading.shouldBeNull()
    }


    @Test
    fun `table from actual page gives depth`() {
        WebPage.fromResource("/damDepth.html")
            .shouldNotBeNull()
            .findTableByClass("sensor-table")
            .shouldNotBeNull()
            .mostRecentDamReading()
            .shouldNotBeNull()
            .depth
            .shouldBeExactly(508.0)
    }
}