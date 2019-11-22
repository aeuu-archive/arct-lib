package io.arct.arctlib.exceptions.players

import org.bukkit.entity.Player

class InvalidPlayerException(name: String) : PlayerException() {
    constructor(player: Player) : this(player.displayName)

    override val node: String = "error.invalid-player"
    override val arguments: List<String> = listOf(name)
}
