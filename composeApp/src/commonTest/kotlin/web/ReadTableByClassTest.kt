package web

import io.kotest.matchers.nulls.shouldBeNull
import kotlin.test.Test

class ReadTableByClassTest {
    @Test
    fun `read non-existent table by class gives null`() {
        val table: DepthTable? = WebPage.fromResource("/damDepth.html")?.findTableByClass("NON-EXISTENT-CLASS")
        table.shouldBeNull()
    }
}