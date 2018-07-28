package com.jacksonnn.ChatCore;

import com.jacksonnn.ChatCore.commands.Commands;
import com.jacksonnn.ChatCore.configuration.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ChatCore extends JavaPlugin {

    public static ChatCore plugin;
    public static Logger log;

    @Override
    public void onEnable() {
        plugin = this;
        ChatCore.log = this.getLogger();
        new ConfigManager();
        new Commands(plugin);
        Bukkit.getServer().getLogger().info("ChatCore has been enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info("ChatCore has been disabled!");
    }
}
