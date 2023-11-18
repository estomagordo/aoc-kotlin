package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D11 : Solution {

    private fun areConsecutive(a: Char, b: Char): Boolean = b.code - a.code == 1

    private fun hasThreeStretch(s: String): Boolean = (2..<s.length).any { areConsecutive(s[it-2], s[it-1]) && areConsecutive(s[it-1], s[it]) }

    private fun hasForbiddenChars(s: String): Boolean = s.any { "iol".contains(it) }

    private fun hasMultipleDisjointPairs(s: String): Boolean {
        val pairIndices = (1..<s.length).filter { s[it] == s[it-1] }
        return pairIndices.size > 1 && pairIndices.max() - pairIndices.min() > 1
    }

    private fun valid(s: String): Boolean = hasThreeStretch(s) && !hasForbiddenChars(s) && hasMultipleDisjointPairs(s)

    private fun increment(s: String): String {
        val listRep = s.toMutableList()
        var i = listRep.size - 1

        while (true) {
            listRep[i] = listRep[i].inc()

            if (listRep[i] == 'z'.inc()) {
                listRep[i] = 'a'
                i--
            } else {
                break
            }
        }

        return listRep.joinToString("")
    }

    private fun next(s: String): String {
        var t = increment(s)

        while (!valid(t)) {
            t = increment(t)
        }

        return t
    }

    override fun partOne(input: String): String {
        return next(input)
    }

    override fun partTwo(input: String): String {
        return next(next(input))
    }
}
