package dev.floffah.spicymeat;

import dev.dbassett.skullcreator.SkullCreator;
import dev.floffah.util.chat.Colours;
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
        ms.setDisplayName(Colours.def("&cExplosive &eSteak"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Colours.def("&cEat at your own risk!"));
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
        ms.setDisplayName(Colours.def("&cShit"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Colours.def("&eEat shit and die."));
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
        cs.setDisplayName(Colours.def("&eCrack &6Cookie"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Colours.def("&4DRUGS ARE BAD"));
        cs.setLore(lore);
        cookie.setItemMeta(cs);

        ShapedRecipe ecookie = new ShapedRecipe(pl.cookiekey, cookie);

        ecookie.shape("*&");
        ecookie.setIngredient('*', Material.BONE_MEAL);
        ecookie.setIngredient('&', Material.COOKIE);

        pl.getServer().addRecipe(ecookie);
    }

    public static ItemStack getPopcornHead() {
        String b64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzM1NDdkZDU1OTE2MmVkMzU0MTFhZWM5ZjY4MzI4MTVmYjA5ZTRkOGFkNDE2YmIyMWNiNGMxYzk0N2ViYjVhIn19fQ==";
        return SkullCreator.itemFromBase64(b64);
    }

    public static void popcorn(SpicyMeat pl) {
        ItemStack popcorn = getPopcornHead();
        SkullMeta ps = (SkullMeta) popcorn.getItemMeta();
        ps.setDisplayName(Colours.def("&eExtra Salty &6Popcorn"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Colours.def("&cExtra salty more like sodium poisoning."));
        ps.setLore(lore);
        popcorn.setItemMeta(ps);

        ShapedRecipe ecorn = new ShapedRecipe(pl.popcornkey, popcorn);

        ecorn.shape("*&");
        ecorn.setIngredient('*', Material.MELON_SEEDS);
        ecorn.setIngredient('&', Material.BUCKET);

        pl.getServer().addRecipe(ecorn);
    }

    public static ItemStack getCakebombHead() {
        String b64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzNkNWUxMzg4NzYzZjcxODJhN2FhZTQxNDhhMzk1ZDVjMzM0ZjBhNjQ4ZGQ2MDU0MWE3MjEzYWM4OWRmNGEifX19";
        return SkullCreator.itemFromBase64(b64);
    }

    public static void cakebomb(SpicyMeat pl) {
        ItemStack cake = getCakebombHead();
        ItemMeta cs = cake.getItemMeta();
        cs.setDisplayName(Colours.def("&6Car Bomb &eCake"));
        ArrayList lore = new ArrayList<String>();
        lore.add(Colours.def("&bBuild battle car bomb"));
        cs.setLore(lore);
        cake.setItemMeta(cs);

        ShapedRecipe ecorn = new ShapedRecipe(pl.cakekey, cake);

        ecorn.shape("*&");
        ecorn.setIngredient('*', Material.IRON_INGOT);
        ecorn.setIngredient('&', Material.CAKE);

        pl.getServer().addRecipe(ecorn);
    }
}
