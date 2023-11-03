package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D07 : Solution {

    private fun runInstructions(instructions: List<List<String>>, signals: MutableMap<String, Int>): MutableMap<String, Int> {
        val executedInstructions = mutableSetOf<Int>()

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
                            var bvalBinary = signals.getOrDefault(b, 0)
                                .toString(radix = 2)
                            val bval = signals.getOrDefault(b, 0)
                            bvalBinary = "0".repeat(16 - bvalBinary.length) + bvalBinary

                            val bvalInverse = bvalBinary
                                .replace('0', '2')
                                .replace('1', '0')
                                .replace('2', '1')
                                .toInt(radix = 2)
                            val btotes = bval + bvalInverse
                            signals[target] = bvalInverse and 65535

                            executed = true
                        }
                    } else if (signals.containsKey(a)) {
                        val aval = signals.getOrDefault(a, 0)

                        if (instruction.size == 3) {
                            signals[target] = aval
                            executed = true
                        } else if (instruction[2].all { it.isDigit() }) {
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

        return signals
    }

    override fun partOne(input: String): Int {
        val instructions = input.split('\n').map { it -> it.split(" ") }
        var signals = mutableMapOf<String, Int>()

        signals = runInstructions(instructions, signals)

        return signals.getOrDefault("a", -1)
    }

    override fun partTwo(input: String): Int {
        val instructions = input.split('\n').map { it -> it.split(" ") }
        var signals = mutableMapOf<String, Int>()

        signals = runInstructions(instructions, signals)
        signals = mutableMapOf("b" to signals.getOrDefault("a", -1))
        signals = runInstructions(instructions, signals)

        return signals.getOrDefault("a", -1)
    }
}
