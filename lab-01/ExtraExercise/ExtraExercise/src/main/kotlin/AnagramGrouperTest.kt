import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

fun groupAnagrams(anagrams: Array<String>): Array<String> {
    return arrayOf("Hello")
}

class AnagramGrouperTest {
    @Test
    fun threeGroupsAllLowerCase(groupAnagrams: (Array<String>) -> Array<String>) {
        val anagrams: Array<String> = groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat").toTypedArray())
        assertEquals(3, anagrams.size)

        assertTrue(anagrams.contains(listOf("eat", "tea", "ate").joinToString(separator = "")))
        assertTrue(anagrams.contains(listOf("tan", "nat").joinToString(separator = "")))
        assertTrue(anagrams.contains("bat"))
    }

}