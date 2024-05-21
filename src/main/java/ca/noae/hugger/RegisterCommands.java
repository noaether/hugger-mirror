package ca.noae.hugger;

import ca.noae.hugger.Commands.Interactions.Negative.*;
import ca.noae.hugger.Commands.Interactions.Neutral.*;
import ca.noae.hugger.Commands.Interactions.Positive.*;
import ca.noae.hugger.Commands.Interactions.Punishments.*;
import ca.noae.hugger.Commands.Interactions.Rewards.*;
import ca.noae.hugger.Hugger;
import org.bukkit.command.CommandExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RegisterCommands {

    public static Set<Map.Entry<String, CommandExecutor>> initializeEntries(HashMap<String, CommandExecutor> commands) {
        Set<HashMap.Entry<String, CommandExecutor>> entries = commands.entrySet();
        for (HashMap.Entry<String, CommandExecutor> entry : entries) {
            Objects.requireNonNull(Hugger.getInstance().getCommand(entry.getKey())).setExecutor(entry.getValue());
        }

        return entries;
    }

    public static Set<Map.Entry<String, CommandExecutor>> registerNegativeCommands() {
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

    public static Set<Map.Entry<String, CommandExecutor>> registerNeutralCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> neutralCommands = new HashMap<>();
        neutralCommands.put("nudge", new Nudge());
        neutralCommands.put("poke", new Poke());
        neutralCommands.put("tickle", new Tickle());

        return initializeEntries(neutralCommands);
    }

    public static Set<Map.Entry<String, CommandExecutor>> registerPositiveCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> positiveCommands = new HashMap<>();
        positiveCommands.put("cuddle", new Cuddle());
        positiveCommands.put("hug", new Hug());
        positiveCommands.put("kiss", new Kiss());
        positiveCommands.put("love", new Love());
        positiveCommands.put("pet", new Pet());

        return initializeEntries(positiveCommands);
    }

    public static Set<Map.Entry<String, CommandExecutor>> registerPunishmentCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> punishmentCommands = new HashMap<>();
        punishmentCommands.put("chain", new Chain());
        punishmentCommands.put("crush", new Crush());
        punishmentCommands.put("cuff", new Cuff());
        punishmentCommands.put("leash", new Leash());
        punishmentCommands.put("muzzle", new Muzzle());

        return initializeEntries(punishmentCommands);
    }

    public static Set<Map.Entry<String, CommandExecutor>> registerRewardCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> rewardCommands = new HashMap<>();
        rewardCommands.put("feed", new Feed());
        rewardCommands.put("praise", new Praise());
        rewardCommands.put("treat", new Treat());

        return initializeEntries(rewardCommands);
    }

    public static Set<Map.Entry<String, CommandExecutor>> registerIdentityCommands() {
        // initialize hashmap
        HashMap<String, CommandExecutor> identityCommands = new HashMap<>();
        identityCommands.put("idconfig", new ca.noae.hugger.Commands.Players.Identity.Configure());
        identityCommands.put("idcreate", new ca.noae.hugger.Commands.Players.Identity.Create());
        identityCommands.put("idsee", new ca.noae.hugger.Commands.Players.Identity.See());

        return initializeEntries(identityCommands);
    }

    public static Set<Map.Entry<String, CommandExecutor>> registerRelationshipCommands() {
        // initialize hashmap
        // accept, configure, create, decline, see
        HashMap<String, CommandExecutor> relationshipCommands = new HashMap<>();
        relationshipCommands.put("accept", new ca.noae.hugger.Commands.Players.Relations.Accept());
        relationshipCommands.put("relconfigure", new ca.noae.hugger.Commands.Players.Relations.Configure());
        relationshipCommands.put("relcreate", new ca.noae.hugger.Commands.Players.Relations.Create());
        relationshipCommands.put("decline", new ca.noae.hugger.Commands.Players.Relations.Decline());
        relationshipCommands.put("relsee", new ca.noae.hugger.Commands.Players.Relations.See());

        return initializeEntries(relationshipCommands);
    }

}
