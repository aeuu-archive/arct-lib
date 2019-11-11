package io.arct.testplugin.command

import io.arct.arctlib.plugin.Plugin
import io.arct.arctlib.plugin.command.ExecutableBy
import io.arct.arctlib.plugin.command.PluginCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@ExecutableBy.Player
@ExecutableBy.Console
class Simple(plugin: Plugin) : PluginCommand("simple", plugin) {
    override fun run(sender: CommandSender, player: Player?, command: Command, args: Array<out String>) {
        sender.sendMessage("Hello, World!")
    }
}
