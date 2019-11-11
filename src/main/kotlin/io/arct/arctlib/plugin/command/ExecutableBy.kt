package io.arct.arctlib.plugin.command

/**
 * A singleton housing annotations for execution.
 */
object ExecutableBy {
    /**
     * Represents the ability for a command to be run by a player.
     *
     * @see PluginCommand
     */
    annotation class Player

    /**
     * Represents the ability for a command to be run by the console.
     *
     * @see PluginCommand
     */
    annotation class Console
}
