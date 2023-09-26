
import org.junit.Test

fun main() {

    var tester: AnagramGrouperTest = AnagramGrouperTest()

}

fun groupAnagrams(anagrams: Array<String>) {

}

class AnagramGrouperTest {

    fun threeGroupsAllLowerCase() {
        val anagrams = groupAnagrams(listOf("eat", "tea", "tan", "ate", "bat").toTypedArray())
        assertEquals(3, anagrams.size)
    }

}