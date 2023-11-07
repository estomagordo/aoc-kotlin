package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D07 : Solution {

    private fun runInstructions(
        instructions: List<List<String>>,
        signals: MutableMap<String, Int>,
    ): MutableMap<String, Int> {
        fun evaluate(value: String): Int? {
            if (value.all { it.isDigit() }) {
                return value.toInt()
            }

            if (signals.containsKey(value)) {
                return signals[value]
            }

            return null
        }

        while (!signals.containsKey("a")) {
            instructions.forEach { instruction ->

                val a = instruction.first()
                val target = instruction.last()

                if (!signals.containsKey(target)) {
                    when (instruction.size) {
                        3 -> {
                            val evaluation = evaluate(a)

                            if (evaluation != null) {
                                signals[target] = evaluation
                            }
                        }

                        4 -> {
                            val evaluation = evaluate(instruction[1])

                            if (evaluation != null) {
                                signals[target] = 65535 - evaluation
                            }
                        }

                        else -> {
                            val aVal = evaluate(a)
                            val command = instruction[1]
                            val bVal = evaluate(instruction[2])

                            if (aVal != null && bVal != null) {
                                signals[target] = when (command) {
                                    "RSHIFT" -> aVal shr bVal
                                    "LSHIFT" -> aVal shl bVal
                                    "AND" -> aVal and bVal
                                    else -> aVal or bVal
                                }
                            }
                        }
                    }
                }
            }
        }

        return signals
    }

    override fun partOne(input: String): Int {
        val instructions = input.lines().map { it -> it.split(" ") }
        var signals = mutableMapOf<String, Int>()

        signals = runInstructions(instructions, signals)

        return signals.getOrDefault("a", -1)
    }

    override fun partTwo(input: String): Int {
        val instructions = input.lines().map { it -> it.split(" ") }
        var signals = mutableMapOf<String, Int>()

        signals = runInstructions(instructions, signals)
        signals = mutableMapOf("b" to signals.getOrDefault("a", -1))
        signals = runInstructions(instructions, signals)

        return signals.getOrDefault("a", -1)
    }
}
