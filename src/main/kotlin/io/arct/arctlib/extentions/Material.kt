package io.arct.arctlib.extentions

import org.bukkit.Material

/**
 * Check if a [Material] is an axe.
 *
 * @return Whether the [Material] is an axe.
 */
fun Material.isAxe(): Boolean {
    return listOf(
        Material.WOODEN_AXE,
        Material.STONE_AXE,
        Material.IRON_AXE,
        Material.GOLDEN_AXE,
        Material.DIAMOND_AXE
    ).contains(this)
}

/**
 * Check if a [Material] is a pickaxe.
 *
 * @return Whether the [Material] is a pickaxe.
 */
fun Material.isPickaxe(): Boolean {
    return listOf(
        Material.WOODEN_PICKAXE,
        Material.STONE_PICKAXE,
        Material.IRON_PICKAXE,
        Material.GOLDEN_PICKAXE,
        Material.DIAMOND_PICKAXE
    ).contains(this)
}

/**
 * Check if a [Material] is a shovel.
 *
 * @return Whether the [Material] is a shovel.
 */
fun Material.isShovel(): Boolean {
    return listOf(
        Material.WOODEN_SHOVEL,
        Material.STONE_SHOVEL,
        Material.IRON_SHOVEL,
        Material.GOLDEN_SHOVEL,
        Material.DIAMOND_SHOVEL
    ).contains(this)
}

/**
 * Check if a [Material] is a hoe.
 *
 * @return Whether the [Material] is a hoe.
 */
fun Material.isHoe(): Boolean {
    return listOf(
        Material.WOODEN_HOE,
        Material.STONE_HOE,
        Material.IRON_HOE,
        Material.GOLDEN_HOE,
        Material.DIAMOND_HOE
    ).contains(this)
}

/**
 * Check if a [Material] is a sword.
 *
 * @return Whether the [Material] is a sword.
 */
fun Material.isSword(): Boolean {
    return listOf(
        Material.WOODEN_SWORD,
        Material.STONE_SWORD,
        Material.IRON_SWORD,
        Material.GOLDEN_SWORD,
        Material.DIAMOND_SWORD
    ).contains(this)
}

/**
 * Check if a [Material] is a tool.
 *
 * @return Whether the [Material] is a tool.
 */
fun Material.isTool(): Boolean {
    return isPickaxe() || isAxe() || isShovel() || isHoe()
}

/**
 * Check if a [Material] is a weapon.
 *
 * @return Whether the [Material] is a weapon.
 */
fun Material.isWeapon(): Boolean {
    return this == Material.BOW || isSword()
}

/**
 * Check if a [Material] is a log.
 *
 * @param stripped Whether to include stripped logs or not.
 *
 * @return Whether the [Material] is a log.
 */
fun Material.isLog(stripped: Boolean = false): Boolean {
    val logs = listOf(
        Material.ACACIA_LOG,
        Material.BIRCH_LOG,
        Material.DARK_OAK_LOG,
        Material.JUNGLE_LOG,
        Material.SPRUCE_LOG
    )

    val strippedLogs = listOf(
        Material.STRIPPED_ACACIA_LOG,
        Material.STRIPPED_BIRCH_LOG,
        Material.STRIPPED_DARK_OAK_LOG,
        Material.STRIPPED_JUNGLE_LOG,
        Material.STRIPPED_SPRUCE_LOG
    )

    if (stripped && strippedLogs.contains(this))
        return true

    return logs.contains(this)
}

/**
 * Check if a [Material] is a leaves block.
 *
 * @return Whether the [Material] is a leaves block.
 */
fun Material.isLeaves(): Boolean {
    return listOf(
        Material.ACACIA_LEAVES,
        Material.BIRCH_LEAVES,
        Material.DARK_OAK_LEAVES,
        Material.JUNGLE_LEAVES,
        Material.OAK_LEAVES,
        Material.SPRUCE_LEAVES
    ).contains(this)
}

/**
 * Check if a [Material] is farmable.
 *
 * @return Whether the [Material] is a farmable.
 */
fun Material.isFarmable(): Boolean {
    return listOf(
        Material.WHEAT,
        Material.POTATOES,
        Material.BEETROOTS,
        Material.NETHER_WART,
        Material.CARROTS
    ).contains(this)
}

/**
 * Check if a [Material] is an ore block.
 *
 * @return Whether the [Material] is an ore block.
 */
fun Material.isOre(): Boolean {
    return listOf(
        Material.COAL_ORE,
        Material.DIAMOND_ORE,
        Material.EMERALD_ORE,
        Material.GOLD_ORE,
        Material.IRON_ORE,
        Material.LAPIS_ORE,
        Material.REDSTONE_ORE
    ).contains(this)
}

/**
 * Check if a [Material] is a soft block.
 *
 * @return Whether the [Material] is a soft block.
 */
fun Material.isSoft(): Boolean {
    return listOf(
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
}

/**
 * Check if a [Material] is a chest.
 *
 * @return Whether the [Material] is a chest.
 */
fun Material.isChest(): Boolean {
    return listOf(
        Material.CHEST,
        Material.CHEST_MINECART,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST
    ).contains(this)
}

/**
 * Check if a [Material] is a container.
 *
 * @return Whether the [Material] is a container.
 */
fun Material.isContainer(): Boolean {
    return listOf(
        Material.CHEST,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST,
        Material.FURNACE,
        Material.BREWING_STAND,
        Material.DISPENSER,
        Material.DROPPER,
        Material.HOPPER
    ).contains(this)
}

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
