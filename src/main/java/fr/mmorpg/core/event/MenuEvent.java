package fr.mmorpg.core.event;

import fr.mmorpg.core.Core;
import fr.mmorpg.core.gui.Menu;
import fr.mmorpg.core.gui.menu.character.characterMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MenuEvent implements Listener {

    Menu[] menus;

    public MenuEvent(Menu...menus){
        this.menus = menus;
    }

    public MenuEvent(characterMenu characterMenu) {
    }

    @EventHandler
    public void onClickInv(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        Menu menu = findFromArray(e.getView().getOriginalTitle());
        if (menu == null){
            return;
        }

        menu.onClickInventory(e);
    }

    private Menu findFromArray(String title) {
        for (Menu menu : menus)
            if (menu.getMenuTitle().equals(title))
                return menu;
        return null;
    }


}

