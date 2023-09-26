import kotlin.io.println
import kotlin.math.sqrt
import java.util.Base64
import kotlin.random.Random

fun isPrime(n: Int): Boolean {
    if (n < 2)
        return false

    for(i in 2..sqrt(n.toDouble()).toInt())
        if(n % i == 0)
            return false

    return true
}

fun isEvenNumber(a: Int): Boolean = a % 2 == 0

fun encode(msg: String): String = Base64.getEncoder().encodeToString(msg.toByteArray())
fun decode(msg: String): String = String(Base64.getDecoder().decode(msg))
fun messageCoding(msg: String, func: (String) -> String): String = func(msg)

fun main() {

    // Task #1

    println("----- Task #1 ------")
    
    var a: Int = 2
    var b: Int = 3
    var sum: Int = a + b

    println("Method #1: $a + $b = $sum")
    println("Method #2: $a + $b = ${a + b}")
    
    // Task #2

    println("\n----- Task #2 ------")

    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    println("a.)")
    for (day in days) 
        println("$day")

    println("b.)")

    days.filter { it.startsWith("T") }
    .forEach { println(it) }

    println("c.)")
    days.filter { it.contains("e") }
    .forEach { println(it) }

    println("d.)")
    days.filter { it.length == 6 }
    .forEach { println(it) }

    // Task #3

    println("\n----- Task #3 ------")
    
    for(i in 1..100)
        if(isPrime(i))
            print("$i, ")
    
    // Task #4

    println("\n\n----- Task #4 ------")
    
    val msg = "Hello, World!"
    val msg_encoded = messageCoding(msg, ::encode)
    val msg_decoded = messageCoding(msg_encoded, ::decode)

    println("Original message: $msg")
    println("Encoded message: $msg_encoded")
    println("Decoded message: $msg_decoded")

    // Task #5

    println("\n----- Task #5 ------")

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    numbers.filter { isEvenNumber(it) }
    .forEach{ print("$it, ") }

    // Task #6

    println("\n\n----- Task #6 ------")

    println("a.)")

    val doubledNumbers = numbers.map { it * 2 }
    doubledNumbers.forEach { print("$it, ") }

    println("\nb.)")
    val capitalisedDays = days.map { it.toUpperCase() }
    capitalisedDays.forEach { print("$it, ") }

    println("\nc.)")

    val firstLetter = days.map{ it[0] }
    firstLetter.forEach { print("$it, ") }

    println("\nd.)")

    val lenOfDays = days.map{ it.length }
    lenOfDays.forEach { print("$it, ") }

    println("\ne.)")
    print("Average: ${lenOfDays.sum().toFloat() / lenOfDays.size}")

    // Task #7

    println("\n----- Task #7 ------")
    val mutableDays = days.toMutableList()
    mutableDays.removeIf{ it.contains("n") }
    mutableDays.sort()

    for((index, value) in mutableDays.withIndex()) {
        println("Item at $index is $value")
    }

    // Task #8

    println("\n----- Task #8 ------")
    
    val random = Random(System.currentTimeMillis())
    val arraySize = 10
    val randomNumbers = IntArray(arraySize) { random.nextInt(101) }
    randomNumbers.sort()
    
    randomNumbers.forEach{ println(it) }

    var containsEven: Boolean = false
    var allNumbersEven: Boolean = true

    randomNumbers.forEach {
        if(it % 2 == 0)
            containsEven = true
        else
            allNumbersEven = false
    }

    if(containsEven) println("Contains even numbers!") else println("Doesn't contain even numbers!")
    if(allNumbersEven) println("All numbers are even!") else println("Not every number is even!")

    var sumFloat: Float = 0.0f
    randomNumbers.forEach{ sumFloat += it }

    print("Average: ${sumFloat / randomNumbers.size}")
}