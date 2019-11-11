package io.arct.arctlib.extentions

import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

/**
 * Check if an [Entity] is a monster.
 *
 * @return Whether the [Entity] is a monster.
 */
val EntityType.isMonster: Boolean
    get() = listOf(
        EntityType.BLAZE,
        EntityType.CAVE_SPIDER,
        EntityType.CREEPER,
        EntityType.ELDER_GUARDIAN,
        EntityType.ENDER_DRAGON,
        EntityType.ENDERMAN,
        EntityType.ENDERMITE,
        EntityType.EVOKER,
        EntityType.GHAST,
        EntityType.GIANT,
        EntityType.GUARDIAN,
        EntityType.HUSK,
        EntityType.MAGMA_CUBE,
        EntityType.PHANTOM,
        EntityType.PIG_ZOMBIE,
        EntityType.SHULKER,
        EntityType.SILVERFISH,
        EntityType.SKELETON,
        EntityType.SLIME,
        EntityType.SPIDER,
        EntityType.STRAY,
        EntityType.VEX,
        EntityType.VINDICATOR,
        EntityType.WITCH,
        EntityType.WITHER,
        EntityType.WITHER_SKELETON,
        EntityType.ZOMBIE,
        EntityType.ZOMBIE_VILLAGER
    ).contains(this)
