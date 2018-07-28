package com.jacksonnn.ChatCore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GlobalMutedChatListener implements Listener {

    public static boolean chatEnabled = true;

    @EventHandler
    public void onMutedChat(AsyncPlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("ChatCore.bypass")) {
            if (!chatEnabled) {
                if (!event.getMessage().startsWith("/")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
