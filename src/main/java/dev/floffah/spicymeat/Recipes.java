package dev.floffah.spicymeat;

import dev.floffah.remnantutils.util.Chat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Recipes {
    public static void steak(SpicyMeat pl) {
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 1);
        ItemMeta ms = steak.getItemMeta();
        ms.setDisplayName(Chat.clr("&cExplosive &eSteak"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Chat.clr("&cEat at your own risk!"));
        ms.setLore(lore);
        steak.setItemMeta(ms);

        ShapedRecipe esteak = new ShapedRecipe(pl.meatkey, steak);

        esteak.shape("*&");
        esteak.setIngredient('*', Material.GUNPOWDER);
        esteak.setIngredient('&', Material.COOKED_BEEF);

        pl.getServer().addRecipe(esteak);
    }

    public static void shit(SpicyMeat pl) {
        ItemStack beans = new ItemStack(Material.COCOA_BEANS, 1);
        ItemMeta ms = beans.getItemMeta();
        ms.setDisplayName(Chat.clr("&cShit"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Chat.clr("&eEat shit and die."));
        ms.setLore(lore);
        beans.setItemMeta(ms);

        ShapedRecipe ebeans = new ShapedRecipe(pl.shatkey, beans);

        ebeans.shape("*&");
        ebeans.setIngredient('*', Material.BROWN_DYE);
        ebeans.setIngredient('&', Material.COCOA_BEANS);

        pl.getServer().addRecipe(ebeans);
    }

    public static void cookie(SpicyMeat pl) {
        ItemStack cookie = new ItemStack(Material.COOKIE, 1);
        ItemMeta cs = cookie.getItemMeta();
        cs.setDisplayName(Chat.clr("&eCrack &6Cookie"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Chat.clr("&4DRUGS ARE BAD"));
        cs.setLore(lore);
        cookie.setItemMeta(cs);

        ShapedRecipe ecookie = new ShapedRecipe(pl.cookiekey, cookie);

        ecookie.shape("*&");
        ecookie.setIngredient('*', Material.BONE_MEAL);
        ecookie.setIngredient('&', Material.COOKIE);

        pl.getServer().addRecipe(ecookie);
    }

    public static void popcorn(SpicyMeat pl) {
        ItemStack popcorn = pl.hdapi.getItemHead("24953");
        SkullMeta ps = (SkullMeta) popcorn.getItemMeta();
        ps.setDisplayName(Chat.clr("&eExtra Salty &6Popcorn"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Chat.clr("&cExtra salty more like sodium poisoning."));
        ps.setLore(lore);
        popcorn.setItemMeta(ps);

        ShapedRecipe ecorn = new ShapedRecipe(pl.popcornkey, popcorn);

        ecorn.shape("*&");
        ecorn.setIngredient('*', Material.MELON_SEEDS);
        ecorn.setIngredient('&', Material.BUCKET);

        pl.getServer().addRecipe(ecorn);
    }

    public static void cakebomb(SpicyMeat pl) {
        ItemStack cake = pl.hdapi.getItemHead("3286");
        ItemMeta cs = cake.getItemMeta();
        cs.setDisplayName(Chat.clr("&6Car Bomb &eCake"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Chat.clr("&bBuild battle car bomb"));
        cs.setLore(lore);
        cake.setItemMeta(cs);

        ShapedRecipe ecorn = new ShapedRecipe(pl.cakekey, cake);

        ecorn.shape("*&");
        ecorn.setIngredient('*', Material.IRON_INGOT);
        ecorn.setIngredient('&', Material.CAKE);

        pl.getServer().addRecipe(ecorn);
    }
}
