
fun String.printMonogram() {
    val names = this.split(" ")
    val initials = names.map { it.first().uppercaseChar() }

    println("\tInitial for $this: ${initials.joinToString("")}")
}

fun List<String>.joinWithSeparator(separator: String): String {
    return this.joinToString(separator)
}

fun List<String>.findLongestWord(): String {
    var longest: String = ""

    this.forEach {
        if (it.length > longest.length)
            longest = it
    }

    return longest
}

fun main() {

    println("Monograms:")

    var names: List<String> = listOf(
        "John Doe", 
        "Jane Doe", 
        "John Smith", 
        "Jane Smith"
    )    
    names.forEach { it.printMonogram() }

    print("\nJoin with separator: ")

    var words: List<String> = listOf(
        "apple",
        "pear",
        "melon",
        "coconut"
    )
    print(words.joinWithSeparator("#"))

    println("\n\nLongest word: ${words.findLongestWord()}")
}