package io.arct.arctlib.exceptions.permissions

import org.bukkit.entity.Player

class TargetExemptException(player: Player) : PermissionException() {
    override val node: String = "error.target-exempt"
    override val arguments: List<String> = listOf(player.displayName)
}
