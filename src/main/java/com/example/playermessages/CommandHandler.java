package com.example.playermessages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler implements CommandExecutor, TabCompleter {

    private final PlayerJoinQuitMessages plugin;

    public CommandHandler(PlayerJoinQuitMessages plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, 
                           @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Component.text("使用 /pjqm reload 重载配置文件", NamedTextColor.YELLOW));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("mumucustomization.reload") && !sender.hasPermission("playermessages.reload")) {
                sender.sendMessage(Component.text("你没有权限执行此命令!", NamedTextColor.RED));
                return true;
            }

            try {
                plugin.reloadConfig();
                sender.sendMessage(Component.text("配置文件已重载!", NamedTextColor.GREEN));
            } catch (Exception e) {
                sender.sendMessage(Component.text("重载配置文件时出错: " + e.getMessage(), NamedTextColor.RED));
                e.printStackTrace();
            }
            return true;
        }

        sender.sendMessage(Component.text("未知的子命令! 使用 /pjqm reload", NamedTextColor.RED));
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, 
                                     @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        
        if (args.length == 1) {
            if (sender.hasPermission("mumucustomization.reload") || sender.hasPermission("playermessages.reload")) {
                completions.add("reload");
            }
        }
        
        return completions;
    }
}

