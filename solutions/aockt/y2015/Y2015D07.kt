package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D07 : Solution {

    override fun partOne(input: String): Int {
        val maxval = 65535
        val instructions = input.split('\n').map { it -> it.split(" ") }
        val executedInstructions = mutableSetOf<Int>()
        val signals = mutableMapOf<String, Int>()

        while (executedInstructions.count() < instructions.count()) {
            instructions.forEachIndexed { i, instruction ->
                val target = instruction.last()
                var executed = false

                if (!executedInstructions.contains(i)) {
                    val a = instruction[0]

                    if (a.all { it.isDigit() }) {
                        signals[target] = instruction[0].toInt()
                        executed = true
                    } else if (a == "NOT") {
                        val b = instruction[1]

                        if (signals.containsKey(b)) {
                            val bval = signals.getOrDefault(b, 0)

                            signals[target] = maxval - bval
                            executed = true
                        }
                    } else if (signals.containsKey(a)) {
                        val aval = signals.getOrDefault(a, 0)

                        if (instruction[2].all { it.isDigit() }) {
                            val steps = instruction[2].toInt()

                            if (instruction[1] == "LSHIFT") {
                                signals[target] = aval shl steps
                            } else {
                                signals[target] = aval shr steps
                            }

                            executed = true
                        } else if (signals.containsKey(instruction[2])) {
                            val bval = signals.getOrDefault(instruction[2], 0)

                            if (instruction[1] == "AND") {
                                signals[target] = aval and bval
                            } else {
                                signals[target] = aval or bval
                            }

                            executed = true
                        }
                    }
                }

                if (executed) {
                    executedInstructions.add(i)
                }
            }
        }

        return signals.getOrDefault("a", -1)
    }

    override fun partTwo(input: String): Int {
        return 1
    }
}
