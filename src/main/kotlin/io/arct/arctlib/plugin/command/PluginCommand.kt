package io.arct.arctlib.plugin.command

import io.arct.arctlib.exceptions.PluginException
import io.arct.arctlib.exceptions.commands.NoConsoleException
import io.arct.arctlib.exceptions.commands.NoPlayerException
import io.arct.arctlib.plugin.Plugin
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import org.bukkit.Material
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
    val tab = Tab()

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
    final override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name.toLowerCase() != name)
            return false

        val player = if (sender is Player) sender else null

        if (player == null && this::class.findAnnotation<ExecutableBy.Console>() == null) {
            NoConsoleException().send(plugin, sender)
            return true
        }

        if (player != null && this::class.findAnnotation<ExecutableBy.Player>() == null) {
            NoPlayerException().send(plugin, sender)
            return true
        }

        try {
            run(sender, player, command, args.toList())
        } catch (e: PluginException) {
            e.send(plugin, sender)
        }

        return true
    }

    /**
     * Register the command with the plugin.
     *
     * @return This [PluginCommand].
     */
    fun register(): PluginCommand {
        plugin.getCommand(name)?.setExecutor(this)
        plugin.getCommand(name)?.setTabCompleter { sender, command, _, args -> arguments(sender, command, args.toList()).sorted() }

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
    abstract fun run(sender: CommandSender, player: Player?, command: Command, args: List<String>)

    open fun arguments(sender: CommandSender, command: Command, args: List<String>): List<String> =
        emptyList()

    inner class Tab {
        fun players(by: KFunction<String> = Player::getName): List<String> =
            plugin.server.onlinePlayers.toList().map { by.call(it) }

        fun players(by: KProperty1<Player, String>): List<String> =
            plugin.server.onlinePlayers.toList().map { by.call(it) }

        fun range(range: IntRange): List<String> =
            range.joinToString("").split("")

        fun material(filter: KFunction<Boolean>? = null): List<String> =
            Material.values().toList().map { it.name }.filter { filter?.call(it) ?: true }

        fun material(filter: KProperty1<Material, Boolean>): List<String> =
            Material.values().toList().map { it.name }.filter { filter.call(it) }
    }
}
