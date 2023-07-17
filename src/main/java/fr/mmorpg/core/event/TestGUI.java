package fr.mmorpg.core.event;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGUI extends GUI {
    public TestGUI() {
        super("gui.test.title", 54);
    }

    @Override
    void applyItems(Inventory inv) {
        // inv.setItem(0,);
    }

    @Override
    void onClick(InventoryClickEvent event) {

    }

    @Override
    void onRightClick(Player player, ItemStack item) {

    }

    @Override
    void onLeftCLick(Player player, ItemStack item) {

    }
}
