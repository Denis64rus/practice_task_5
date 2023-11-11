package com.example

fun main() {

    // Функция printR ( для вывода типа  введенного значения)
    val cherepaha: Array<Array<Int>> = Array(3, {Array(3, {0})})
    cherepaha[0] = arrayOf(4, 9, 2)
    cherepaha[1] = arrayOf(3, 5, 7)
    cherepaha[2] = arrayOf(8, 1, 6)

    var cub = arrayOf<Array<Array<Int>>>()
    for (i in 0..2) {
        var array1 = arrayOf<Array<Int>>()
        for (j in 0..2) {
            var array2 = arrayOf<Int>()
            for (k in 0..2) {
                array2 += (k + j * 3 + 1) + i * 9
            }
            array1 += array2
        }
        cub += array1
    }

    val data = mapOf(
        "name" to "John",
        "age" to 30,
        "city" to "New York",
        "hobbies" to listOf("Reading", "Gaming"),
        "languages" to arrayOf("Kotlin", "Java", "Swift"),
        "MagicSquare" to cherepaha,
        "Cube" to cub,
    )

    printR(data)


}

fun printR(data: Any?, indent: String="") {

    when(data)
    {
        is Map<*,*> -> {
            println("map:[")
            for((key, value) in data) {
                print(" $indent    [$key] => ")
                printR(value, "                $indent    ")
            }
            println("$indent] ")
            println()
        }
        is List<*> -> {
            println("list:[")
            for(el in data) {
                print("$indent    ")
                printR(el, "$indent    ")
            }
            println("$indent   ] ")
            println()
        }
        is Set<*> -> {
            println("set:[")
            for(el in data) {
                print("$indent     ")
                printR(el, "$indent    ")
            }
            println("$indent] ")
            println()
        }
        is Array<*> -> {
            println("array:[")
            for(el in data) {
                print("  $indent     ")
                printR(el, "$indent    ")
            }
            println("$indent      ] ")
            println()
        }
        else->println("$data")
    }

}

