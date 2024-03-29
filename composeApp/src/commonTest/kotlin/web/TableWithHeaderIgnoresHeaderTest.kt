package web

import com.fleeksoft.ksoup.Ksoup
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class TableWithHeaderIgnoresHeaderTest {

    @Test
    fun `table with header ignores header`() {
        val htmlWithTable = """
            <table class="sensor-table">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Depth</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>3/29/2024 10:15 AM</td>
                        <td>1.0</td>
                    </tr>
                </tbody>
            </table>
        """.trimIndent()
        val table = WebPage(Ksoup.parse(htmlWithTable))
            .findDepthTable()
        val damReading = table?.mostRecentDamReading()
        damReading.shouldNotBeNull()
            .depth
            .shouldBeExactly(1.0)
    }
}