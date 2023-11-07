package aockt.y2015

import aockt.helpers.lines
import io.github.jadarma.aockt.core.Solution
import kotlin.math.max
import kotlin.math.min

object Y2015D09 : Solution {

    private fun makeGraph(s: String): Map<Pair<String, String>, Int> {
        val graph = mutableMapOf<Pair<String, String>, Int>()

        s.lines().map { line -> line.split(" ") }.forEach { parts ->
            val a = parts[0]
            val b = parts[2]
            val distance = parts[4].toInt()

            graph[Pair(a, b)] = distance
            graph[Pair(b, a)] = distance
        }

        return graph
    }

    private fun calcDistance(graph: Map<Pair<String, String>, Int>, itinerary: List<String>): Int {
        var distance = 0
        var previous = itinerary.first()

        itinerary.slice(1..<itinerary.size).forEach {
            distance += graph.getOrDefault(Pair(previous, it), 0)
            previous = it
        }

        return distance
    }

    override fun partOne(input: String): Int {
        val graph = makeGraph(input)
        val allCities = mutableSetOf<String>()
        var shortest = 1_000_000

        graph.keys.forEach { pair ->
            allCities.add(pair.first)
            allCities.add(pair.second)
        }

        fun dfs(visited: List<String>) {
            if (visited.size == allCities.size) {
                shortest = min(shortest, calcDistance(graph, visited))
            } else {
                allCities.forEach {
                    if (!visited.contains(it)) {
                        dfs(visited + listOf(it))
                    }
                }
            }
        }

        dfs(emptyList())

        return shortest
    }

    override fun partTwo(input: String): Int {
        val graph = makeGraph(input)
        val allCities = mutableSetOf<String>()
        var longest = 0

        graph.keys.forEach { pair ->
            allCities.add(pair.first)
            allCities.add(pair.second)
        }

        fun dfs(visited: List<String>) {
            if (visited.size == allCities.size) {
                longest = max(longest, calcDistance(graph, visited))
            } else {
                allCities.forEach {
                    if (!visited.contains(it)) {
                        dfs(visited + listOf(it))
                    }
                }
            }
        }

        dfs(emptyList())

        return longest
    }
}
