package io.arct.arctlib.extentions

import org.bukkit.Chunk
import org.bukkit.entity.Entity

/**
 * Get a list of all of the entities in the chunk.
 *
 * @param T The type of [Entity] to get.
 *
 * @return A [List] of matching [Entity]s.
 */
inline fun <reified T : Entity> Chunk.entities(): List<Entity> {
    return this.entities.filterIsInstance<T>()
}
