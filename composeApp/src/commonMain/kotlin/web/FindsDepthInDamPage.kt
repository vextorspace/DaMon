package web

import web.dam.DamReading
import web.webpage.WebPage

class FindsDepthInDamPage {
    fun findDepth(webPage: WebPage?): DamReading? {
        return webPage?.findDepthTable()
            ?.mostRecentDamReading()
    }
}
