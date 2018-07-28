package com.jacksonnn.ChatCore.commands;

import com.jacksonnn.ChatCore.GeneralMethods;
import com.jacksonnn.ChatCore.configuration.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class BannedWordsCommand extends ChatCoreCommand implements Listener {

    private List<String> bannedWords = new ArrayList<>();

    public BannedWordsCommand() {
        super("bannedwords", "/chatcore bannedwords <add|remove|list> [<word>]", ConfigManager.languageConfig.get().getString("Commands.BannedWords.Description"), new String[] { "bw", "bannedw", "bwords", "words", "bannedwords" });
    }

    public void execute(CommandSender sender, List<String> args) {
        bannedWords = ConfigManager.bannedWords.get().getStringList("AntiCurse.bannedWords");
        if (sender.hasPermission("DCCore.bannedwords")) {
            if (args.size() == 0) {
                sender.sendMessage(GeneralMethods.prefixNormal + "Banned Words Commands:");
                sender.sendMessage(ChatColor.YELLOW + "/bannedwords list");
                sender.sendMessage(ChatColor.YELLOW + "/bannedwords add <word>");
                sender.sendMessage(ChatColor.YELLOW + "/bannedwords remove <word>");
            } else if (args.size() == 1 && args.get(0).equalsIgnoreCase("list")) {

                sender.sendMessage(GeneralMethods.prefixNormal + "Banned Words:");
                for (String words : bannedWords) {
                    sender.sendMessage(words);
                }
            } else if (args.size() == 2 && args.get(0).equalsIgnoreCase("add")) {
                if (bannedWords.contains(args.get(1))) {
                    sender.sendMessage(GeneralMethods.prefixError + "This word is already added!");
                } else {
                    bannedWords.add(args.get(1));
                    ConfigManager.bannedWords.get().set("AntiCurse.bannedWords", bannedWords);
                    ConfigManager.bannedWords.save();

                    sender.sendMessage(GeneralMethods.prefixSuccess + "Added the word, " + args.get(1) + ", to the banned words list.");
                }
            } else if (args.size() == 2 && args.get(0).equalsIgnoreCase("remove")) {
                if (bannedWords.contains(args.get(1))) {
                    bannedWords.remove(args.get(1));
                    ConfigManager.bannedWords.get().set("AntiCurse.bannedWords", bannedWords);
                    ConfigManager.bannedWords.save();
                    sender.sendMessage(GeneralMethods.prefixSuccess + "Removed the banned word, " + args.get(1) + ", from the list.");
                } else {
                    sender.sendMessage(GeneralMethods.prefixError + "The word " + args.get(1) + " is not in the banned words list.");
                }
            } else {
                sender.sendMessage(GeneralMethods.prefixNormal + "Banned Words Commands:");
                sender.sendMessage(ChatColor.YELLOW + "/bannedwords list");
                sender.sendMessage(ChatColor.YELLOW + "/bannedwords add <word>");
                sender.sendMessage(ChatColor.YELLOW + "/bannedwords remove <word>");
            }
        } else {
            sender.sendMessage(GeneralMethods.prefixError + "You have insufficient permission to access this command. Please contact the administraitor if this is incorrect.");
        }
    }
}
