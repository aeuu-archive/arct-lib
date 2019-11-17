package io.arct.arctlib.exceptions.commands

class NoPlayerException : CommandException() {
    override val node: String = "error.no-player"
    override val arguments: List<String> = emptyList()
}
