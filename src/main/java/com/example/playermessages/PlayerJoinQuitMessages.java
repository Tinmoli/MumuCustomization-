package com.example.playermessages;

import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinQuitMessages extends JavaPlugin {

    private static PlayerJoinQuitMessages instance;

    @Override
    public void onEnable() {
        instance = this;
        
        // 保存默认配置文件
        saveDefaultConfig();
        
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(new PlayerConnectionListener(this), this);
        
        // 注册命令
        CommandHandler commandHandler = new CommandHandler(this);
        getCommand("pjqm").setExecutor(commandHandler);
        getCommand("pjqm").setTabCompleter(commandHandler);
        
        getLogger().info("Mumu Customization 插件已启动!");
        getLogger().info("版本: " + getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        getLogger().info("Mumu Customization 插件已关闭!");
    }

    public static PlayerJoinQuitMessages getInstance() {
        return instance;
    }
}

