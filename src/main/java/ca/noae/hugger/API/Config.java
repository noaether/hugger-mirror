package ca.noae.hugger.API;

import ca.noae.hugger.Hugger;

public class Config {

    private static Hugger plugin;
    private static Config instance;

    public Config(Hugger plugin) {
        Config.plugin = plugin;
        Config.instance = this;
    }

    public static Config getInstance() {
        return instance;
    }

    public Config disable() {
        plugin.saveConfig();
        return this;
    }
}
