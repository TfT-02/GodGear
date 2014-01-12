package com.me.tft_02.godgear.listeners;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

import com.me.tft_02.godgear.datatypes.GodItem;
import com.me.tft_02.godgear.util.ItemUtils;

public class InventoryListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        HumanEntity humanEntity = event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        ItemStack cursor = event.getCursor();
        SlotType slotType = event.getSlotType();

        if (!(humanEntity instanceof Player)) {
            return;
        }

        Player player = (Player) humanEntity;

        switch (slotType) {
            case ARMOR:
                if (ItemUtils.isGodItem(current, GodItem.HERMES_BOOTS)) {
                    player.setAllowFlight(false);
                }
                else if (ItemUtils.isGodItem(cursor, GodItem.HERMES_BOOTS)) {
                    player.setAllowFlight(true);
                }
            default:
                break;
        }
    }
}
