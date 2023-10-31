package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D02 : Solution {

    private fun parseLine(input: String): List<Int> =
        input.split('x').map(String::toInt)

    private fun parseInput(input: String): List<List<Int>> =
        input.split('\n').map(Y2015D02::parseLine)

    private fun sideArea(a: Int, b: Int): Int =
        a * b

    private fun allAreas(sides: List<Int>): List<Int> =
        listOf(sideArea(sides[0], sides[1]), sideArea(sides[0], sides[2]), sideArea(sides[1], sides[2]))

    private fun paper(sides: List<Int>): Int {
        val areas = allAreas(sides)

        return areas.sum() * 2 + areas.min()
    }

    private fun ribbon(sides: List<Int>): Int {
        val mid = sides.sum() - sides.min() - sides.max()

        return 2 * (sides.min() + mid) + sides.reduce {acc, next -> acc * next}
    }

    override fun partOne(input: String): Int {
        return parseInput(input).map(Y2015D02::paper).sum()
    }

    override fun partTwo(input: String): Int {
        return parseInput(input).map(Y2015D02::ribbon).sum()
    }
}
