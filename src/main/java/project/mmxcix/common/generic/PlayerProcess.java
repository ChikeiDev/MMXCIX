package project.mmxcix.common.generic;

import org.bukkit.entity.Player;
import project.mmxcix.common.mysql.Query;

public class PlayerProcess {

    public void registerPlayerToMySQL(final Player player) {
        if(!Query.playerExists(player.getUniqueId())) {
            Query.createPlayer(player.getUniqueId(), player.getName());
        }
    }
}