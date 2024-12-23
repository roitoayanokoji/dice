package com.github.roitoayanokoji.dice;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class Dice extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("OnEnable");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("OnDisable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("dice")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int random = new Random().nextInt(6)+1;
                player.sendMessage("6面ダイスを振って" + random + "が出ました。");
                getServer().broadcastMessage(player.getName() + "が6面ダイスを振って" + random + "が出ました。");
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ実行可能です！");
            }
            return true;
        }
        return false;
    }
}
