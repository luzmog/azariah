package fr.mmorpg.core.gui.menu.character;

import fr.mmorpg.core.Core;
import fr.mmorpg.core.gui.Menu;
import fr.mmorpg.core.gui.item.character.characterSelect;
import fr.mmorpg.core.manager.ProfilManager;
import fr.mmorpg.core.model.Character;
import fr.mmorpg.core.model.Profil;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class characterMenu extends Menu {


    private Core core;
    private ProfilManager profilManager;
    public characterMenu(Core core) {
        super("Character", 5);
        this.core =core;
        this.profilManager = core.getDatabase().getProfilManager();
    }

    @Override
    public void updateInventory(Player p) {
        Profil profil = profilManager.getProfil(p.getUniqueId());

        for(Character character : profil.getCharacters()){
            String[] info = {
                    "level => "+character.getLevel(),
                    "class => "+character.getClass().getName(),
                    "race => "+character.getRace().getName()
            };


            addItems(new characterSelect(character.getName()+"",info), 2);
        }

    }
}
