package ca.noae.hugger.Listeners;

import ca.noae.hugger.Hugger;
import org.bukkit.event.Listener;

public class PlayerInteract implements Listener {

    private static Hugger plugin;

    public PlayerInteract(Hugger plugin) {
        PlayerInteract.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
