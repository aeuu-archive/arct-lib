package io.arct.arctlib.extentions

import org.bukkit.ChatColor

/**
 * Get if two [String]s are similar (equal ignoring case).
 *
 * @param other The [String] to compare to.
 *
 * @return Whether the [String]s are similar.
 */
infix fun String.similar(other: String): Boolean {
    return this.toLowerCase() == other.toLowerCase()
}

/**
 * Returns the string with the Bukkit [ChatColor]s included.
 *
 * @param char The Color Code character.
 *
 * @return The string with [ChatColor]s embedded.
 */
fun String.color(char: Char = '&'): String {
    return ChatColor.translateAlternateColorCodes(char, this)
}
