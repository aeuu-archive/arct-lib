package io.arct.arctlib.extentions

import io.arct.arctlib.configuration.Configurations
import java.io.File
import org.bukkit.configuration.file.FileConfiguration

/**
 * The [File] that the [FileConfiguration] is registered under.
 * Only works for [FileConfiguration] created using [Configurations].
 */
val FileConfiguration.file: File?
    get() = Configurations.configurationFileMap[this]

/**
 * Save and reload the [FileConfiguration].
 * Only works for [FileConfiguration] created using [Configurations].
 */
fun FileConfiguration.reload() {
    save()
    load(file ?: return)
}

/**
 * Reload the [FileConfiguration].
 * Only works for [FileConfiguration] created using [Configurations].
 */
fun FileConfiguration.fetch() {
    load(file ?: return)
}

/**
 * Save the [FileConfiguration] to disk.
 * Only works for [FileConfiguration] created using [Configurations].
 */
fun FileConfiguration.save() {
    save(file ?: return)
}
