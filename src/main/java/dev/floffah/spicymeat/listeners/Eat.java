package dev.floffah.spicymeat.listeners;

import dev.floffah.remnantutils.util.Chat;
import dev.floffah.spicymeat.SpicyMeat;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collection;

public class Eat implements Listener {
    SpicyMeat main;

    public Eat(SpicyMeat mn) {
        main = mn;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        Player eater = e.getPlayer();
        ItemStack ate = e.getItem();
        if (ate != null &&
                ate.hasItemMeta()
                && ate.getType() == Material.COOKED_BEEF
                && ate.getItemMeta().getDisplayName().equals(Chat.clr("&cExplosive &eSteak"))) {
            PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 10, 5);
            eater.addPotionEffect(effect);
            eater.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, eater.getLocation(), 0);
            eater.getWorld().playSound(eater.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 5);
        } else if (ate != null &&
                ate.hasItemMeta()
                && ate.getType() == Material.COOKIE
                && ate.getItemMeta().getDisplayName().equals(Chat.clr("&eCrack &6Cookie"))) {
            PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, 200, 100);
            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 100, 5);
            PotionEffect blind = new PotionEffect(PotionEffectType.BLINDNESS, 200, 100);
            Collection<PotionEffect> effects = new ArrayList<PotionEffect>();
            effects.add(speed);
            effects.add(nausea);
            effects.add(blind);
            eater.addPotionEffects(effects);
        }
    }

    @EventHandler
    public void onRight(PlayerInteractEvent e) {
        Player eater = e.getPlayer();
        Action action = e.getAction();
        ItemStack ate = e.getItem();
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (ate != null
                    && ate.hasItemMeta()
                    && ate.getType() == Material.COCOA_BEANS
                    && ate.getItemMeta().getDisplayName().equals(Chat.clr("&cShit"))) {
                e.setCancelled(true);
                PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 50, 100);
                eater.addPotionEffect(effect);
                main.addShat(eater.getUniqueId());
                System.out.println(eater.getDisplayName() + " is about to eat shit and die");
                eater.setHealth(0);
                takeOneFromInv(Material.COCOA_BEANS, Chat.clr("&cShit"), eater);
            } else if (ate != null
                    && ate.hasItemMeta()
                    && ate.getType() == Material.PLAYER_HEAD
                    && ate.getItemMeta().getDisplayName().equals(Chat.clr("&eExtra Salty &6Popcorn"))) {
                e.setCancelled(true);
                PotionEffect speed = new PotionEffect(PotionEffectType.CONFUSION, 200, 100);
                PotionEffect nausea = new PotionEffect(PotionEffectType.POISON, 50, 20);
                PotionEffect poison = new PotionEffect(PotionEffectType.BLINDNESS, 200, 100);
                Collection<PotionEffect> effects = new ArrayList<PotionEffect>();
                effects.add(speed);
                effects.add(nausea);
                effects.add(poison);
                eater.addPotionEffects(effects);
                takeOneFromInv(Material.PLAYER_HEAD, Chat.clr("&eExtra Salty &6Popcorn"), eater);
            } else if (ate != null
                    && ate.hasItemMeta()
                    && ate.getType() == Material.PLAYER_HEAD
                    && ate.getItemMeta().getDisplayName().equals(Chat.clr("&6Car Bomb &eCake"))) {
                e.setCancelled(true);
                eater.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, eater.getLocation(), 0);
                takeOneFromInv(Material.PLAYER_HEAD, Chat.clr("&6Car Bomb &eCake"), eater);
                eater.getWorld().playSound(eater.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 5);
                eater.damage(4);

                if(eater.getFoodLevel() <= 18) {
                    eater.setFoodLevel(eater.getFoodLevel() + 2);
                }
            }
        }
    }

    public void takeOneFromInv(Material mat, String name, Player inv) {
        if (inv.getGameMode() != GameMode.CREATIVE) {
            for (int i = 0; i < inv.getInventory().getSize(); i++) {
                ItemStack item = inv.getInventory().getItem(i);
                if (item != null && item.getType() == mat && item.getItemMeta().getDisplayName().equals(name)) {
                    int amount = item.getAmount() - 1;
                    item.setAmount(amount);
                    inv.getInventory().setItem(i, amount > 0 ? item : null);
                    inv.updateInventory();
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onDie(PlayerDeathEvent e) {
        Player player = e.getEntity();
        if (main.wasShat(player.getUniqueId())) {
            e.setDeathMessage(Chat.clr("&c" + player.getDisplayName() + " &eate shit and died."));
            player.sendMessage(Chat.clr("&cYou ate shit and died."));
            main.removeShat(player.getUniqueId());
        }
    }
}
