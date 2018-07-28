package com.jacksonnn.ChatCore.commands;

import com.jacksonnn.ChatCore.GeneralMethods;
import com.jacksonnn.ChatCore.configuration.ConfigManager;
import com.jacksonnn.ChatCore.listeners.GlobalMutedChatListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.List;

public class GlobalMuteCommand extends ChatCoreCommand {

    public GlobalMuteCommand() {
        super("globalmute", "/chatcore globalmute", ConfigManager.languageConfig.get().getString("Commands.GlobalMute.Description"), new String[] { "globalmute", "globalm", "gmute" });
    }

    public void execute(CommandSender sender, List<String> args) {
        if (hasPermission(sender)) {
            GlobalMutedChatListener.chatEnabled = !GlobalMutedChatListener.chatEnabled;
            Bukkit.broadcastMessage(GlobalMutedChatListener.chatEnabled ? GeneralMethods.prefixNormal + "Chat has been unmuted by " + sender.getName() + "." : GeneralMethods.prefixNormal + "Chat has been muted by " + sender.getName() + ".");
            sender.sendMessage(GlobalMutedChatListener.chatEnabled ? GeneralMethods.prefixSuccess + "Unmuted the chat." : GeneralMethods.prefixSuccess + "Muted the chat.");
        }
    }
}