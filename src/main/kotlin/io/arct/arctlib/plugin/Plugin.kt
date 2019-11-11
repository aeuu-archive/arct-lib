package io.arct.arctlib.plugin

import io.arct.arctlib.configuration.Configurations
import io.arct.arctlib.extentions.color
import io.arct.arctlib.extentions.save
import io.arct.arctlib.plugin.command.PluginCommand
import io.arct.arctlib.ui.GUI
import org.bukkit.configuration.Configuration
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

/**
 * A spigot plugin.
 */
abstract class Plugin : JavaPlugin() {
    /**
     * The standard [FileConfiguration] file for the plugin (Alias for configurations["config"]).
     */
    @get:JvmName("mainConfig")
    var config: FileConfiguration
        get() = configurations["config"]!!
        set(v) { configurations["config"] = v }

    /**
     * The message [FileConfiguration] file for the plugin (Alias for configurations["messages"]).
     */
    var messages: FileConfiguration
        get() = configurations["messages"]!!
        set(v) { configurations["messages"] = v }

    /**
     * A [HashMap] of the [Plugin]'s [Configuration] files.
     */
    var configurations: MutableMap<String, FileConfiguration> = mutableMapOf(
        "config" to Configurations.yaml("config.yml", this),
        "messages" to Configurations.yaml("messages.yml", this)
    )

    inline fun <reified T : Event> on(crossinline handle: (T) -> Unit, priority: EventPriority = EventPriority.NORMAL, force: Boolean = false) =
        server.pluginManager.registerEvent(T::class.java, object : Listener {}, priority, { _, it -> if (it is T) handle(it) }, this, force)

    /**
     * @suppress
     */
    override fun onEnable() {
        if (!dataFolder.exists())
            dataFolder.mkdirs()

        config()
        commands()
        events()
        enable()
    }

    /**
     * @suppress
     */
    override fun onDisable() {
        disable()
    }

    /**
     * A method to get a message from the [Plugin]'s message [YamlConfiguration] file.
     * This is meant to be modified by subclasses.
     *
     * @param code The ID of the message to get.
     *
     * @return The message.
     */
    open fun message(code: String): String {
        return messages.getString(code)?.color() ?: ""
    }

    fun reload() {
        disable()
        enable()
    }

    /**
     * This is meant to be modified by subclasses to configure [YamlConfiguration] files.
     */
    protected open fun config() {}

    /**
     * This is meant to be modified by subclasses to configure [PluginCommand]s.
     */
    protected open fun commands() {}

    /**
     * This is meant to be modified by subclasses to configure [Listener]s.
     */
    protected open fun events() {
        GUI.Listener.register(this)
    }

    /**
     * This is meant to be modified by subclasses when the [Plugin] is enabled.
     */
    protected open fun enable() {}

    /**
     * This is meant to be modified by subclasses when the [Plugin] is disabled.
     */
    protected open fun disable() {
        for (player in server.onlinePlayers)
            player.closeInventory()

        for (config in configurations)
            config.value.save()
    }
}
