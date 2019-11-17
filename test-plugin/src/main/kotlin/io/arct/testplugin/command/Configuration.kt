package io.arct.testplugin.command

import io.arct.arctlib.exceptions.commands.InvalidArgumentsException
import io.arct.arctlib.extentions.color
import io.arct.arctlib.extentions.fetch
import io.arct.arctlib.extentions.inventory
import io.arct.arctlib.extentions.item
import io.arct.arctlib.extentions.location
import io.arct.arctlib.extentions.save
import io.arct.arctlib.plugin.Plugin
import io.arct.arctlib.plugin.command.ExecutableBy
import io.arct.arctlib.plugin.command.PluginCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@ExecutableBy.Player
class Configuration(plugin: Plugin) : PluginCommand("config", plugin) {
    override fun run(sender: CommandSender, player: Player?, command: Command, args: Array<out String>) {
        if (args.isEmpty())
            throw InvalidArgumentsException(this)

        player!!

        when (args[0].toLowerCase()) {
            "config" ->
                player.sendMessage(plugin.config.getString("test123")!!.color())

            "message" ->
                player.sendMessage(plugin.message("lolol"))

            "item" ->
                player.inventory.addItem(plugin.config.item("config.item")!!)

            "inventory" ->
                player.openInventory(plugin.config.inventory("config.inventory")!!)

            "location" ->
                player.teleport(plugin.config.location("config.location")!!)

            "save" -> {
                plugin.config.fetch()
                plugin.config.item("config.item", player.inventory.getItem(0))
                plugin.config.inventory("config.inventory", player.inventory)
                plugin.config.location("config.location", player.location)
                plugin.config.save()
            }
        }
    }
}
