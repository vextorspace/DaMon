package web

class FindsDepthInDamPage {
    fun findDepth(webPage: WebPage?): DamReading? {
        return webPage?.findTableByClass("sensor-table")
            ?.mostRecentDamReading()
    }
}
