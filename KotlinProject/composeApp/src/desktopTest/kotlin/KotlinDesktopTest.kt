import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.fail

class KotlinDesktopTest {

    @Test
    fun `test an assert`() {
        assertTrue(true)
        fail("whoopsie desktop")
    }
}