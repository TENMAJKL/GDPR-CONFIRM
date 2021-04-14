package me.moravak.gdprconfirm;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Commands implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("gdprconfirm"))
        {
            Player player = (Player) sender;
            List<String> confirmed = plugin.getConfig().getStringList("confirmed");
            if (!confirmed.contains(player.getName()))
            {
                confirmed.add( player.getName());
                plugin.getConfig().set("confirmed", confirmed);
                plugin.saveConfig();
            }
            return true;
        }
        return false;
    }

}
