
import java.io.File

data class Answer(
    val value: String,
    val isCorrect: Boolean
)

data class Item (
    val answers: MutableList<Answer>,
    val correct: Int,
    val question: String
)

object ItemRepository {
    public val items: MutableList<Item> = mutableListOf()

    init {
        val lines = File("resources/questions.txt").useLines() { it.toList() }

        for (i in lines.indices step 6) {
            val question: String = lines[i]
            val correct: Int = lines[i + 5].toInt()

            val answers: MutableList<Answer> = mutableListOf()

            for (j in 1..4) 
                answers.add(Answer(lines[i + j], j == correct))

            save(Item(answers, correct, question))
        }
    }

    public fun randomItem(): Item = this.items.random()
    public fun save(item: Item): Boolean = this.items.add(item)
    public fun size(): Int = this.items.size
    
    public fun print(): Unit {
        for (item in this.items) {
            println(item.question)
            for(answer in item.answers) {
                println(answer.value)
            }
            println("Answer: ${item.correct}")
            println()
        }
    }
}

class ItemService(private val itemRepository: ItemRepository) {
    public fun selectRandomItems(numberOfItems: Int): List<Item> {

        if (numberOfItems > itemRepository.size()) {
            println("Number of items is greater than the number of items in the repository")
            return emptyList()
        }

        val items: MutableList<Item> = mutableListOf()

        while (items.size < numberOfItems) {
            val item: Item = itemRepository.randomItem()
            if (!items.contains(item)) {
                items.add(item)
            }
        }

        return items
    }
}

class ItemController(private val itemService: ItemService) {

    private var score: Int = 0

    private fun quiz(numberOfItems: Int): Unit {
        val items: List<Item> = itemService.selectRandomItems(numberOfItems)

        var index = 1

        for(item in items) {
            println("Question #${index++}: ${item.question}")
            for(answer in item.answers) {
                println(answer.value)
            }

            print("Your answer: ")
            val answer: Int = readLine()!!.toInt()

            if(answer == item.correct) {
                print("Correct answer!")
                score += 1
            } else {
                print("Incorrect answer!")
            }

            print(" Score: ${score}/${numberOfItems}")
            println("")
            println("")
        }

        print("Final score: ${score}/${numberOfItems}")
    }

    public fun startQuiz() {
        println("Welcome to the quiz!")
        print("Please select the number of questions you want to answer: ")
        
        val numberOfItems: Int = readLine()!!.toInt()
        println("")

        quiz(numberOfItems)
    }
}

fun main()
{
    val itemController: ItemController = ItemController(ItemService(ItemRepository))
    
    itemController.startQuiz()
}