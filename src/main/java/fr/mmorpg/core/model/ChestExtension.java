package fr.mmorpg.core.model;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ChestExtension {

    private int slot; // action
    private boolean buyCheest = false;

    Map<Integer, ItemData> items;

    private void addItems(PlayerInventory inv) {


        for (int slot : items.keySet()){

            inv.setItem(slot, buildItemFromData(items.get(slot)));

        }
    }

    private ItemStack buildItemFromData(ItemData data) {

        ItemStack item = new ItemStack(data.type); //épée en diamand
        ItemMeta meta = item.getItemMeta();


        item.setItemMeta(meta);
    }
}

