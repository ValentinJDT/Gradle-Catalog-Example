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

    @Test
    fun createHumanJson() {
        val humanJson = JSONObject()
        humanJson.put("hairs", "brown")
        humanJson.put("height", 175)
        humanJson.put("weight", 70)

        assertEquals(humanJson.toString(), "{\"hairs\":\"brown\",\"weight\":70,\"height\":175}")
        assertEquals("brown", humanJson.getString("hairs"))
        assertEquals(175, humanJson.getInt("height"))
        assertEquals(70, humanJson.getInt("weight"))
    }

    /**
     * Un test qui crée une phrase avec un objet JSON.
     */
    @Test
    fun createSentenceWithJson() {
        val jsonObject = JSONObject()
        jsonObject.put("subject", "Le chat")
        jsonObject.put("verb", "mange")
        jsonObject.put("object", "la souris")

        val sentence = "${jsonObject.getString("subject")} ${jsonObject.getString("verb")} ${jsonObject.getString("object")}."

        assertEquals(sentence, "Le chat mange la souris.")
    }

    @Test
    fun createSecondSentenceWithJson() {
        val jsonObject = JSONObject()
        jsonObject.put("subject", "Le chat")
        jsonObject.put("verb", "mange")
        jsonObject.put("object", "la souris")

        val sentence = "${jsonObject.getString("subject")} ${jsonObject.getString("verb")} ${jsonObject.getString("object")}."

        assertEquals(sentence, "Le chat mange la souris.")
    }

    @Test
    fun parseIntToString() {
        val jsonObject = JSONObject()
        jsonObject.put("number", 42)

        val numberStr = jsonObject.getInt("number").toString()

        assertEquals("42", numberStr)
    }

}
