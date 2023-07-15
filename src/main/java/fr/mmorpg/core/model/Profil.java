package fr.mmorpg.core.model;

import fr.mmorpg.core.data.GameRole;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Profil {

    // Propriétés privées
    private final UUID uuid;
    private final Date date;
    private GameRole role;
    private List<Character> characters;

    private Character loadCharacter;
    // Constructeur
    public Profil(UUID uuid, Date date, List<Character> characters) {
        this.uuid = uuid;
        this.date = date;
        this.characters = characters;
        this.role = GameRole.NONE;
    }

    // Getters et Setters
    public UUID getUuid() {
        return  this.uuid;
    }

    public void setRole(GameRole role) {
        this.role = role;
    }

    public GameRole getRole() {
        return this.role;
    }

    public Date getDate() {
        return  this.date;
    }

    public List<Character> getCharacters() {
        return  this.characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void addCharacters(Character character){
        this.characters.add(character);
    }

    public Character getLoadCharacter() {
        return loadCharacter;
    }
    public void unLoadCharacter(){
         loadCharacter = null;
    }
    public void setLoadCharacter(Character loadCharacter) {
        this.loadCharacter = loadCharacter;
    }
}
