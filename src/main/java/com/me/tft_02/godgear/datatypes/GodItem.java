package com.me.tft_02.godgear.datatypes;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum GodItem {
    HERMES_BOOTS(Material.DIAMOND_BOOTS, ChatColor.GOLD + "Hermes Boots");

    private Material material;
    private String itemName;

    GodItem(Material material, String itemName) {
        this.material = material;
        this.itemName = itemName;
    }

    public Material getMaterial() {
        return material;
    }

    public String getItemName() {
        return itemName;
    }
}
