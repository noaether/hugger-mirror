package ca.noae.hugger;

import ca.noae.hugger.Commands.Interactions.Positive.*;
import ca.noae.hugger.Commands.Interactions.Neutral.*;
import ca.noae.hugger.Commands.Interactions.Negative.*;
import ca.noae.hugger.Commands.Interactions.Punishments.*;
import ca.noae.hugger.Commands.Interactions.Rewards.*;

import ca.noae.hugger.API.Config;
import ca.noae.hugger.Listeners.PlayerInteract;
import org.bukkit.command.Command;
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

        // Commands
        registerNegativeCommands();
        registerNeutralCommands();
        registerPositiveCommands();
        registerPunishmentCommands();
        registerRewardCommands();


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
        HashMap<String, CommandExecutor> negativeCommands = new HashMap<>();
            negativeCommands.put("burn", new Burn());
            negativeCommands.put("hurt", new Hurt());
            negativeCommands.put("shock", new Shock());
            negativeCommands.put("slap", new Slap());
            negativeCommands.put("spank", new Spank());
            negativeCommands.put("whip", new Whip());

        return initializeEntries(negativeCommands);
    }

    public Set<Map.Entry<String, CommandExecutor>> registerNeutralCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> neutralCommands = new HashMap<>();
            neutralCommands.put("nudge", new Nudge());
            neutralCommands.put("poke", new Poke());
            neutralCommands.put("tickle", new Tickle());

        return initializeEntries(neutralCommands);
    }

    public Set<Map.Entry<String, CommandExecutor>> registerPositiveCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> positiveCommands = new HashMap<>();
            positiveCommands.put("cuddle", new Cuddle());
            positiveCommands.put("hug", new Hug());
            positiveCommands.put("kiss", new Kiss());
            positiveCommands.put("love", new Love());
            positiveCommands.put("pet", new Pet());

        return initializeEntries(positiveCommands);
    }

    public Set<Map.Entry<String, CommandExecutor>> registerPunishmentCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> punishmentCommands = new HashMap<>();
            punishmentCommands.put("chain", new Chain());
            punishmentCommands.put("crush", new Crush());
            punishmentCommands.put("cuff", new Cuff());
            punishmentCommands.put("leash", new Leash());
            punishmentCommands.put("muzzle", new Muzzle());

        return initializeEntries(punishmentCommands);
    }

    public Set<Map.Entry<String, CommandExecutor>> registerRewardCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> rewardCommands = new HashMap<>();
            rewardCommands.put("feed", new Feed());
            rewardCommands.put("praise", new Praise());
            rewardCommands.put("treat", new Treat());

        return initializeEntries(rewardCommands);
    }







    @Override
    public void onDisable() {
        // Shutdown Handlers (Clear tasks, save files, etc)
        Config.getInstance().disable();
    }
}
