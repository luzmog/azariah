package fr.mmorpg.core.model;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemData {
    Material type;
    double durability;
    List<String> lore;

    public ItemData(Material type, List<String> lore) {
        this.type = type;
        this.lore = lore;


        lore = new ArrayList<>();

        lore.add("Item du mage tout puissant !");
        lore.add("Force 30");
        lore.add("Int 50");
    }

    public List<CharStats> listCharacteristics() {
        List<CharStats> list = new ArrayList<>();

        for (String line : lore){

            CharStats deducted = CharStats.deductFromString(line);

            if (deducted != null)
                list.add(deducted);
        }

        return list;
    }

}
// For{ce}
// Int : Intéli
public enum Characteritics {
    FORCE,
    Int,
    Rec,
    Sag,
    luc,
    dex;
}

public class CharStats{
    Characteritics characteritic;
    Integer amount;

    public CharStats(Characteritics characteritics, int amount){
        this.characteritic = characteritics;
        this.amount = amount;
    }

    // Force, 30
    public static CharStats deductFromString(String from){
        // from = "Force 30"
        String[] splitData = from.split(" ");

        if (splitData.length < 2) return null;

        Characteritics characteritics = Characteritics.valueOf(splitData [0]);
        int amount = java.lang.Integer.parseInt(splitData[1]);

        return new CharStats(characteritics, amount);
    }
}
