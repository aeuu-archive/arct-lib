package io.arct.arctlib.ui

import io.arct.arctlib.plugin.event.PluginListener
import org.bukkit.Bukkit
import org.bukkit.entity.HumanEntity
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryInteractEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

/**
 * A graphical user interface using in-game chest menus.
 *
 * @param name The name and title of the GUI.
 * @param rows The amount of 9 column rows in the GUI.
 */
open class GUI(val name: String, rows: Int) {
    internal var open: ((InventoryOpenEvent) -> Unit)? = null
    internal var close: ((InventoryCloseEvent) -> Unit)? = null
    internal var click: MutableMap<Char, ((InventoryClickEvent, ClickType) -> Unit)?> = HashMap()

    private val inventory = Bukkit.createInventory(null, rows * 9, name)
    private val items: MutableList<Pair<Char, ItemStack?>> = MutableList(9 * rows) { Pair('!', null) }

    init {
        windows[inventory] = this
    }

    /**
     * Set the item in a slot.
     *
     * @param slot The slot in the inventory.
     * @param item The [ItemStack] to set the slot to.
     * @param id The ID of the item (for actions).
     *
     * @return This [GUI].
     */
    fun set(slot: Int, item: ItemStack?, id: Char = '!'): GUI {
        inventory.setItem(slot, item)
        items[slot] = Pair(id, item)

        return this
    }

    /**
     * Fill the inventory with an [ItemStack].
     *
     * @param item The [ItemStack] to fill.
     * @param id The ID of the item (for actions).
     *
     * @return This [GUI].
     */
    fun fill(item: ItemStack?, id: Char = '!'): GUI {
        for (slot in 0 until inventory.size)
            set(slot, item, id)

        return this
    }

    /**
     * Set the inventory using a mask.
     *
     * @param mask The mask of the inventory, Character values are IDs.
     * @param key A [Map] of the characters in the mask to ItemStacks.
     *
     * @return This [GUI].
     */
    fun mask(mask: List<Char>, key: Map<Char, ItemStack?>): GUI {
        for (slot in mask.indices)
            if (mask[slot] != '*')
                set(slot, key.getOrDefault(mask[slot], null), mask[slot])

        return this
    }

    /**
     * Set the inventory using an [Inventory].
     *
     * @param inventory The [Inventory]
     *
     * @return This [GUI].
     */
    fun inventory(inventory: Inventory): GUI {
        for (slot in 0 until inventory.size)
            set(slot, inventory.getItem(slot), slot.toChar())

        return this
    }

    /**
     * Display this [GUI] to a [HumanEntity].
     *
     * @param entity The [HumanEntity] to show the [GUI] to.
     *
     * @return This [GUI].
     */
    fun show(entity: HumanEntity): GUI {
        entity.openInventory(inventory)

        return this
    }

    /**
     * Set an action to run when this [GUI] is opened.
     *
     * @param action The action to run when this [GUI] is opened.
     *
     * @return This [GUI].
     */
    fun onOpen(action: ((InventoryOpenEvent) -> Unit)?): GUI {
        open = action

        return this
    }

    /**
     * Set an action to run when this [GUI] is closed.
     *
     * @param action The action to run when this [GUI] is closed.
     *
     * @return This [GUI].
     */
    fun onClose(action: ((InventoryCloseEvent) -> Unit)?): GUI {
        close = action

        return this
    }

    /**
     * Set an action to run when an [ItemStack] in this [GUI] is clicked.
     *
     * @param id The ID of the [ItemStack]s to match to.
     * @param action The action to run when this [GUI] is opened.
     *
     * @return This [GUI].
     */
    fun onClick(id: Char, action: ((InventoryClickEvent, ClickType) -> Unit)?): GUI {
        click[id] = action

        return this
    }

    companion object {
        /**
         * A list of [GUI]s that have been created mapped by their [Inventory]s.
         */
        private val windows: MutableMap<Inventory, GUI> = HashMap()
    }

    /**
     * The GUI Listener.
     */
    object Listener : PluginListener() {
        /**
         * @suppress
         */
        @EventHandler
        private fun onClick(e: InventoryClickEvent) {
            val window = windows[e.inventory] ?: return
            val id = window.items[e.slot].first

            window.click[id]?.invoke(e, e.click)

            e.result = Event.Result.DENY
            e.isCancelled = true
        }

        /**
         * @suppress
         */
        @EventHandler
        private fun onOpen(e: InventoryOpenEvent) {
            windows[e.inventory]?.open?.invoke(e)
        }

        /**
         * @suppress
         */
        @EventHandler
        private fun onClose(e: InventoryCloseEvent) {
            windows[e.inventory]?.close?.invoke(e)
        }

        /**
         * @suppress
         */
        @EventHandler
        private fun onInteract(e: InventoryInteractEvent) {
            windows[e.inventory] ?: return

            e.result = Event.Result.DENY
            e.isCancelled = true
        }
    }
}
