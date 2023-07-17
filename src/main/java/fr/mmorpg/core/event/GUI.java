package fr.mmorpg.core.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;

public abstract class GUI {

    public final String titleTranslateKey;
    public final int size;

    public GUI(String titleTranslateKey, int size){
        this.titleTranslateKey = titleTranslateKey;
        this.size = size;


    }

    /**
     * Systeme de chat configurable par le joueur
     *
     * /g /guild => guild
     * /c /commerce => Commerce
     * /global => all
     * /
     */

    /**
     *
     * @param inv
     * @param locale lang of the player
     */
    abstract void applyItems(Inventory inv);

    abstract void onClick(InventoryClickEvent event);

    abstract void onRightClick(Player player, ItemStack item);

    abstract void onLeftCLick(Player player, ItemStack item);

    void open(Player player){
        Inventory inv = Bukkit.createInventory(null, size, titleTranslateKey);

        applyItems(inv /*, lang */);

        player.openInventory(inv);


    }
}
