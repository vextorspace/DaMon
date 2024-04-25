package depth.jsonreader

import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test

class JSonReaderTranslatesTest {

    @Test
    fun `should translate json to depth`() {
        val depth = 489.83
        val jsonString = makeSampleDataWithDepth(depth)
        val depthReading = JSonReader(jsonString).readDam()

        depthReading.shouldNotBeNull()
            .depth()
            .shouldBeExactly(depth)
    }

    @Test
    fun `should translate json with no decimal to depth`() {
        val depth = 127
        val jsonString = makeSampleDataWithDepth(depth)
          val depthReading = JSonReader(jsonString).readDam()

        depthReading.shouldNotBeNull()
            .depth()
            .shouldBeExactly(127.0)
    }

    private fun makeSampleDataWithDepth(depth: Number): String {
        val json = """
            {
            "comments": [
                "NOTICE: These data readings are preliminary."
            ],
            "metadata": {
                "id": 4002
            },
            "columns": {
                "id": "Sensor ID",
                "timestamp": "Date and Time (Pacific)",
                "value": "Elevation (ft)",
                "rating": "Storage (ac-ft)"
            },
            "data": [
                {
                    "id": 4002,
                    "timestamp": "2024-04-22T00:00:00-08:00",
                    "value": $depth,
                    "rating": 3590.98
                },
                {
                    "id": 4002,
                    "timestamp": "2024-04-22T00:15:00-08:00",
                    "value": 489.84,
                    "rating": 3592.67
                }
            ]
            }
            """.trimIndent()
        return json
    }

}