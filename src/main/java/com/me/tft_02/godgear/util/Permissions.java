package com.me.tft_02.godgear.util;

import org.bukkit.permissions.Permissible;

public class Permissions {

    public static boolean hermesbootsCraft(Permissible permissible) { return permissible.hasPermission("godgear.items.hermesboots.craft"); }

    public static boolean hermesbootsUse(Permissible permissible) { return permissible.hasPermission("godgear.items.hermesboots.use"); }
}
