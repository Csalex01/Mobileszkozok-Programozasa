

import kotlin.io.println
import kotlin.math.sqrt
import java.util.Base64

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
fun decode(msg: String): String = Base64.getDecoder().decode(msg).toString()
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
    val msg_decoded = messageCoding(msg, ::decode)

    println("Original message: $msg")
    println("Encoded message: $msg_encoded")
    println("Decoded message: $msg_decoded")

    // Task #5

    println("\n----- Task #5 ------")

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    numbers.filter { isEvenNumber(it) }
    .forEach{ print("$it, ") }
}