package io.arct.arctlib.extentions

import org.bukkit.entity.Player

/**
 * Remove all potion effects from a player.
 */
fun Player.removePotionEffects() {
    for (effect in this.activePotionEffects)
        this.removePotionEffect(effect.type)
}
