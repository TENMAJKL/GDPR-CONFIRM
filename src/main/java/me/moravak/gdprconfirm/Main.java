package me.moravak.gdprconfirm;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static Main plugin;

    public void onEnable()
    {
        System.out.println("GDPR confirm enabled!");
        loadConfig();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("gdprconfirm").setExecutor(new Commands());
        plugin = this;

    }
    public void onDisable()
    {
        System.out.println("GDPR confirm disabled!");
    }

    public void loadConfig()
    {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static Main getPlugin() { return plugin; }
}
