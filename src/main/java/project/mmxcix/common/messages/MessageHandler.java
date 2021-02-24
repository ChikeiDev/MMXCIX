package project.mmxcix.common.messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import project.mmxcix.common.files.LanguageFile;

public class MessageHandler {

    public static void sendMessageToPlayer(final Player player, final String msg) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                LanguageFile.getLangFile().getString("Prefix") + msg));
    }

    public static void sendNoPrefixMessageToPlayer(final Player player, final String msg) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    public static void sendMessageToConsole(final String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                LanguageFile.getLangFile().getString("Prefix") + message));
    }
}