package depth.damreader

import depth.DepthReading
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class DamReport(val comments: List<String>, val metadata: Map<String, JsonElement>, val columns: Map<String, String>, val data: List<DepthReading>) {

}
