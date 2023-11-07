package aockt.y2015

import io.github.jadarma.aockt.test.AdventDay
import io.github.jadarma.aockt.test.AdventSpec

@AdventDay(2015, 9, "All in a single night")
class Y2015D09Test : AdventSpec<Y2015D09>({

    partOne {
        """London to Dublin = 464
London to Belfast = 518
Dublin to Belfast = 141""" shouldOutput 605
    }

    partTwo {
        """London to Dublin = 464
London to Belfast = 518
Dublin to Belfast = 141""" shouldOutput 982
    }
})
