package io.arct.arctlib.exceptions

import io.arct.arctlib.plugin.Plugin
import org.bukkit.command.CommandSender

abstract class PluginException : Exception() {
    abstract val node: String
    abstract val arguments: List<String>

    fun send(plugin: Plugin, sender: CommandSender) =
        sender.sendMessage(plugin except this)
}
