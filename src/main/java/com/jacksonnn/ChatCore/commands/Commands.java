package com.jacksonnn.ChatCore.commands;

import com.jacksonnn.ChatCore.ChatCore;
import com.jacksonnn.ChatCore.GeneralMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;

import java.util.Arrays;
import java.util.List;

public class Commands {
    private ChatCore plugin;

    public Commands(ChatCore plugin) {
        this.plugin = plugin;
        registerCommands();
    }

    public void registerCommands() {
        PluginCommand Guilds = plugin.getCommand("guilds");
        new MuteCommand();
        new ChannelsCommand();
        new BannedWordsCommand();

        CommandExecutor exe = new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

                if (args.length == 0) {
                    s.sendMessage(GeneralMethods.prefixNormal + "ChatCore Command Help:");
                    s.sendMessage(ChatColor.YELLOW + "/chatcore mute");
                    return true;
                }

                List<String> sendingArgs = Arrays.asList(args).subList(1, args.length);
                for (ChatCoreCommand command : ChatCoreCommand.instances.values()) {
                    if (Arrays.asList(command.getAliases()).contains(args[0].toLowerCase())) {
                        command.execute(s, sendingArgs);
                        return true;
                    }
                }

                return true;
            }
        };
        Guilds.setExecutor(exe);
        Bukkit.getServer().getLogger().info("Commands have been enabled!");
    }
}
