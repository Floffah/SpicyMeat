package dev.floffah.spicymeat;

import dev.floffah.spicymeat.listeners.Eat;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class SpicyMeat extends JavaPlugin implements Listener {
    NamespacedKey meatkey;
    NamespacedKey shatkey;
    NamespacedKey cookiekey;
    NamespacedKey popcornkey;
    NamespacedKey cakekey;

    ArrayList<UUID> shatpl = new ArrayList<UUID>();

    @Override
    public void onEnable() {
        meatkey = new NamespacedKey(this, "explodermeat");
        shatkey = new NamespacedKey(this, "eatshit");
        cookiekey = new NamespacedKey(this, "crackcookie");
        popcornkey = new NamespacedKey(this, "popcorn");
        cakekey = new NamespacedKey(this, "carbombcake");

        Recipes.steak(this);
        Recipes.shit(this);
        Recipes.cookie(this);
        Recipes.popcorn(this);
        Recipes.cakebomb(this);

        getServer().getPluginManager().registerEvents(new Eat(this), this);
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

    @Override
    public void onDisable() {
        getServer().removeRecipe(meatkey);
        getServer().removeRecipe(shatkey);
        getServer().removeRecipe(cookiekey);
        getServer().removeRecipe(popcornkey);
        getServer().removeRecipe(cakekey);
    }
}
