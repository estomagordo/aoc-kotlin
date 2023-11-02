package aockt.y2015

import io.github.jadarma.aockt.test.AdventDay
import io.github.jadarma.aockt.test.AdventSpec

@AdventDay(2015, 5, "Doesn't He Have Intern-Elves For This?")
class Y2015D05Test : AdventSpec<Y2015D05>({

    partOne {
        "ugknbfddgicrmopn" shouldOutput 1
        "aaa" shouldOutput 1
        "jchzalrnumimnmhp" shouldOutput 0
        "haegwjzuvuyypxyu" shouldOutput 0
        "dvszwmarrgswjxmb" shouldOutput 0
    }

    partTwo {
        "qjhvhtzxzqqjkmpb" shouldOutput 1
        "xxyxx" shouldOutput 1
        "uurcxstgmygtbstg" shouldOutput 0
        "ieodomkazucvgmuy" shouldOutput 0
    }
})
