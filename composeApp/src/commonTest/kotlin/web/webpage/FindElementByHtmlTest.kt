package web.webpage

import com.fleeksoft.ksoup.Ksoup
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import web.webpage.WebPage
import kotlin.test.Test

class FindElementByHtmlTest {

    @Test
    fun `find element by tag`() {
        val classTag = "theTag"
        val expected = "Yes This One"
        val html = "<html><body><h1 class=\"$classTag\">$expected</h1><p>No not this one</p></body></html>"

        val element = WebPage(Ksoup.parse(html)).findElementByTag(classTag)
        element.shouldNotBeNull()
            .text()
            .shouldBe(expected)
    }
}