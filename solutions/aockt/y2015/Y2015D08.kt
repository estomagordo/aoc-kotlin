package aockt.y2015

import aockt.helpers.isHexadecimal
import aockt.helpers.lines
import io.github.jadarma.aockt.core.Solution

object Y2015D08 : Solution {
    private fun countDifference(s: String): Int {
        val doubleQuotes = s.count { it == '"' }
        val hexEscapes = (3..<s.length).count {
            s[it].isHexadecimal() &&
                s[it - 1].isHexadecimal() &&
                s[it - 2] == 'x' &&
                s[it - 3] == '\\'
        }
        return doubleQuotes + hexEscapes * 3
    }

    override fun partOne(input: String): Int {
        return input.lines().map { countDifference(it) }.sum()
    }

    override fun partTwo(input: String): Int {
        return 4
    }
}
