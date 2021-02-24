package project.mmxcix.common.permissions;

import org.bukkit.command.CommandSender;

public class PermissionHandler {

    public static boolean has(CommandSender sender, PermissionNode node) {
        if(sender.isOp()) {
            return true;
        }
        return sender.hasPermission(node.getNode());
    }
}
