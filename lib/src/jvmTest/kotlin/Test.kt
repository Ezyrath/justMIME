import kotlin.test.Test
import kotlin.test.assertEquals

class LibTest {
    @Test
    fun testMimeGetExtension() {
        val mime = MIMEResolver()
        assertEquals(mime.getByExtension("pdf"), "application/pdf")
    }

    @Test
    fun testMimeGetName() {
        val mime = MIMEResolver()
        assertEquals(mime.getByName("application/pdf"), "pdf")
    }
}
