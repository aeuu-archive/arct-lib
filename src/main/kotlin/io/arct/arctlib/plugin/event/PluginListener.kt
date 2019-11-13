package io.arct.arctlib.plugin.event

import io.arct.arctlib.plugin.Plugin
import org.bukkit.event.Listener

abstract class PluginListener : Listener {
    private var registered: Boolean = false

    /**
     * Register this listener to a plugin.
     *
     * @param plugin The plugin to register the Listener to.
     */
    fun register(plugin: Plugin): PluginListener {
        if (registered)
            return this

        plugin.server.pluginManager.registerEvents(this, plugin)
        registered = true

        return this
    }
}
