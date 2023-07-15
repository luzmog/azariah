package fr.mmorpg.core.data;

public enum GameRole {

    GAME_MASTER(1, "[GM] "),
    GAME_SAGE(2, "[GS] "),
    NONE(3,"");

    private final int id;
    private final String prefix;

    GameRole(int id, String prefix) {
        this.id = id;
        this.prefix = prefix;
    }

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }
}