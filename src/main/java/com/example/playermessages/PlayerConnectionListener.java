package com.example.playermessages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    private final PlayerJoinQuitMessages plugin;
    private final MiniMessage miniMessage;

    public PlayerConnectionListener(PlayerJoinQuitMessages plugin) {
        this.plugin = plugin;
        this.miniMessage = MiniMessage.miniMessage();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String joinMessage;
        
        // 优先级：单独玩家 > OP > 默认消息
        // 1. 首先检查是否有该玩家的特定消息
        if (plugin.getConfig().contains("messages.players." + playerName + ".join")) {
            joinMessage = plugin.getConfig().getString("messages.players." + playerName + ".join");
        }
        // 2. 检查玩家是否是OP，使用OP消息
        else if (player.isOp() && plugin.getConfig().contains("messages.op.join")) {
            joinMessage = plugin.getConfig().getString("messages.op.join");
        }
        // 3. 使用默认消息
        else {
            joinMessage = plugin.getConfig().getString("messages.join", "<green>%player% 加入了服务器");
        }
        
        // 替换玩家名称占位符
        joinMessage = joinMessage.replace("%player%", playerName);
        
        // 使用MiniMessage解析颜色代码和格式
        Component component = miniMessage.deserialize(joinMessage);
        
        // 设置自定义的进入消息
        event.joinMessage(component);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String quitMessage;
        
        // 优先级：单独玩家 > OP > 默认消息
        // 1. 首先检查是否有该玩家的特定消息
        if (plugin.getConfig().contains("messages.players." + playerName + ".quit")) {
            quitMessage = plugin.getConfig().getString("messages.players." + playerName + ".quit");
        }
        // 2. 检查玩家是否是OP，使用OP消息
        else if (player.isOp() && plugin.getConfig().contains("messages.op.quit")) {
            quitMessage = plugin.getConfig().getString("messages.op.quit");
        }
        // 3. 使用默认消息
        else {
            quitMessage = plugin.getConfig().getString("messages.quit", "<red>%player% 离开了服务器");
        }
        
        // 替换玩家名称占位符
        quitMessage = quitMessage.replace("%player%", playerName);
        
        // 使用MiniMessage解析颜色代码和格式
        Component component = miniMessage.deserialize(quitMessage);
        
        // 设置自定义的退出消息
        event.quitMessage(component);
    }
}

