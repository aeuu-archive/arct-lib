package io.arct.arctlib.extentions

import org.bukkit.Server
import org.bukkit.entity.Player

fun Server.getPlayers(interactor: Player): List<Player> {
    return this.onlinePlayers.toList().filter {
        interactor.canSee(it)
    }
}
