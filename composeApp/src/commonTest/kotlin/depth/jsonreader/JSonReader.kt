package depth.jsonreader

import depth.DepthReading
import depth.damreader.DamReport
import kotlinx.serialization.json.Json

class JSonReader(val jsonString: String) {

    private val damReport = Json.decodeFromString<DamReport>(jsonString)
    fun readDam(): DepthReading {
        return damReport.data[0]
    }
}
