package me.moravak.gdprconfirm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Gui {
    public static Inventory createGui()
    {
        Inventory gui = Bukkit.createInventory(null, 27, "§4Confirm GDPR");
        ItemStack confirm = Items.createItem(Material.LIME_CONCRETE, "§aClick to confirm GDPR");
        ItemStack deny = Items.createItem(Material.RED_CONCRETE, "§4Click to deny GDPR");

        gui.setItem(11, confirm);
        gui.setItem(15, deny);
        return gui;
    }
}
