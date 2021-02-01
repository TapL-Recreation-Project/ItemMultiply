package me.swipez.itemmultiply;

import me.swipez.itemmultiply.bstats.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class Itemmultiply extends JavaPlugin {
    boolean gamestarted = false;

    public void onEnable() {
        new Metrics(this, 10205);
        this.getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
        this.getCommand("dupechallenge").setExecutor(new StartGame(this));
    }

    public void onDisable() {
    }
}
