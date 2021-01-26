package me.swipez.itemmultiply;

import org.bukkit.plugin.java.JavaPlugin;

public final class Itemmultiply extends JavaPlugin {
    boolean gamestarted = false;

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
        this.getCommand("dupechallenge").setExecutor(new StartGame(this));
    }

    public void onDisable() {
    }
}
