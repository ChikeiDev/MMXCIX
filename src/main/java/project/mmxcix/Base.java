package project.mmxcix;

import org.bukkit.plugin.java.JavaPlugin;

public final class Base extends JavaPlugin {

    public static Base base;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Base.base = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Base.base = null;
    }

    public static Base getInstance() { return Base.base; }
}
