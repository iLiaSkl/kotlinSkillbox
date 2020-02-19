package module_3

import kotlin.math.abs

fun main(){
    println("Введите количество чисел: ")
    val inputNumber = readLine()?.toIntOrNull()
    inputNumber?.let { getNumberFromConsole(it) }

}

fun getNumberFromConsole(inputNumber: Int): MutableList<Int>  {
    val numbersList = mutableListOf<Int>()
    val positiveNumbers = mutableListOf<Int>()

    for (item in 1..inputNumber) {
        println("Введите $item число:")
        val number = readLine()?.toIntOrNull() ?: continue
        numbersList.add(number)
        if (number > 0){
            positiveNumbers.add(number)
        }
    }

    val evenNumbers = numbersList.filter { it % 2 == 0 }
    val allNumbersSum = numbersList.sum()
    val nodNumbersList = mutableListOf<Int>()
    val numbersSet = numbersList.toSet()
    val uniqueNumbersCount = numbersSet.distinct()

    numbersList.forEach {
        val nodNumber = findGCDValue(it, allNumbersSum)

        nodNumbersList.add(nodNumber)

        val map = mapOf(
            it to nodNumber
        )
        println(map)
        println("Int $it, sum $allNumbersSum, NOD $nodNumber")
    }

    println("All numbers $numbersList")
    println("Positive numbers $positiveNumbers")
    println("Unique numbers: $uniqueNumbersCount")
    println("Even numbers $evenNumbers")
    println("Sum: $allNumbersSum")


    return numbersList
}

tailrec fun findGCDValue(n1: Int, n2: Int): Int =
    when {
        n1 == n2 -> n1
        n1 > n2 -> findGCDValue(n1 - n2, n2)
        else -> findGCDValue(abs(n1), n2-n1)
    }
