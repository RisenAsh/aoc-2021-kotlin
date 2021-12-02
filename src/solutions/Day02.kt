package solutions

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0

        input.indices.forEach {
            val instruction = input[it].split(" ")

            when (instruction[0]) {
                "forward" -> x += instruction[1].toInt()
                "up" -> y -= instruction[1].toInt()
                "down" -> y += instruction[1].toInt()
                else -> print("Error in input.")
            }
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var z = 0

        input.indices.forEach {
            val instruction = input[it].split(" ")

            when (instruction[0]) {
                "forward" -> {
                    x += instruction[1].toInt()
                    y += z * instruction[1].toInt()
                }
                "up" -> z -= instruction[1].toInt()
                "down" -> z += instruction[1].toInt()
                else -> print("Error in input.")
            }
        }

        return x * y
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
