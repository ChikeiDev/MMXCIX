package project.mmxcix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import project.mmxcix.common.files.ConfigurationFile;
import project.mmxcix.common.files.LanguageFile;
import project.mmxcix.common.mysql.SQL;

public final class Base extends JavaPlugin {

    public static Base base;

    public String host; public String database;
    public String user; public String password;
    public static SQL mySQL;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Base.base = this;
        loadFiles();
        loadListeners();
        loadCommands();
        setMySQLCredentials();
        connectMySQL();

    }

    private void loadListeners() { }
    private void loadCommands() { }

    private void loadFiles() {
        ConfigurationFile.checkFile(this);
        LanguageFile.checkFile(this);
    }

    private void setMySQLCredentials() {
        this.host = ConfigurationFile.getConfigFile().getString("MySQL.host");
        this.database = ConfigurationFile.getConfigFile().getString("MySQL.database");
        this.user = ConfigurationFile.getConfigFile().getString("MySQL.username");
        this.password = ConfigurationFile.getConfigFile().getString("MySQL.password");
    }

    private void connectMySQL() {
        Bukkit.getScheduler().runTaskAsynchronously(getInstance(), () ->
                (Base.mySQL = new SQL(this.host, this.database, this.user, this.password)).update(
                        "CREATE TABLE IF NOT EXISTS Registered_Players(UUID VARCHAR(64), Name VARCHAR(32));"));
        //TODO > GENERATE MORE TABLES RELATED TO STATS
    }

    public static Base getInstance() { return Base.base; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Base.base = null;
    }
}