package fr.mmorpg.core.gui;





import fr.mmorpg.core.gui.menu.character.characterMenu;

import java.util.HashMap;


public class MenuManager implements MenuHandler {

    public HashMap<Integer,Menu> menu = new HashMap<>(); // HashMap Constructor

    private int id = -1;

    @Override
    public void onLoadMenu() {
        characterMenu.id = registerNewMenu(new characterMenu());
    }


    @Override
    public Integer registerNewMenu(Menu menu) {
        id++;
        getMenu().put(id, menu);
        return id;
    }


    public Menu getMenuId(Integer id) {
       return getMenu().get(id);
    }

    public HashMap<Integer,Menu> getMenu(){
        return this.menu;
    }


}

