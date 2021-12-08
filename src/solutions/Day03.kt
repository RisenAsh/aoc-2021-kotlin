package solutions

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val chunkedCount: MutableList<Int> = (input[0].chunked(1)).map { it.toInt() }.toMutableList()
        var gamma = ""
        var epsilon = ""

        input.indices.forEach { outer ->
            input[outer].indices.forEach { inner ->
                chunkedCount[inner] += input[outer][inner].digitToInt()
            }
        }

        chunkedCount.indices.forEach {
            if (input.size.div(chunkedCount[it]) == 1) {
                gamma += "1"
                epsilon += "0"
            } else {
                gamma += "0"
                epsilon += "1"
            }
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun List<String>.filterBy(pos: Int, defaultWhenEqual: String, sort: (Map<Char, List<Char>>) -> Char): List<String> {
        if (this.size == 1) return this
        val groupedInput = this.map { it[pos] }.groupBy { it }
        val isEqual = groupedInput.values.toMutableList()[0].size == groupedInput.values.toMutableList()[1].size
        return this.filter {
            if (isEqual) {
                it[pos].toString() == defaultWhenEqual
            } else it[pos] == sort(groupedInput)
        }
    }

    fun part2(input: List<String>): Int {
        var o2: List<String> = input.toMutableList()
        var co2: List<String> = input.toMutableList()

        for (i in input[0].indices) {
            o2 = o2.filterBy(i, "1") { it.maxByOrNull { it.value.size }?.key!! }
            co2 = co2.filterBy(i, "0") { it.minByOrNull { it.value.size }?.key!! }
        }

        return o2[0].toInt(2) * co2[0].toInt(2)
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
