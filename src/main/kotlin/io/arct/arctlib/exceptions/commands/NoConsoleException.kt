package io.arct.arctlib.exceptions.commands

class NoConsoleException : CommandException() {
    override val node: String = "error.no-console"
    override val arguments: List<String> = emptyList()
}
