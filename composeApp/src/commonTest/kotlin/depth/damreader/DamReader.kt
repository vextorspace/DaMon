package depth.damreader

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking

class DamReader(val damUrl: String) {

    fun readingsResponseString(): String? {
        return runBlocking{getResponse()}
    }

    private suspend fun getResponse(): String? {
        val client = HttpClient()

        try {
            val response = client.request("${damUrl}range/2024-04-22/2024-04-23") {
                method = HttpMethod.Get
            }
            return response.bodyAsText()
        } catch (e: Exception) {
            return null
        }
    }
}
