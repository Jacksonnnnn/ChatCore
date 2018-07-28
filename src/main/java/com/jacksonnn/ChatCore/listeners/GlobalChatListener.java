package com.jacksonnn.ChatCore.listeners;

import com.jacksonnn.ChatCore.GeneralMethods;
import com.jacksonnn.ChatCore.configuration.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GlobalChatListener implements Listener {

    @EventHandler
    public void onRegularChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        for (String s : event.getMessage().split(" ")) {
            if(ConfigManager.bannedWords.get().getStringList("AntiCurse.bannedWords").contains(s)) {
                if (!player.hasPermission("ChatCore.bypass")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(GeneralMethods.prefixNormal + " Please rethink your choice of words... (don\'t cuss!)");
                }
            }
        }
    }
}
