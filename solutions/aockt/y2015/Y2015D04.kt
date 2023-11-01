package aockt.y2015

import io.github.jadarma.aockt.core.Solution
import java.security.MessageDigest

object Y2015D04 : Solution {

    private fun withLeadingZeroes(s: String, n: Int): Int {
        val md = MessageDigest.getInstance("MD5")
        var num = 1
        val target = "0".repeat(n)

        while (true) {
            val key = s + num

            val bytes = md.digest(key.toByteArray())
            val digest = bytes.joinToString("") { "%02x".format(it) }

            if (digest.slice(0..<n) == target) {
                break
            }

            num++
        }

        return num
    }

    override fun partOne(input: String): Int {
        return withLeadingZeroes(input, 5)
    }

    override fun partTwo(input: String): Int {
        return withLeadingZeroes(input, 6)
    }
}
