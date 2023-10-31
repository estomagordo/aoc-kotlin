package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D03 : Solution {

    private fun path(path: String): Set<Pair<Int, Int>> {
        var y = 0
        var x = 0
        var seen = mutableSetOf(Pair(y, x))

        path.forEach {
            when {
                it == '<' -> x -= 1
                it == '>' -> x += 1
                it == '^' -> y -= 1
                else -> y += 1
            }

            seen.add(Pair(y, x))
        }

        return seen
    }

    override fun partOne(input: String): Int {
        return path(input).size
    }

    override fun partTwo(input: String): Int {
        val santa = path(input.slice(0..<input.length step 2))
        val roboSanta = path(input.slice(1..<input.length step 2))

        return santa.union(roboSanta).size
    }
}
