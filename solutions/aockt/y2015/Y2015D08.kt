package aockt.y2015

import aockt.helpers.isHexadecimal
import aockt.helpers.lines
import io.github.jadarma.aockt.core.Solution

object Y2015D08 : Solution {
    data class Escapes(val doubleQuotes: Int,
                       val hexEscapes: Int,
                       val backSlashes: Int,
                       val tripleBackslashes: Int,
                       val quadrupleBackslashes: Int
    )

    private fun countEscapes(s: String): Escapes {
        val doubleQuotes = s.count { it == '"' }
        val hexEscapes = (3..<s.length).count {
            s[it].isHexadecimal() &&
                s[it - 1].isHexadecimal() &&
                s[it - 2] == 'x' &&
                s[it - 3] == '\\'
        }
        val backslashes = (1..<s.length).count {
            s[it] == '\\' &&
                s[it - 1] == '\\'
        }
        val tripleBackslashes = (2..<s.length).count {
            s[it] == '\\' &&
                    s[it - 1] == '\\' &&
                    s[it - 2] == '\\'
        }
        val quadrupleBackslashes = (2..<s.length).count {
            s[it] == '\\' &&
                    s[it - 1] == '\\' &&
                    s[it - 2] == '\\' &&
                    s[it - 3] == '\\'
        }

        return Escapes(doubleQuotes, hexEscapes, backslashes, tripleBackslashes, quadrupleBackslashes)
    }
    private fun countDecodingDifference(s: String): Int {
        val occurrences = countEscapes(s)

        return occurrences.doubleQuotes + occurrences.hexEscapes * 3 + occurrences.backSlashes - occurrences.tripleBackslashes + occurrences.quadrupleBackslashes
    }

    private fun countEncodingDifference(s: String): Int {
        val occurrences = countEscapes(s)

        return occurrences.doubleQuotes * 2 + occurrences.hexEscapes + occurrences.backSlashes * 2 - occurrences.tripleBackslashes * 2 + occurrences.quadrupleBackslashes * 2
    }

    override fun partOne(input: String): Int {
        return input.lines().sumOf { countDecodingDifference(it) }
    }

    override fun partTwo(input: String): Int {
        return input.lines().sumOf { countEncodingDifference(it) }
    }
}
