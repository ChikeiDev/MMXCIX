package project.mmxcix.common.mysql;

import project.mmxcix.Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Query {

    public static boolean playerExists(final UUID uuid) {
        final String uid = uuid.toString();
        try {
            final ResultSet rs = Base.mySQL.query("SELECT * FROM Registered_Players WHERE UUID= '" + uid + "'");
            return rs.next() && rs.getString("UUID") != null;
        } catch (SQLException exc) {
            return false;
        }
    }

    public static void createPlayer(final UUID uuid, final String name) {
        if (!playerExists(uuid)) {
            Base.mySQL.update("INSERT INTO Registered_Players VALUES('" + uuid + "', '" + name + "');");
        }
    }
}