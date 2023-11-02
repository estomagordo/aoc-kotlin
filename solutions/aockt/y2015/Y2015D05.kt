package aockt.y2015

import io.github.jadarma.aockt.core.Solution
import java.security.MessageDigest

object Y2015D05 : Solution {

    private fun isNice(s: String): Boolean {
        val vowels = "aeiou"
        val badPairs = setOf("ab", "cd", "pq", "xy")

        val hasAtLeastThreeVowels = s.count { vowels.contains(it) } > 2
        val hasDouble = (1..<s.length).map { s[it] == s[it - 1] }.any { it }
        val hasBadPair = badPairs.any { s.contains(it) }

        return hasAtLeastThreeVowels && hasDouble && !hasBadPair
    }

    private fun isNiceTwo(s: String): Boolean {
        val pairLocations = mutableMapOf<String, MutableList<Int>>()
        (1..<s.length).map {
            val pair = s.slice(it - 1..it)

            if (!pairLocations.containsKey(pair)) {
                pairLocations[pair] = mutableListOf()
            }

            pairLocations[pair]?.add(it - 1)
        }

        val hasRepeatPairWithoutOverlap = pairLocations.values.any {
            it.size > 1 && it.max() - it.min() > 1
        }
        val hasRepeatWithGap = (2..<s.length).map { s[it] == s[it - 2] }.any { it }

        return hasRepeatPairWithoutOverlap && hasRepeatWithGap
    }

    override fun partOne(input: String): Int {
        return input.split("\n").map(Y2015D05::isNice).count { it }
    }

    override fun partTwo(input: String): Int {
        return input.split("\n").map(Y2015D05::isNiceTwo).count { it }
    }
}
