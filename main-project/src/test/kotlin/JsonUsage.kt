import org.json.JSONObject
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JsonUsage {

    @Test
    fun parseJson() {
        val jsonObject = JSONObject()
        jsonObject.put("number", 1)

        assertEquals(jsonObject.toString(), "{\"number\":1}")
        assertEquals(1, jsonObject.getInt("number"))
    }

}