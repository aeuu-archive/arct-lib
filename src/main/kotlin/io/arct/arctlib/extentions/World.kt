package io.arct.arctlib.extentions

import org.bukkit.World
import org.bukkit.entity.Entity

/**
 * Get whether the world is currently day.
 *
 * @return Whether the time is currently day.
 */
val World.isDay: Boolean
    get() = this.time < 12300 || this.time > 23850

/**
 * Get a list of all of the entities in the world.
 *
 * @param T The type of [Entity] to get.
 *
 * @return A [List] of matching [Entity]s.
 */
inline fun <reified T : Entity> World.entities(): List<Entity> {
    return this.entities.filterIsInstance<T>()
}
