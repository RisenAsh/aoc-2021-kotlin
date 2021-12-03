package solutions

import readInput

fun main() {
    fun count(input: List<Int>): Int {
        var count = 0

        input.indices.forEach {
            if (it != 0 && input[it] > input[it - 1]) count++
        }
        return count
    }

    fun part1(input: List<Int>): Int {
        return count(input)
    }

    fun part2(input: List<Int>): Int {
        val sum = input.windowed(3).map { it.sum() }

        return count(sum)
    }

    val input = readInput("Day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}
