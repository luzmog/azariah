package fr.mmorpg.core.gui;

import fr.mmorpg.core.Core;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alain on 2016-12-22.
 */
public abstract class MenuItem {

    private String name;
    private String owner;
    private boolean isHead;
    private String[] lore;
    private ItemStack item;

    public MenuItem(String name, ItemStack item, String[] lore) {
        setItemName(name);
        //setItemIsHead(isHead);
        setItemLore(lore);
        setItemStack(item);
    }

    public MenuItem(String name, String owner, ItemStack item, String[] lore) {
        setItemName(name);
        setItemIsHead(true);
        setItemLore(lore);
        setOwnerSkull(owner);
        setItemStack(item);
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public String getItemName() {
        return this.name;
    }

    public void setOwnerSkull(String owner) {
        this.owner = owner;
    }

    public String getOwnerSkull() {
        return this.owner;
    }

    public void setItemIsHead(boolean isHead) {
        this.isHead = isHead;
    }

    public boolean getItemIsHead() {
        return this.isHead;
    }

    public void setItemStack(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItemStack() {
        return this.item;
    }

    public void setItemLore(String[] lore) {
        this.lore = lore;
    }

    public String[] getItemLore() {
        return this.lore;
    }

    public static Core getMain() {
        return Core.getInstance();
    }



    public List<String> getItemLoreArray() {
        if (getItemLore() != null) {
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(getItemLore()));
            return list;
        } else return null;
    }



    public abstract void onLeftClick(InventoryClickEvent e);

    public abstract void onRightClick(InventoryClickEvent e);
}
