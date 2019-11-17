package io.arct.arctlib.exceptions.players

import org.bukkit.entity.Player

class InvalidPlayerException(player: Player) : PlayerException() {
    override val node: String = "error.invalid-player"
    override val arguments: List<String> = listOf(player.displayName)
}
