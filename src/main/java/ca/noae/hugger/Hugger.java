package ca.noae.hugger;

import static ca.noae.hugger.RegisterCommands.*;

import ca.noae.hugger.API.Config;
import ca.noae.hugger.Listeners.PlayerInteract;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

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
        Set<Map.Entry<String, CommandExecutor>> commands = new HashSet<>();
        commands.addAll(registerNegativeCommands());
        commands.addAll(registerNeutralCommands());
        commands.addAll(registerPositiveCommands());
        commands.addAll(registerPunishmentCommands());
        commands.addAll(registerRewardCommands());
        commands.addAll(registerIdentityCommands());
        commands.addAll(registerRelationshipCommands());
    }

    public static Hugger getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Shutdown Handlers (Clear tasks, save files, etc)
        Config.getInstance().disable();
    }
}
