package io.arct.arctlib.extentions

import org.bukkit.Material

/**
 * Check if a [Material] is an axe.
 *
 * @return Whether the [Material] is an axe.
 */
val Material.isAxe: Boolean
    get() = listOf(
        Material.WOODEN_AXE,
        Material.STONE_AXE,
        Material.IRON_AXE,
        Material.GOLDEN_AXE,
        Material.DIAMOND_AXE
    ).contains(this)

/**
 * Check if a [Material] is a pickaxe.
 *
 * @return Whether the [Material] is a pickaxe.
 */
val Material.isPickaxe: Boolean
    get() = listOf(
        Material.WOODEN_PICKAXE,
        Material.STONE_PICKAXE,
        Material.IRON_PICKAXE,
        Material.GOLDEN_PICKAXE,
        Material.DIAMOND_PICKAXE
    ).contains(this)

/**
 * Check if a [Material] is a shovel.
 *
 * @return Whether the [Material] is a shovel.
 */
val Material.isShovel: Boolean
    get() = listOf(
        Material.WOODEN_SHOVEL,
        Material.STONE_SHOVEL,
        Material.IRON_SHOVEL,
        Material.GOLDEN_SHOVEL,
        Material.DIAMOND_SHOVEL
    ).contains(this)

/**
 * Check if a [Material] is a hoe.
 *
 * @return Whether the [Material] is a hoe.
 */
val Material.isHoe: Boolean
    get() = listOf(
        Material.WOODEN_HOE,
        Material.STONE_HOE,
        Material.IRON_HOE,
        Material.GOLDEN_HOE,
        Material.DIAMOND_HOE
    ).contains(this)

/**
 * Check if a [Material] is a sword.
 *
 * @return Whether the [Material] is a sword.
 */
val Material.isSword: Boolean
    get() = listOf(
        Material.WOODEN_SWORD,
        Material.STONE_SWORD,
        Material.IRON_SWORD,
        Material.GOLDEN_SWORD,
        Material.DIAMOND_SWORD
    ).contains(this)

/**
 * Check if a [Material] is a tool.
 *
 * @return Whether the [Material] is a tool.
 */
val Material.isTool: Boolean
    get() = isPickaxe || isAxe || isShovel || isHoe

/**
 * Check if a [Material] is a weapon.
 *
 * @return Whether the [Material] is a weapon.
 */
val Material.isWeapon: Boolean
    get() = this == Material.BOW || isSword

/**
 * Check if a [Material] is a log.
 *
 * @param stripped Whether to include stripped logs or not.
 *
 * @return Whether the [Material] is a log.
 */
val Material.isLog: Boolean
    get() = listOf(
        Material.ACACIA_LOG,
        Material.BIRCH_LOG,
        Material.DARK_OAK_LOG,
        Material.JUNGLE_LOG,
        Material.SPRUCE_LOG,
        Material.STRIPPED_ACACIA_LOG,
        Material.STRIPPED_BIRCH_LOG,
        Material.STRIPPED_DARK_OAK_LOG,
        Material.STRIPPED_JUNGLE_LOG,
        Material.STRIPPED_SPRUCE_LOG
    ).contains(this)

/**
 * Check if a [Material] is a leaves block.
 *
 * @return Whether the [Material] is a leaves block.
 */
val Material.isLeaves: Boolean
    get() = listOf(
        Material.ACACIA_LEAVES,
        Material.BIRCH_LEAVES,
        Material.DARK_OAK_LEAVES,
        Material.JUNGLE_LEAVES,
        Material.OAK_LEAVES,
        Material.SPRUCE_LEAVES
    ).contains(this)

/**
 * Check if a [Material] is farmable.
 *
 * @return Whether the [Material] is a farmable.
 */
val Material.isFarmable: Boolean
    get() = listOf(
        Material.WHEAT,
        Material.POTATOES,
        Material.BEETROOTS,
        Material.NETHER_WART,
        Material.CARROTS
    ).contains(this)

/**
 * Check if a [Material] is an ore block.
 *
 * @return Whether the [Material] is an ore block.
 */
val Material.isOre: Boolean
    get() = listOf(
        Material.COAL_ORE,
        Material.DIAMOND_ORE,
        Material.EMERALD_ORE,
        Material.GOLD_ORE,
        Material.IRON_ORE,
        Material.LAPIS_ORE,
        Material.REDSTONE_ORE
    ).contains(this)

/**
 * Check if a [Material] is a soft block.
 *
 * @return Whether the [Material] is a soft block.
 */
val Material.isSoft: Boolean
    get() = listOf(
        Material.SAND,
        Material.GRAVEL,
        Material.DIRT,
        Material.COARSE_DIRT,
        Material.SOUL_SAND,
        Material.RED_SAND,
        Material.GRASS_BLOCK,
        Material.GRASS_PATH,
        Material.PODZOL,
        Material.FARMLAND,
        Material.CLAY
    ).contains(this)

/**
 * Check if a [Material] is a chest.
 *
 * @return Whether the [Material] is a chest.
 */
val Material.isChest: Boolean
    get() = listOf(
        Material.CHEST,
        Material.CHEST_MINECART,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST
    ).contains(this)

/**
 * Check if a [Material] is a container.
 *
 * @return Whether the [Material] is a container.
 */
val Material.isContainer: Boolean
    get() = listOf(
        Material.CHEST,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST,
        Material.FURNACE,
        Material.BREWING_STAND,
        Material.DISPENSER,
        Material.DROPPER,
        Material.HOPPER
    ).contains(this)

/**
 * Check if a [Material] is a station.
 *
 * @return Whether the [Material] is a station.
 */
val Material.isStation: Boolean
    get() = listOf(
        Material.CRAFTING_TABLE,
        Material.FURNACE,
        Material.ENCHANTING_TABLE,
        Material.BREWING_STAND,
        Material.CAULDRON,
        Material.CHEST,
        Material.DISPENSER,
        Material.DROPPER,
        Material.JUKEBOX,
        Material.ENDER_CHEST,
        Material.COMMAND_BLOCK,
        Material.TRAPPED_CHEST,
        Material.HOPPER
    ).contains(this)

/**
 * Check if a [Material] is liquid.
 *
 * @return Whether the [Material] is a liquid.
 */
val Material.isLiquid: Boolean
    get() = listOf(
        Material.WATER,
        Material.LAVA
    ).contains(this)

/**
 * Check if a [Material] is a plant.
 *
 * @return Whether the [Material] is a plant.
 */
val Material.isPlant: Boolean
    get() = listOf(
        Material.GRASS,
        Material.TALL_GRASS,
        Material.SUNFLOWER,
        Material.FERN,
        Material.LARGE_FERN,
        Material.SEAGRASS,
        Material.DANDELION,
        Material.POPPY,
        Material.BLUE_ORCHID,
        Material.ALLIUM,
        Material.AZURE_BLUET,
        Material.RED_TULIP,
        Material.ORANGE_TULIP,
        Material.WHITE_TULIP,
        Material.PINK_TULIP,
        Material.OXEYE_DAISY,
        Material.ROSE_BUSH,
        Material.PEONY
    ).contains(this)
