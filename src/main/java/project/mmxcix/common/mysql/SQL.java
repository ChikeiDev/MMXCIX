package project.mmxcix.common.mysql;

import org.bukkit.Bukkit;

import java.sql.*;

public class SQL {

    private String Host; private String Database;
    private String User; private String Password;
    private Connection con; private boolean connected;

    public SQL(final String host, final String database, final String user, final String password) {
        this.Host = ""; this.Database = "";
        this.User = ""; this.Password = "";
        this.Host = host; this.Database = database;
        this.User = user; this.Password = password;
        this.connected = false;
    }

    public Connection getCon() { return this.con; }
    public boolean isConnected() { return this.connected; }

    public void connect() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.Host + ":3306/" + this.Database + "?autoReconnect=true", this.User, this.Password);
            Bukkit.getConsoleSender().sendMessage("§e[MySQL] Connected (Project MMXCIX)");
            this.connected = true;
        } catch (SQLException exc) {
            Bukkit.getConsoleSender().sendMessage("§c[MySQL] Connection failed (Project MMXCIX): " + exc.getMessage());
        }
    }

    public void close() {
        try {
            if (this.con != null) {
                this.con.close();
                Bukkit.getConsoleSender().sendMessage("§c[MySQL] Shutting down (Project MMXCIX)");
            }
        } catch (SQLException exc) {
            Bukkit.getConsoleSender().sendMessage("§c[MySQL] Shutdown failed (Project MMXCIX): " + exc.getMessage());
        }
    }

    public void update(final String qry) {
        try {
            final PreparedStatement stmt = this.con.prepareStatement(qry);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exc) {
            this.connect();
            System.err.println(exc);
        }
    }

    public ResultSet query(final String qry) {
        ResultSet rs = null;
        try {
            final PreparedStatement st = this.con.prepareStatement(qry);
            rs = st.executeQuery();
        } catch (SQLException exc) {
            this.connect();
            System.err.println(exc);
        }
        return rs;
    }
}