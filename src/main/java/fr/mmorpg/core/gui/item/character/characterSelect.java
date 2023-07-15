package fr.mmorpg.core.gui.item.character;

import fr.mmorpg.core.gui.MenuItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class characterSelect extends MenuItem {
    public characterSelect(String name, String[] lore) {
        super(name, new ItemStack(Material.PAPER), lore);
    }

    @Override
    public void onLeftClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();


    }

    @Override
    public void onRightClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
    }
}
