package com.me.tft_02.godgear.util;


import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.me.tft_02.godgear.datatypes.GodItem;

public class ItemUtils {

    public static boolean isGodItem(ItemStack itemStack, GodItem godItem) {
        if (itemStack.getType() != godItem.getMaterial()) {
            return false;
        }

        String name = itemStack.getItemMeta().getDisplayName();

        if (name != null && name.equalsIgnoreCase(godItem.getItemName())) {
            return true;
        }

        return false;
    }

    public static void checkHermesBoots(Player player, ItemStack boots) {
        if (isGodItem(boots, GodItem.HERMES_BOOTS)) {
            player.setAllowFlight(true);
        }
    }
}
