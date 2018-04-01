package n3wb13.test;

import n3wb13.core.Core;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        Core.getInstance().registerPlugin(this);
    }

    @Override
    public void onDisable() {
    }
}
