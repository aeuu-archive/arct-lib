package io.arct.arctlib.extentions

import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionType

/**
 * Create an [ItemStack].
 *
 * @param name The name of the [ItemStack].
 * @param lore The lore of the [ItemStack].
 * @param material The material of the [ItemStack].
 * @param count The amount of items in the [ItemStack].
 *
 * @return The created [ItemStack].
 */
fun ItemStack(name: String? = null, lore: String? = null, material: Material, count: Int = 1): ItemStack {
    val item = ItemStack(material, count)
    val meta = item.itemMeta!!

    if (name != null)
        meta.setDisplayName("&f$name".color())

    meta.addItemFlags(*ItemFlag.values())

    if (lore != null)
        meta.lore = lore.split("\n").map { "&8$it".color() }

    item.itemMeta = meta
    return item
}

/**
 * Create an [ItemStack] (potion).
 *
 * @param name The name of the [ItemStack].
 * @param lore The lore of the [ItemStack].
 * @param type The type of potion to create.
 * @param count The amount of items in the [ItemStack].
 *
 * @return The created [ItemStack].
 */
fun ItemStack(name: String? = null, lore: String? = null, type: PotionType, count: Int = 1, splash: Boolean = false): ItemStack {
    val item = ItemStack(name, lore, if (splash) Material.SPLASH_POTION else Material.POTION, count)
    val meta = item.itemMeta as PotionMeta

    meta.basePotionData = PotionData(type)

    item.itemMeta = meta
    return item
}
