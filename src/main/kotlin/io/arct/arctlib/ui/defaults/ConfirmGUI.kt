package io.arct.arctlib.ui.defaults

import io.arct.arctlib.extentions.ItemStack
import io.arct.arctlib.ui.GUI
import org.bukkit.Material
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * A default premade GUI to get confirmation.
 *
 * @param name The name of the action to confirm.
 */
class ConfirmGUI(name: String) : GUI("Confirm", 3) {
    init {
        mask(
            listOf(
                'y', 'y', 'y', ' ', ' ', ' ', 'n', 'n', 'n',
                'y', 'y', 'y', ' ', 'p', ' ', 'n', 'n', 'n',
                'y', 'y', 'y', ' ', ' ', ' ', 'n', 'n', 'n'
            ), mapOf(
                Pair('p', ItemStack("&eAre You Sure?", name, Material.PAPER)),
                Pair(' ', ItemStack("", null, Material.BLACK_STAINED_GLASS_PANE)),
                Pair('y', ItemStack("&aConfirm", "Performing this action\nmay be irreversible!", Material.LIME_STAINED_GLASS_PANE)),
                Pair('n', ItemStack("&cCancel", "No changes will be made.", Material.RED_STAINED_GLASS_PANE))
            )
        )
    }

    /**
     * Set an action to run when this [GUI] is confirmed.
     *
     * @param action The action to run when this [GUI] is confirmed.
     *
     * @return This [GUI].
     */
    fun onConfirm(action: ((InventoryClickEvent, ClickType) -> Unit)): ConfirmGUI {
        onClick('y', action)

        return this
    }

    /**
     * Set an action to run when this [GUI] is cancelled.
     *
     * @param action The action to run when this [GUI] is cancelled.
     *
     * @return This [GUI].
     */
    fun onCancel(action: ((InventoryClickEvent, ClickType) -> Unit)): ConfirmGUI {
        onClick('n', action)

        return this
    }

    /**
     * Like [ConfirmGUI] but with only one row instead of three.
     *
     * @param name The name of the action to confirm.
     *
     * @see ConfirmGUI
     */
    class Tiny(name: String) : GUI("Confirm", 1) {
        init {
            mask(
                listOf(
                    'y', 'y', 'y', ' ', 'p', ' ', 'n', 'n', 'n'
                ), mapOf(
                    Pair('p', ItemStack("&eAre You Sure?", name, Material.PAPER)),
                    Pair(' ', ItemStack("", null, Material.BLACK_STAINED_GLASS_PANE)),
                    Pair('y', ItemStack("&aConfirm", "Performing this action\nmay be irreversible!", Material.LIME_STAINED_GLASS_PANE)),
                    Pair('n', ItemStack("&cCancel", "No changes will be made.", Material.RED_STAINED_GLASS_PANE))
                )
            )
        }

        /**
         * Set an action to run when this [GUI] is confirmed.
         *
         * @param action The action to run when this [GUI] is confirmed.
         *
         * @return This [GUI].
         */
        fun onConfirm(action: ((InventoryClickEvent, ClickType) -> Unit)?): Tiny {
            onClick('y', action)

            return this
        }

        /**
         * Set an action to run when this [GUI] is cancelled.
         *
         * @param action The action to run when this [GUI] is cancelled.
         *
         * @return This [GUI].
         */
        fun onCancel(action: ((InventoryClickEvent, ClickType) -> Unit)?): Tiny {
            onClick('n', action)

            return this
        }
    }
}
