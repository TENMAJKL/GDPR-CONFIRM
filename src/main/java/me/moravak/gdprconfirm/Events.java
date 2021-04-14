package me.moravak.gdprconfirm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import java.util.List;

public class Events implements Listener
{
    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        List<String> confirmed = plugin.getConfig().getStringList("confirmed");
        Player player = e.getPlayer();
        if (!confirmed.contains(player.getName()))
        {
            player.openInventory(Gui.createGui());
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e)
    {
        if (e.getView().getTitle().equals("§4Confirm GDPR"))
        {
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() != null)
            {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aClick to confirm GDPR"))
                {
                    player.performCommand("gdprconfirm");
                    player.closeInventory();

                }
                else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Click to deny GDPR"))
                {
                    player.kickPlayer("You need to confirm GDPR to play here");
                }
            }

            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e)
    {
        if (e.getView().getTitle().equals("§4Confirm GDPR"))
        {
            List<String> confirmed = plugin.getConfig().getStringList("confirmed");
            Player player = (Player) e.getPlayer();
            if (!confirmed.contains(player.getName())) {
                player.kickPlayer("You need to confirm GDPR to play here");
            }
        }

    }
}
