package io.arct.testplugin.command

import io.arct.arctlib.exceptions.commands.InvalidArgumentsException
import io.arct.arctlib.extentions.ItemStack
import io.arct.arctlib.extentions.color
import io.arct.arctlib.plugin.Plugin
import io.arct.arctlib.plugin.command.ExecutableBy
import io.arct.arctlib.plugin.command.PluginCommand
import io.arct.arctlib.ui.GUI
import io.arct.arctlib.ui.defaults.ConfirmGUI
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent

@ExecutableBy.Player
class Gui(plugin: Plugin) : PluginCommand("ui", plugin) {
    override fun run(sender: CommandSender, player: Player?, command: Command, args: Array<out String>) {
        if (args.isEmpty())
            throw InvalidArgumentsException(this)

        (when (args[0].toLowerCase()) {
            "custom" ->
                custom()

            "confirm" ->
                ConfirmGUI("Confirm Action")
                    .onConfirm { e: InventoryClickEvent, _ ->
                        e.whoClicked.closeInventory()
                        e.whoClicked.sendMessage("&eSelected: &fConfirm".color())
                    }.onCancel { e: InventoryClickEvent, _ ->
                        e.whoClicked.closeInventory()
                        e.whoClicked.sendMessage("&eSelected: &fCancel".color())
                    }

            "tinyconfirm" ->
                ConfirmGUI.Tiny("Confirm Action")
                    .onConfirm { e: InventoryClickEvent, _ ->
                        e.whoClicked.closeInventory()
                        e.whoClicked.sendMessage("&eSelected: &fConfirm".color())
                    }.onCancel { e: InventoryClickEvent, _ ->
                        e.whoClicked.closeInventory()
                        e.whoClicked.sendMessage("&eSelected: &fCancel".color())
                    }

            else -> throw InvalidArgumentsException(this)
        }).show(player!!)
    }

    private fun custom(): GUI {
        return GUI("test", 3).mask(
            listOf(
                'a', 'g', 'a', 'g', 'a', 'g', 'a', 'g', 'a',
                'g', 'a', 'q', 'a', 'w', 'a', 'e', 'a', 'g',
                'a', 'g', 'a', 'g', 'a', 'g', 'a', 'g', 'a'
            ), mapOf(
                'a' to null,
                'g' to ItemStack("", null, Material.BLACK_STAINED_GLASS_PANE),
                'q' to ItemStack("1", "lore1", Material.GREEN_CONCRETE),
                'w' to ItemStack("2", "lore2", Material.YELLOW_DYE, 2),
                'e' to ItemStack("3", "lore3", Material.BARRIER, 3)
            )
        ).onClick('q') { e: InventoryClickEvent, type: ClickType ->
            e.whoClicked.closeInventory()
            e.whoClicked.sendMessage("&eSelected: &f1, &eAction: &f$type".color())
        }.onClick('w') { e: InventoryClickEvent, type: ClickType ->
            e.whoClicked.closeInventory()
            e.whoClicked.sendMessage("&eSelected: &f2, &eAction: &f$type".color())
        }.onClick('e') { e: InventoryClickEvent, type: ClickType ->
            e.whoClicked.closeInventory()
            e.whoClicked.sendMessage("&eSelected: &f3, &eAction: &f$type".color())
        }
    }
}
