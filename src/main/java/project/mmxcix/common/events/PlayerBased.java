package project.mmxcix.common.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import project.mmxcix.Base;
import project.mmxcix.common.generic.PlayerProcess;

public class PlayerBased implements Listener {

    public PlayerBased(final Base base) { base.getServer().getPluginManager().registerEvents(this, base); }

    final PlayerProcess playerProcess = new PlayerProcess();

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        playerProcess.registerPlayerToMySQL(player);
    }
}