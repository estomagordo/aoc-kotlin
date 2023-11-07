package aockt.y2015

import io.github.jadarma.aockt.test.AdventDay
import io.github.jadarma.aockt.test.AdventSpec

@AdventDay(2015, 8, "Matchsticks")
class Y2015D08Test : AdventSpec<Y2015D08>({

    partOne {
        "\"\"" shouldOutput 2
        "\"abc\"" shouldOutput 2
        "\"aaa\"aaa\"" shouldOutput 3
        "\"\\x27\"" shouldOutput 5
    }

    partTwo {
        "\"\"" shouldOutput 4
        "\"abc\"" shouldOutput 4
        "\"aaa\"aaa\"" shouldOutput 6
        "\"\\x27\"" shouldOutput 5
    }
})
