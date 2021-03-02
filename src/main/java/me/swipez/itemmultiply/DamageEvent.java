package me.swipez.itemmultiply;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class DamageEvent implements Listener {
    Itemmultiply plugin;

    public DamageEvent(Itemmultiply plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (this.plugin.gamestarted && e.getEntity().getType() == EntityType.PLAYER) {
            Player p = (Player)e.getEntity();
            ItemStack[] base = p.getInventory().getContents();

            for(int i = 0; i < 41; ++i) {
                if (base[i] != null) {
                    int newcount = base[i].getAmount() * 2;
                    if (newcount > 127) {
                        base[i].setAmount(newcount - 127);
                        p.getInventory().addItem(new ItemStack[]{base[i]});
                        newcount = 127;
                        if (p.getInventory().firstEmpty() == -1) {
                            p.getWorld().dropItemNaturally(p.getLocation(), base[i]);
                        }
                    }

                    base[i].setAmount(newcount);
                    p.getInventory().clear(i);
                    p.getInventory().setItem(i, base[i]);
                }
            }
        }

    }
}
