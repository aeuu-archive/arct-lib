package io.arct.arctlib.configuration

import io.arct.arctlib.extentions.save
import io.arct.arctlib.plugin.Plugin
import java.io.File
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration

object Configurations {
    /**
     * Get a [YamlConfiguration] from a path.
     *
     * @param path The path of the yaml file.
     * @param plugin The plugin that owns the yaml file.
     *
     * @return The [YamlConfiguration].
     */
    fun yaml(path: String, plugin: Plugin): YamlConfiguration {
        val file = File("${plugin.dataFolder.path}${File.separator}${path.replace("/", File.separator, true)}")

        if (!file.exists()) {
            file.parentFile.mkdirs()
            plugin.saveResource(path, false)
        }

        val config = YamlConfiguration.loadConfiguration(file)

        configurationFileMap[config] = file

        config.options().copyDefaults(true)
        config.save()

        return config
    }

    internal val configurationFileMap: MutableMap<FileConfiguration, File> = HashMap()
}
