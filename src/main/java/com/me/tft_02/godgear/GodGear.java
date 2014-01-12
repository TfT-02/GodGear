package com.me.tft_02.godgear;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.me.tft_02.godgear.listeners.InventoryListener;
import com.me.tft_02.godgear.listeners.PlayerListener;
import com.me.tft_02.godgear.runnables.FlyTimerTask;

public class GodGear extends JavaPlugin {
    public boolean debug_mode = false;

    /**
     * Run things on enable.
     */
    @Override
    public void onEnable() {
        setupConfiguration();

        if (getConfig().getBoolean("General.Debug_Mode")) {
            debug_mode = true;
        }

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new InventoryListener(), this);

        // Fly check timer (Runs every two seconds)
        new FlyTimerTask().runTaskTimer(this, 0, 3 * 20);

        addCustomRecipes();
    }

    private void addCustomRecipes() {
        MaterialData diamondBlock = new MaterialData(Material.DIAMOND_BLOCK);
        MaterialData feather = new MaterialData(Material.FEATHER);
        ShapedRecipe HermesBoots = new ShapedRecipe(getHermesBoots());
        HermesBoots.shape(new String[]{"X X", "Z Z"});
        HermesBoots.setIngredient('X', diamondBlock);
        HermesBoots.setIngredient('Z', feather);
        getServer().addRecipe(HermesBoots);
    }

    private ItemStack getHermesBoots() {
        MaterialData diamondBoots = new MaterialData(Material.DIAMOND_BOOTS);
        ItemStack is = diamondBoots.toItemStack(1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(ChatColor.GOLD + "Hermes Boots");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Allows you to fly!");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    private void setupConfiguration() {
        final FileConfiguration config = this.getConfig();
        config.addDefault("God_Item.Hermes_Boots.Length", 1200);
        config.options().copyDefaults(true);
        saveConfig();
    }

    /**
     * Run things on disable.
     */
    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelTasks(this);
    }
}