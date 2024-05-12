package ca.noae.hugger;

import ca.noae.hugger.Commands.Interactions.Positive.*;
import ca.noae.hugger.Commands.Interactions.Neutral.*;
import ca.noae.hugger.Commands.Interactions.Negative.*;
import ca.noae.hugger.Commands.Interactions.Punishments.*;

import ca.noae.hugger.API.Config;
import ca.noae.hugger.Listeners.PlayerInteract;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

        //


    }

    public Set<Map.Entry<String, CommandExecutor>> initializeEntries(HashMap<String, CommandExecutor> commands) {
        Set<HashMap.Entry<String, CommandExecutor>> entries = commands.entrySet();
        for (HashMap.Entry<String, CommandExecutor> entry : entries) {
            Objects.requireNonNull(instance.getCommand(entry.getKey())).setExecutor(entry.getValue());
        }

        return entries;
    }

    public Set<Map.Entry<String, CommandExecutor>> registerNegativeCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> commands = new HashMap<>();
            commands.put("burn", new Burn());
            commands.put("hurt", new Hurt());
            commands.put("shock", new Shock());
            commands.put("slap", new Slap());
            commands.put("spank", new Spank());
            commands.put("whip", new Whip());

        return initializeEntries(commands);
    }

    public Set<Map.Entry<String, CommandExecutor>> registerNeutralCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> commands = new HashMap<>();
            commands.put("poke", new Poke());

        return initializeEntries(commands);
    }







    @Override
    public void onDisable() {
        // Shutdown Handlers (Clear tasks, save files, etc)
        Config.getInstance().disable();
    }
}
