package io.arct.arctlib.exceptions.commands

import io.arct.arctlib.plugin.command.PluginCommand

class InvalidArgumentsException(command: PluginCommand) : CommandException() {
    override val node: String = "error.invalid-arguments"
    override val arguments: List<String> = listOf(command.name)
}
