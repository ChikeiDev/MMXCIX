package project.mmxcix.common.files;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class LanguageFile {

    private static File file;
    private static YamlConfiguration langFile;

    public static void checkFile(final Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }
        LanguageFile.file = new File(plugin.getDataFolder(), "config.yml");
        if (!LanguageFile.file.exists()) plugin.saveResource("config", true);
        LanguageFile.langFile = YamlConfiguration.loadConfiguration(LanguageFile.file);
    }

    public static void reload() {
        try {
            LanguageFile.langFile.save(LanguageFile.file);
            LanguageFile.langFile = YamlConfiguration.loadConfiguration(LanguageFile.file);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static YamlConfiguration getLangFile() { return LanguageFile.langFile; }
}
