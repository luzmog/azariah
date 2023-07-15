package fr.mmorpg.core.model.classe;

import fr.mmorpg.core.model.RPGClass;
import fr.mmorpg.core.model.skill.mage.exorbit;

import java.util.Arrays;

public class MageClass extends RPGClass {
    public MageClass() {
        super("Mage", Arrays.asList(
                new exorbit()
        ));
    }


}
