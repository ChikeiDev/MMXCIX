package project.mmxcix.common.files;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigurationFile {

    private static File file;
    private static YamlConfiguration configFile;

    public static void checkFile(final Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }
        ConfigurationFile.file = new File(plugin.getDataFolder(), "config.yml");
        if (!ConfigurationFile.file.exists()) plugin.saveResource("config", true);
        ConfigurationFile.configFile = YamlConfiguration.loadConfiguration(ConfigurationFile.file);
    }

    public static void reload() {
        try {
            ConfigurationFile.configFile.save(ConfigurationFile.file);
            ConfigurationFile.configFile = YamlConfiguration.loadConfiguration(ConfigurationFile.file);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static YamlConfiguration getConfigFile() { return ConfigurationFile.configFile; }
}