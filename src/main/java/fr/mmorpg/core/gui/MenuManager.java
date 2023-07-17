package fr.mmorpg.core.gui;





import fr.mmorpg.core.gui.menu.character.characterMenu;

import java.util.HashMap;


public class MenuManager implements MenuHandler {






    @Override
    public Integer registerNewMenu(Menu menu) {
        id++;
        menu.put(id, menu);
        return id;
    }


    public Menu getMenuId(Integer id) {
       return getMenu().get(id);
    }

    public HashMap<Integer,Menu> getMenu(){
        return this.menu;
    }


}

