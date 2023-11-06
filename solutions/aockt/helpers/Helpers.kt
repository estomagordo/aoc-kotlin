package aockt.helpers

fun String.ints(): List<Int> {
    return Regex("-?[0-9]+")
        .findAll(this)
        .map(MatchResult::value)
        .map(String::toInt)
        .toList()
}

fun String.lines(): List<String> {
    return this.split('\n')
}
