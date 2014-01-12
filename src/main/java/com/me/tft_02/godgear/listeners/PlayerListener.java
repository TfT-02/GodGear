package com.me.tft_02.godgear.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import com.me.tft_02.godgear.util.ItemUtils;

public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        ItemUtils.checkHermesBoots(player, boots);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        ItemUtils.checkHermesBoots(player, boots);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        ItemUtils.checkHermesBoots(player, boots);
    }
}
