package aockt.y2015

import io.github.jadarma.aockt.test.AdventDay
import io.github.jadarma.aockt.test.AdventSpec

@AdventDay(2015, 6, "Probably a Fire Hazard")
class Y2015D06Test : AdventSpec<Y2015D06>({

    partOne {
        "turn on 0,0 through 999,999" shouldOutput 1_000_000
        "turn on 0,0 through 999,0" shouldOutput 1_000
        "turn on 0,0 through 999,999\nturn off 499,499 through 500,500" shouldOutput 999_996
    }

    partTwo {
        "turn on 0,0 through 0,0" shouldOutput 1
        "toggle 0,0 through 999,999" shouldOutput 2_000_000
    }
})
