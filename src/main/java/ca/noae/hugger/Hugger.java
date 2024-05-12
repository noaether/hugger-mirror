package ca.noae.hugger;

import ca.noae.hugger.Commands.Interactions.Positive.*;
import ca.noae.hugger.API.Config;
import ca.noae.hugger.Listeners.PlayerInteract;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Hugger extends JavaPlugin {

    private static Hugger instance;
    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();

        instance.getLogger().info("Hugger is ready to make people feel good !");

        // EventListeners
        new PlayerInteract(this);

        // Handlers
        new Config(this);

        // Commands
        Objects.requireNonNull(instance.getCommand("hug")).setExecutor(new Hug());
        Objects.requireNonNull(instance.getCommand("kiss")).setExecutor(new Kiss());
        Objects.requireNonNull(instance.getCommand("praise")).setExecutor(new Praise());
        Objects.requireNonNull(instance.getCommand("pet")).setExecutor(new Pet());
        Objects.requireNonNull(instance.getCommand("cuddle")).setExecutor(new Cuddle());


    }

    @Override
    public void onDisable() {
        // Shutdown Handlers (Clear tasks, save files, etc)
        Config.getInstance().disable();
    }
}
