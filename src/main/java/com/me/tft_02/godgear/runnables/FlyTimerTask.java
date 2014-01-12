package com.me.tft_02.godgear.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.me.tft_02.godgear.datatypes.GodItem;
import com.me.tft_02.godgear.util.ItemUtils;

public class FlyTimerTask extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            ItemStack boots = player.getInventory().getBoots();
            short durabilityLoss = 1;

            if (!ItemUtils.isGodItem(boots, GodItem.HERMES_BOOTS) || !player.isFlying()) {
                continue;
            }

            if ((boots.getDurability() + durabilityLoss) >= boots.getType().getMaxDurability()) {
                player.getInventory().setBoots(null);
            }
            else {
                boots.setDurability((short) (boots.getDurability() + durabilityLoss));
            }

            player.updateInventory();
        }
    }
}
