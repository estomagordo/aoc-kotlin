package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D01 : Solution {

    override fun partOne(input: String) : Int {
        var floor = 0

        input.forEach {
            if (it == '(') {
                floor += 1
            } else {
                floor -= 1
            }
        }

        return floor
    }

    override fun partTwo(input: String) : Int {
        var floor = 0
        var step = 0

        for (c in input) {
            step += 1

            if (c == '(') {
                floor += 1
            } else {
                floor -= 1

                if (floor == -1) {
                    break
                }
            }
        }

        return step
    }
}
