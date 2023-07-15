package fr.mmorpg.core.model;

import org.bukkit.entity.Player;

public abstract class SkillClass {

    protected String name;
    protected int cooldown;
    protected int level;
    protected int levelmax;

    public SkillClass(String name,int level, int levelmax, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
        this.level = level;
        this.levelmax = levelmax;
    }
    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    // Définir ce qui se passe quand la compétence est utilisée
    public abstract void use(Player player);
}
