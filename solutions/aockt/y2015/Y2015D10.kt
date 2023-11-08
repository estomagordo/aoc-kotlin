package aockt.y2015

import aockt.helpers.lines
import io.github.jadarma.aockt.core.Solution
import kotlin.math.max
import kotlin.math.min

object Y2015D10 : Solution {

    private fun lookAndSay(s: String, n: Int): String {
        var out = s

        repeat(n) {
            out = buildString {
                var prev = ' '
                var length = 0

                out.forEach {
                    if (it == prev) {
                        length++
                    } else {
                        if (length > 0) {
                            append(length.toString())
                            append(prev)
                        }
                        prev = it
                        length = 1
                    }
                }

                append(length.toString())
                append(prev)
            }
        }

        return out
    }

    override fun partOne(input: String): Int {
        return lookAndSay(input, 40).length
    }

    override fun partTwo(input: String): Int {
        return lookAndSay(input, 50).length
    }
}
