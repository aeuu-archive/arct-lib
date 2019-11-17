package io.arct.arctlib.exceptions.players

class NoYourselfException : PlayerException() {
    override val node: String = "error.no-yourself"
    override val arguments: List<String> = emptyList()
}
