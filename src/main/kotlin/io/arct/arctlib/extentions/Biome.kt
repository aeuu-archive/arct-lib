package io.arct.arctlib.extentions

import org.bukkit.block.Biome

/**
 * Check if a [Biome]'s type is birch.
 *
 * @return Whether the [Biome]'s type is birch.
 */
val Biome.isBirch: Boolean
    get() = listOf(
        Biome.BIRCH_FOREST,
        Biome.BIRCH_FOREST_HILLS,
        Biome.TALL_BIRCH_FOREST,
        Biome.TALL_BIRCH_HILLS
    ).contains(this)

/**
 * Check if a [Biome]'s type is forest.
 *
 * @return Whether the [Biome]'s type is forest.
 */
val Biome.isForest: Boolean
    get() = listOf(
        Biome.FOREST,
        Biome.BIRCH_FOREST,
        Biome.BIRCH_FOREST_HILLS,
        Biome.DARK_FOREST,
        Biome.DARK_FOREST_HILLS,
        Biome.FLOWER_FOREST,
        Biome.TALL_BIRCH_FOREST
    ).contains(this)

/**
 * Check if a [Biome]'s type is ocean.
 *
 * @return Whether the [Biome]'s type is ocean.
 */
val Biome.isOcean: Boolean
    get() = listOf(
        Biome.OCEAN,
        Biome.COLD_OCEAN,
        Biome.DEEP_COLD_OCEAN,
        Biome.DEEP_FROZEN_OCEAN,
        Biome.DEEP_LUKEWARM_OCEAN,
        Biome.DEEP_OCEAN,
        Biome.DEEP_WARM_OCEAN,
        Biome.FROZEN_OCEAN,
        Biome.LUKEWARM_OCEAN,
        Biome.WARM_OCEAN
    ).contains(this)

/**
 * Check if a [Biome]'s type is snowy.
 *
 * @return Whether the [Biome]'s type is snowy.
 */
val Biome.isSnowy: Boolean
    get() = listOf(
        Biome.SNOWY_BEACH,
        Biome.SNOWY_MOUNTAINS,
        Biome.SNOWY_TAIGA,
        Biome.SNOWY_TAIGA_HILLS,
        Biome.SNOWY_TAIGA_MOUNTAINS,
        Biome.SNOWY_TUNDRA
    ).contains(this)
