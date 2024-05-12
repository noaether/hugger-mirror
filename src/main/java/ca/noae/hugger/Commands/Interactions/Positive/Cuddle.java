package ca.noae.hugger.Commands.Interactions.Positive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Cuddle implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player sender = (Player) commandSender;
        String senderName = sender.getDisplayName();

        if (args.length == 0) {
            sender.sendMessage("You need to specify a player to cuddle!");
            return false;
        }

        return false;
    }
}
