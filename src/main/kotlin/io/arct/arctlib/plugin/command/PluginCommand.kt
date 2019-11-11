package io.arct.arctlib.plugin.command

import io.arct.arctlib.plugin.Plugin
import kotlin.reflect.full.findAnnotation
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * An in-game executable command.
 *
 * @param plugin The plugin that owns this command.
 */
abstract class PluginCommand(protected val plugin: Plugin) : CommandExecutor {
    var name: String = this::class.simpleName?.toLowerCase() ?: ""

    /**
     * Create a command instance using a name.
     *
     * @param name The name of the command.
     * @param plugin The plugin that owns this command.
     */
    constructor (name: String, plugin: Plugin) : this(plugin) {
        this.name = name
    }

    /**
     * @suppress
     */
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name.toLowerCase() != name)
            return false

        val player = if (sender is Player) sender else null

        if (player == null && this::class.findAnnotation<ExecutableBy.Console>() == null) {
            sender.sendMessage(plugin.message("error.no-console"))
            return true
        }

        if (player != null && this::class.findAnnotation<ExecutableBy.Player>() == null) {
            sender.sendMessage(plugin.message("error.no-player"))
            return true
        }

        run(sender, player, command, args)
        return true
    }

    /**
     * Register the command with the plugin.
     *
     * @return This [PluginCommand].
     */
    fun register(): PluginCommand {
        plugin.getCommand(name)?.setExecutor(this)

        return this
    }

    /**
     * Code to be run when the [PluginCommand] is executed in game.
     *
     * @param sender The [CommandSender] of the [PluginCommand].
     * @param player The [Player] who executed the command (or null).
     * @param command The [Command] instance.
     * @param args The parameters given from the command.
     */
    abstract fun run(sender: CommandSender, player: Player?, command: Command, args: Array<out String>)
}
