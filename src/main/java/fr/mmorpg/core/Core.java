package fr.mmorpg.core;

import com.mongodb.client.MongoDatabase;
import fr.mmorpg.core.event.DataSyncEvent;
import fr.mmorpg.core.event.MenuEvent;
import fr.mmorpg.core.gui.MenuManager;
import fr.mmorpg.core.manager.DatabaseManager;
import fr.mmorpg.core.manager.ProfilManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private DatabaseManager database;
    private MenuManager menuManager;
    public static Core instance;

    public void onEnable(){
        instance = this; //Instance get

        //Load Table
        database = new DatabaseManager("mmo","1234Qwer","127.0.0.1",27017,"mmorpg");
        this.menuManager = new MenuManager();

        //Load Event Table
        Bukkit.getPluginManager().registerEvents(new DataSyncEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MenuEvent(), this);

        // Load Data class
        this.menuManager.onLoadMenu();
    }

    public void onDisable(){
        this.database.close();
    }

    public DatabaseManager getDatabase() {
        return this.database;
    }

    public MenuManager getMenuManager() {
        return this.menuManager;
    }

    public static Core getInstance(){
        return instance;
    }
}
