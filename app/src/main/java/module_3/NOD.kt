package module_3

import kotlin.math.abs
import kotlin.math.absoluteValue



fun main(){

    println("Input number: ")

    getNumbersFromConsole()

}

fun getNumbersFromConsole() {
    var nodNumber: Int = 0
    var numbers: Int? = null
    val numbersList = mutableListOf<Int>()
    val nodNumbersList = arrayListOf<Int>()
    val positiveNumbers = mutableListOf<Int>()
    val inputNumber : Int = readLine()?.toIntOrNull() ?: return
    var currentNumber: Int = 0

    while (currentNumber < inputNumber) {
        numbers = readLine()?.toIntOrNull()

        numbers?.let { numbersList.add(it) }
        if (numbers != null) {
            if(numbers > 0){
                positiveNumbers.add(numbers)
            }
        }
        currentNumber++
    }

    val setNumbers = numbers?.let { setOf(it) }
    val uniqueNumbersCount = setNumbers?.distinct()
    val evenNumbers = numbersList.filter { it % 2 == 0 }
    val allNumbersSum = numbersList.sum()



    println("All numbers $numbersList")
    println("Positive numbers $positiveNumbers")
    println("Even numbers $evenNumbers")
    println("Unique values: $uniqueNumbersCount")
    println("Sum: $allNumbersSum")


    for (i in numbersList) {
        nodNumber = nod(i, allNumbersSum)

        nodNumbersList.add(nodNumber)

        val map = mapOf(
            i to nodNumber
        )

        println(map)
        println("Int $i, sum $allNumbersSum, NOD $nodNumber")
    }
}

fun nod(a: Int, b: Int): Int {

    var a = a
    var b = b

    while (b != 0) {
        val tmp = a % b
        a = b
        b = tmp
    }
    return abs(a)
}
