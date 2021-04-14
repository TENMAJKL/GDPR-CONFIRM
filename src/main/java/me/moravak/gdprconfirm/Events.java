package me.moravak.gdprconfirm;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
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
        if (e.getView().getTitle().equals(plugin.getConfig().getString("labels.guiName")))
        {
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() != null)
            {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("labels.confirm")))
                {
                    player.performCommand("gdprconfirm");
                    player.closeInventory();

                }
                else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("labels.deny")))
                {
                    player.kickPlayer(plugin.getConfig().getString("labels.KickMessage"));
                }
            }

            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e)
    {
        if (e.getView().getTitle().equals(plugin.getConfig().getString("labels.guiName")))
        {
            List<String> confirmed = plugin.getConfig().getStringList("confirmed");
            Player player = (Player) e.getPlayer();
            if (!confirmed.contains(player.getName())) {
                player.kickPlayer(plugin.getConfig().getString("labels.KickMessage"));
            }
        }

    }
}
