package web

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Element
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class DamRowNullWhenGivenHeaderTest {

    @Test
    fun `DamRow from header is null`() {
        val html = "<table><thead><tr><th>Date</th><th>Depth</th></tr></thead></table>"
        val document = Ksoup.parse(html)
        val row = document.selectFirst("tr")
        DamRow.from(row)
            .shouldBeNull()
    }

    @Test
    fun `DamRow from good data is not null`() {
        val html = "<table><tbody><tr><td>3/29/2024 10:15 AM</td><td>1.0</td></tr></tbody></table>"
        val document = Ksoup.parse(html)
        val row = document.selectFirst("tr")
        DamRow.from(row)
            .shouldNotBeNull()
    }
}