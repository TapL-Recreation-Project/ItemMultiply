package me.swipez.itemmultiply;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartGame implements CommandExecutor {
    Itemmultiply plugin;

    public StartGame(Itemmultiply plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("dupechallenge.toggle")) {
            if (!this.plugin.gamestarted) {
                if (sender instanceof Player) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Damage Dupe Challenge has begun!");
                    this.plugin.gamestarted = true;
                }
            } else if (this.plugin.gamestarted) {
                if (sender instanceof Player) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Damage Dupe Challenge has ended!");
                    this.plugin.gamestarted = false;
                }

                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have the permission needed to run this command");
        }

        return true;
    }
}
