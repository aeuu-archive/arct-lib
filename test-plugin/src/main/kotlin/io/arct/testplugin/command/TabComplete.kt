package io.arct.testplugin.command

import io.arct.arctlib.extentions.matching
import io.arct.arctlib.plugin.Plugin
import io.arct.arctlib.plugin.command.ExecutableBy
import io.arct.arctlib.plugin.command.PluginCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@ExecutableBy.Player
class TabComplete(plugin: Plugin) : PluginCommand(plugin) {
    override fun run(sender: CommandSender, player: Player?, command: Command, args: Array<out String>) {
        player!!.sendMessage(args.toString())
    }

    override fun arguments(sender: CommandSender, command: Command, args: Array<out String>): List<String> =
        when (args.size) {
            1 -> args[0] matching listOf("minecraft", "letsplay", "server", "aaaaa")
            2 -> args[1] matching (1..10).joinToString("").split("")

            else -> listOf()
        }
}
