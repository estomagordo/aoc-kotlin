package aockt.y2015

import io.github.jadarma.aockt.core.Solution

object Y2015D06 : Solution {

    override fun partOne(input: String): Int {
        val instructions = input.split('\n')
        val lights = mutableMapOf<Pair<Int, Int>, Boolean>()

        (0..999).forEach { y ->
            (0..999).forEach { x ->
                lights[Pair(y, x)] = false
            }
        }

        instructions.forEach {
            val numbers = Regex("-?[0-9]+")
                .findAll(it)
                .map(MatchResult::value)
                .map(String::toInt)
                .toList()

            val parts = it.split(' ')

            (numbers[0]..numbers[2]).forEach { y ->
                (numbers[1]..numbers[3]).forEach { x ->
                    val pair = Pair(y, x)
                    val currentValue = lights.getOrDefault(pair, false)
                    lights[pair] = (parts[1] == "on" || (parts[0] == "toggle" && !currentValue))
                }
            }
        }

        return lights.values.count { it }
    }

    override fun partTwo(input: String): Int {
        val instructions = input.split('\n')
        val lights = mutableMapOf<Pair<Int, Int>, Int>()

        (0..999).forEach { y ->
            (0..999).forEach { x ->
                lights[Pair(y, x)] = 0
            }
        }

        instructions.forEach {
            val numbers = Regex("-?[0-9]+")
                .findAll(it)
                .map(MatchResult::value)
                .map(String::toInt)
                .toList()

            val parts = it.split(' ')

            (numbers[0]..numbers[2]).forEach { y ->
                (numbers[1]..numbers[3]).forEach { x ->
                    val pair = Pair(y, x)
                    val currentValue = lights.getOrDefault(pair, 0)

                    val change = when {
                        parts[0] == "toggle" -> 2
                        parts[1] == "on" -> 1
                        else -> -1
                    }

                    lights[pair] = listOf(0, currentValue + change).max()
                }
            }
        }

        return lights.values.sum()
    }
}
