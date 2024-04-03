package web.dam

import com.fleeksoft.ksoup.Ksoup
import io.kotest.matchers.nulls.shouldBeNull
import web.webpage.WebPage
import kotlin.test.Test

class ChangeInHeaderGivesNullDamReadingTest {

    @Test
    fun `Date not in first header column returns null Dam Reading`() {
        val htmlWithTable = """
            <table class="sensor-table">
                <thead>
                    <tr>
                        <th>Depth</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1.0</td>
                        <td>2.0</td>
                    </tr>
                </tbody>
            </table>
        """.trimIndent()
        val table = WebPage(Ksoup.parse(htmlWithTable))
            .findDepthTable()
        val damReading = table?.mostRecentDamReading()
        damReading.shouldBeNull()
    }
}