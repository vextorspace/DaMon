package depth

import kotlinx.serialization.Serializable

@Serializable
data class DepthReading(val id: Int, val timestamp: String, val value: Double, val rating: Double) {
    fun depth(): Double {
        return value
    }
}
