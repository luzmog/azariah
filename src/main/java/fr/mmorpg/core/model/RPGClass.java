package fr.mmorpg.core.model;

import java.util.List;

public class RPGClass {


    protected String name;
    protected List<SkillClass> skills;

    public RPGClass(String name, List<SkillClass> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return this.name;
    }

    public List<SkillClass> getSkills() {
        return this.skills;
    }

    // etc.
}
