package com.jacksonnn.ChatCore;

import com.jacksonnn.ChatCore.commands.Commands;
import com.jacksonnn.ChatCore.configuration.ConfigManager;
import com.jacksonnn.ChatCore.listeners.GlobalChatListener;
import com.jacksonnn.ChatCore.listeners.GlobalMutedChatListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ChatCore extends JavaPlugin {

    public static ChatCore plugin;
    public static Logger log;
    private PluginManager pm = Bukkit.getServer().getPluginManager();

    @Override
    public void onEnable() {
        plugin = this;
        ChatCore.log = this.getLogger();
        new ConfigManager();
        new Commands(plugin);
        registerListeners();
        Bukkit.getServer().getLogger().info(ChatColor.AQUA + "ChatCore has been enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info(ChatColor.AQUA + "ChatCore has been disabled!");
    }

    public void registerListeners() {
        pm.registerEvents(new GlobalChatListener(), this);
        pm.registerEvents(new GlobalMutedChatListener(), this);
        Bukkit.getServer().getLogger().info("Listeners have been enabled!");
    }
}
