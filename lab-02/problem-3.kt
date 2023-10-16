
import java.time.LocalDate
import kotlin.collections.mutableListOf

data class Date (
    val year: Int = LocalDate.now().year, 
    val month: Int = LocalDate.now().monthValue, 
    val day: Int = LocalDate.now().dayOfMonth
) : Comparable<Date> {

    override fun compareTo(other: Date): Int {
        if (this.year != other.year) return this.year - other.year
        if (this.month != other.month) return this.month - other.month
        return this.day - other.day
    }

}

class MonthComparator : Comparator<Date> {
    override fun compare(date1: Date, date2: Date): Int {
        return when {
            date1.month < date2.month -> -1
            date1.month > date2.month ->  1
            else                      -> 0
        }
    }
}

fun Date.isLeapYear(): Boolean {
    return this.year % 4 == 0 && 
           this.year % 100 != 0 || 
           this.year % 400 == 0
}

fun Date.isValidDate(): Boolean {
    if (this.month < 1 || this.month > 12) {
        return false
    }

    val maxDaysInMonth = when (this.month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11           -> 30
        2                     -> if (this.isLeapYear()) 29 else 28
        else                  -> return false
    }

    return day >= 1 && day <= maxDaysInMonth
}

fun Date.printDateInfo(): Unit {
    println("----------")
    println("Date: ${this.year}/${this.month}/${this.day}")
    println("${this.year} is ${if(this.isLeapYear()) "" else "not "}a leap year.")
    println("The date ${this.year}/${this.month}/${this.day} is ${if(this.isValidDate()) "" else "not "}valid.")
    println("----------")
}

fun Date.printDate(): Unit {
    println("${this.year}/${this.month}/${this.day}")
}

fun main() {

    val validDates: MutableList<Date> = mutableListOf()
    val invalidDates: MutableList<Date> = mutableListOf()
    
    while(validDates.size < 10) {
        val date = Date(
            (Math.random() * 1000).toInt() + 1000, 
            (Math.random() * 12).toInt() + 1, 
            (Math.random() * 30).toInt() + 1
        )

        if (date.isValidDate()) 
            validDates.add(date)
        else 
            invalidDates.add(date)
    }

    println("Valid date count: ${validDates.size}")
    println("Invalid date count: ${invalidDates.size}")

    println("\nValid dates: ")
    validDates.forEach { it.printDate() }
    println("")

    val validDatesSorted: MutableList<Date> = validDates.toMutableList()
    validDatesSorted.sort()

    println("Sorted dates: ")
    validDatesSorted.forEach { it.printDate() }
    println("")

    val validDatesSortedReversed: MutableList<Date> = validDatesSorted.toMutableList()
    validDatesSortedReversed.reverse()

    println("Sorted dates reversed: ")
    validDatesSortedReversed.forEach { it.printDate() }
    println("")

    val validDatesCustomOrdering: MutableList<Date> = validDates.toMutableList()
    validDatesCustomOrdering.sortWith(MonthComparator())

    println("Sorted dates with custom ordering: ")
    validDatesCustomOrdering.forEach { it.printDate() }
    println("")
}