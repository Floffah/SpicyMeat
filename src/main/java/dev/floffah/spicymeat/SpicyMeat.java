package dev.floffah.spicymeat;

import dev.floffah.remnantutils.RemnantUtils;
import dev.floffah.spicymeat.listeners.Eat;
import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class SpicyMeat extends JavaPlugin implements Listener {
    RemnantUtils utils;
    NamespacedKey meatkey;
    NamespacedKey shatkey;
    NamespacedKey cookiekey;
    NamespacedKey popcornkey;
    NamespacedKey cakekey;

    HeadDatabaseAPI hdapi = null;

    ArrayList<UUID> shatpl = new ArrayList<UUID>();

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("RemnantUtils") == null) {
            System.out.println("Could not find RemnantUtils v1.1.0");
            getServer().getPluginManager().disablePlugin(this);
        } else {
            utils = (RemnantUtils) getServer().getPluginManager().getPlugin("RemnantUtils");
            meatkey = new NamespacedKey(this, "explodermeat");
            shatkey = new NamespacedKey(this, "eatshit");
            cookiekey = new NamespacedKey(this, "crackcookie");
            popcornkey = new NamespacedKey(this, "popcorn");
            cakekey = new NamespacedKey(this, "carbombcake");

            Recipes.steak(this);
            Recipes.shit(this);
            Recipes.cookie(this);

            getServer().getPluginManager().registerEvents(new Eat(this), this);
            getServer().getPluginManager().registerEvents(this, this);

            try {
                HeadDatabaseAPI test = new HeadDatabaseAPI();
                ItemStack testhead = test.getItemHead("24953");
                if(testhead != null) {
                    hdapi = test;
                    Recipes.popcorn(this);
                    Recipes.cakebomb(this);
                    getLogger().info("Connected to the HeadDatabase API");
                }
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    public boolean wasShat(UUID id) {
        return shatpl.contains(id);
    }

    public void addShat(UUID id) {
        shatpl.add(id);
    }

    public void removeShat(UUID id) {
        shatpl.remove(id);
    }

    @EventHandler
    public void onDatabaseLoad(DatabaseLoadEvent e) {
        hdapi = new HeadDatabaseAPI();
        Recipes.popcorn(this);
        Recipes.cakebomb(this);
        getLogger().info("Connected to the HeadDatabase API");
    }

    @Override
    public void onDisable() {
        getServer().removeRecipe(meatkey);
        getServer().removeRecipe(shatkey);
        getServer().removeRecipe(cookiekey);
        if(hdapi != null) {
            getServer().removeRecipe(popcornkey);
            getServer().removeRecipe(cakekey);
        }
    }
}
