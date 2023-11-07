package aockt.y2015

import aockt.helpers.isHexadecimal
import aockt.helpers.lines
import io.github.jadarma.aockt.core.Solution

object Y2015D08 : Solution {
    private fun countDoubleQuotesAndHexes(s: String): Pair<Int, Int> {
        val doubleQuotes = s.count { it == '"' }
        val hexEscapes = (3..<s.length).count {
            s[it].isHexadecimal() &&
                s[it - 1].isHexadecimal() &&
                s[it - 2] == 'x' &&
                s[it - 3] == '\\'
        }
        return Pair(doubleQuotes, hexEscapes)
    }
    private fun countDecodingDifference(s: String): Int {
        val occurrences = countDoubleQuotesAndHexes(s)

        return occurrences.first + occurrences.second * 3
    }

    private fun countEncodingDifference(s: String): Int {
        val occurrences = countDoubleQuotesAndHexes(s)

        return occurrences.first * 2 + occurrences.second
    }

    override fun partOne(input: String): Int {
        return input.lines().sumOf { countDecodingDifference(it) }
    }

    override fun partTwo(input: String): Int {
        return input.lines().sumOf { countEncodingDifference(it) }
    }
}
