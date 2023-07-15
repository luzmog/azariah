package fr.mmorpg.core.manager;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private ProfilManager profilManager;
    public DatabaseManager(String username, String password, String host, int port, String dbName) {
        String connectionString = String.format("mongodb://%s:%s@%s:%d/%s", username, password, host, port, dbName);
        this.mongoClient = MongoClients.create(connectionString);
        this.database = mongoClient.getDatabase(dbName);
       // database.createCollection("profiles");
        this.profilManager = new ProfilManager(this.database);
    }


    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    // Add more methods to get other DAOs as needed...

    public ProfilManager getProfilManager() {
        return profilManager;
    }

    public void close() {
        mongoClient.close();
    }
}
