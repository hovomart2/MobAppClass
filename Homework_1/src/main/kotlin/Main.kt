import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Person(val name: String, val age: Int) {
    fun getLifeStage(): String {
        return when {
            age < 0 -> "Invalid"
            age in 0..10 -> "Child"
            age in 10..18 -> "Teenager"
            else -> "Adult"
        }
    }
}

fun main() {
    exercise1()
    exercise2()
    exercise3()
    exercise4()
    exercise5()
    exercise6(3500.0, 0.0)
    println()
    println(exercise6(343.0, 7.0))
    println()
    exercise7()
    exercise8()
    exercise9()
    exercise10()
}

private fun exercise1() {
    println("Exercise 1")
    val array = intArrayOf(100, 235, 684, 777, 684562)
    val list = listOf("Dog", "Cat", "Pig", "Lion")
    println("From array")
    for (i in array) {
        print(i);
        print(" ");
    }
    println("From list:")
    for (element in list) {
        print(element)
        print(" ");
    }
    println()
    println()
}

private fun exercise2() {
    println("Exercise 2")
    val string = "My name is "
    val concatStr = string + "Hovhannes"
    println("Concatenated String: $concatStr")
    val substring = string.substring(10)
    println("Substring: $substring")
    val uppercase = string.uppercase(Locale.getDefault())
    println("Uppercase String: $uppercase")
    val lowercase = string.lowercase(Locale.getDefault())
    println("Lowercase String: $lowercase")
    println()
}

private fun exercise3() {
    println("Exercise 3")
    val myMap = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
    )
    myMap.forEach { entry -> print(entry.key) }
    println()
    myMap.forEach { entry -> print(entry.value) }
    println()
    println()
}

private fun exercise4(number: Int): String {
    if (number > 0) {
        return "Positive"
    } else if (number < 0) {
        return "Negative"
    }
    return "Zero"
}

private fun exercise4() {
    println("Exercise 4")
    val number1 = -32135
    val number2 = 0
    val number3 = 35468
    val number4 = 3
    val number5 = -76666668
    println("Number $number1 is ${exercise4(number1)}")
    println("Number $number2 is ${exercise4(number2)}")
    println("Number $number3 is ${exercise4(number3)}")
    println("Number $number4 is ${exercise4(number4)}")
    println("Number $number5 is ${exercise4(number5)}")
    println()
}

private fun exercise5() {
    println("Exercise 5")
    val scanner = Scanner(System.`in`)
    print("Please write your name ")
    val name = readLine()
    print("Please write your age ")
    val age = scanner.nextInt()
    if (age <= 0) {
        println("age cannot be negative")
        return
    }
    when (age) {
        in 0..10 -> println("Hi, $name! You are a kid")
        in 10..18 -> println("Hi, $name! You are a teenager")
        else -> println("Hi, $name! You are an adult")
    }
    println()
}

private fun exercise6(number: Double, divisor: Double): Double? {
    println("Exercise 6")
    if (divisor == 0.0) {
        println("Cannot divide by zero")
        return null
    }
    return number / divisor
}

private fun exercise7() {
    println("Exercise 7")
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formattedDateTime = currentDateTime.format(formatter)
    println(formattedDateTime)
    println()
}

private fun exercise8() {
    println("Exercise 8")
    val person = Person("Hovo", 20)
    println("Person's Name: ${person.name}")
    println("Person's Age: ${person.age}")
    println()
}

private fun exercise9() {
    println("Exercise 9")
    val person = Person("Hovo", 20)
    println("LifeStage: " + person.getLifeStage())
    println()
}

private fun exercise10() {
    println("Exercise 10")
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
        17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
    val evens = numbers.filter { it % 2 == 0 }
    println(evens)
}
