package solutions

import readInput

fun main() {
    fun part1(input: List<Int>): Int {
        var result = 0

        input.indices.forEach {
            if (it != 0 && input[it] > input[it - 1]) result++
        }

        return result
    }

    fun part2(input: List<Int>): Int {
        var result = 0
        val sum = input.windowed(3, 1).map { it.sum() }

        sum.indices.forEach {
            if (it != 0 && sum[it] > sum[it - 1]) result++
        }

        return result
    }

    val input = readInput("Day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}
