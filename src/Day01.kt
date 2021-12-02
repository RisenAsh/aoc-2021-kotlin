fun main() {
    fun part1(input: List<String>): Int {

        var result = 0

        (input.map { it.toInt() }).indices.forEach {
            if (it != 0 && input[it] > input[it - 1]) result++
        }

        return result
    }

    fun part2(input: List<String>): Int {

        var result = 0

        val sum = input.windowed(3, 1).map { it -> it.sumOf { it.toInt() } }

        sum.indices.forEach {
            if (it != 0 && sum[it] > sum[it - 1]) result++
        }

        return result
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
