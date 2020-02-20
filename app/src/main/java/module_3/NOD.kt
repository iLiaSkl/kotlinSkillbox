package module_3

import kotlin.math.abs

fun main(){

    println("Введите количество чисел: ")
    val inputNumber = readLine()?.toIntOrNull() ?: return
    val numbersList =  getNumbersFromConsole(inputNumber)
    val positiveNumbers = mutableListOf<Int>()

    numbersList.forEach { if (it > 0){
        positiveNumbers.add(it) } }

    println("Positive numbers: ${positiveNumbers.size}")

    println(numbersList.filter { it % 2 == 0 })

    numbersList.sum()

    println("Unique numbers: ${numbersList.toSet().size}")


    numbersList.forEach {
        val nodNumber = findGreatestCommonDividerValue(it, numbersList.toSet().sum())

        mapOf(
            it to nodNumber
        )

        println("Int $it, sum ${numbersList.toSet().sum()}, NOD $nodNumber")
    }

}

fun getNumbersFromConsole(inputNumber: Int): MutableList<Int>  {

    val numbersList = mutableListOf<Int>()
    for (item in 1..inputNumber) {
        println("Введите $item число:")
        val number = readLine()?.toIntOrNull() ?: continue
        numbersList.add(number)
    }
    return numbersList
}

tailrec fun findGreatestCommonDividerValue(n1: Int, n2: Int): Int =
    when {
        n1 == n2 -> n1
        n1 > n2 -> findGreatestCommonDividerValue(n1 - n2, n2)
        else -> findGreatestCommonDividerValue(abs(n1), n2-n1)
    }
