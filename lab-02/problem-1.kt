import java.io.File

import java.util.TreeSet
import java.util.HashSet

enum class DictionaryType {
    ARRAY_LIST,
    TREE_SET,
    HASH_SET
}

interface IDictionary {
    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int
}

class ArrayListDictionary: IDictionary {
    private val words: MutableList<String> = mutableListOf<String>()

    constructor() {
        File("resources/dict.txt").forEachLine { this.words.add(it) }
        println("ArrayListDictionary loaded with ${this.words.size} words.")
    }

    override public fun add(word: String): Boolean = this.words.add(word)
    override public fun find(word: String): Boolean = this.words.find { it == word } != null
    override public fun size(): Int = this.words.size
}

class TreeSetDictionary: IDictionary {
    private val words: TreeSet<String> = TreeSet<String>()

    constructor() {
        File("resources/dict.txt").forEachLine { this.words.add(it) }
        println("TreeSetDictionary loaded with ${this.words.size} words.")
    }

    override public fun add(word: String): Boolean = this.words.add(word)
    override public fun find(word: String): Boolean = this.words.find { it == word } != null
    override public fun size(): Int = this.words.size
}

class HashSetDictionary: IDictionary {
    private val words: HashSet<String> = HashSet<String>()

    constructor() {
        File("resources/dict.txt").forEachLine { this.words.add(it) }
        println("HashSetDictionary loaded with ${this.words.size} words.")
    }

    override public fun add(word: String): Boolean = this.words.add(word)
    override public fun find(word: String): Boolean = this.words.find { it == word } != null
    override public fun size(): Int = this.words.size
}

object DictionaryProvider {
    public fun createDictionary(type: DictionaryType): IDictionary {
        return when(type) {
            DictionaryType.ARRAY_LIST -> ArrayListDictionary()
            DictionaryType.TREE_SET   -> TreeSetDictionary()
            DictionaryType.HASH_SET   -> HashSetDictionary()
        }
    }
}

/* Other solution

class DictionaryProvider {
    companion object {
        public fun createDictionary(type: DictionaryType): IDictionary {
            return when(type) {
                DictionaryType.ARRAY_LIST -> ArrayListDictionary()
                DictionaryType.TREE_SET   -> TreeSetDictionary()
                DictionaryType.HASH_SET   -> HashSetDictionary()
            }
        }
    }
}

*/

fun main() {
    println("----- Problem #1 -----")

    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)

    println("Number of words: ${dict.size()}")

    var word: String?

    while(true) {
        print("Word to find: ")
        word = readLine()

        if(word.equals("quit")) break

        println("Result: ${word?.let { dict.find(it) }}")
    }
}