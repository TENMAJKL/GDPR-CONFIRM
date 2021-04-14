package me.moravak.gdprconfirm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Gui {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static Inventory createGui()
    {
        Inventory gui = Bukkit.createInventory(null, 27, plugin.getConfig().getString("labels.guiName"));
        ItemStack confirm = Items.createItem(Material.LIME_CONCRETE, plugin.getConfig().getString("labels.confirm"));
        ItemStack deny = Items.createItem(Material.RED_CONCRETE, plugin.getConfig().getString("labels.deny"));
        ItemStack info = Items.createItem(Material.ORANGE_CONCRETE, plugin.getConfig().getString("labels.GDPRlink"));

        gui.setItem(11, confirm);
        gui.setItem(15, deny);
        gui.setItem(22, info);
        return gui;
    }
}
