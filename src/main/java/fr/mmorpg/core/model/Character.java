package fr.mmorpg.core.model;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Character {

    private String name;
    private Integer level;
    private Integer exp;

    //private Coffre coffre;

    // Class Coffre
    // Character private list<coffre> coffres;

    List<ChestExtension> chestExtensionList;

    // 1-4
    private Integer expToNextLevel;

    private Location location;
/**    A faire sous StatistiqueClass
    private Integer heal;
    private Integer healmax;
    private Integer **/
    private RPGClass RPGClass;
    private RPGRace RPGRace;
    public Character(String name, RPGClass rpgClass, RPGRace rpgRace) {
        this.name = name;
        this.level = 1;  // Start at level 1
        this.exp = 0;  // Start with 0 experience points
        this.expToNextLevel = 1000;  // The experience needed to reach the next level
        this.RPGClass = rpgClass;
        this.RPGRace = rpgRace;


        // get from data base, if no data, :
        chestExtensionList = new ArrayList<>();


        ChestExtension test = new ChestExtension();


        //loadChest(test);
        //loadChest(test);

   }



    // Getters and Setters...

    /**
     * Gain experience.
     * If the character has enough experience points, level up and reduce the experience accordingly.
     * The experience needed to level up increases by 1000 each time.
     */
    public void gainExp(int amount) {
        this.exp += amount;

        while (this.exp >= expToNextLevel) {
            this.exp -= expToNextLevel;
            this.level++;
            this.expToNextLevel+=1525*this.level;
            System.out.println(name + " leveled up! Current level: " + level);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getExpToNextLevel() {
        return this.expToNextLevel;
    }

    public Integer getExp() {
        return this.exp;
    }

    public Integer getLevel() {
        return this.level;
    }

    public RPGRace getRace() {
        return this.RPGRace;
    }

    // Get coffre by slot
}
