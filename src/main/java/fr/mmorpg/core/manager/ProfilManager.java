package fr.mmorpg.core.manager;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import fr.mmorpg.core.model.Profil;
import org.bson.Document;

import java.util.*;

public class ProfilManager {
    private final Gson gson;
    // Storing the Profil objects in memory with a HashMap
    private Map<UUID, Profil> profilStore = new HashMap<>();

    private final MongoCollection<Document> collection;

    public ProfilManager(MongoDatabase database) {
        this.collection = database.getCollection("profiles");
        this.gson = new Gson();
        this.profilStore = new HashMap<>();
    }

    // Save a Profil
    public void saveProfil(Profil profil) {
       if (profilExists(profil.getUuid())){
           Document existingDoc = collection.find(Filters.eq("uuid", profil.getUuid().toString())).first();
           profilStore.put(profil.getUuid(), profil);

           // Check if profile already exists in database
           if (existingDoc != null) {
               // If profile already exists, you can choose not to save it again
               // Or you can choose to update the existing profile with the new information
               return;
           }

           String json = gson.toJson(profil);
           Document doc = Document.parse(json);
           collection.replaceOne(Filters.eq("uuid", profil.getUuid().toString()), doc, new ReplaceOptions().upsert(true));
           deleteProfil(profil.getUuid());
       }
    }

    public void exitGame(Profil profil){
        profil.unLoadCharacter();
        saveProfil(profil);
    }
    public Profil loadProfil(UUID uuid) {
        // Check if profile is already loaded
        if (profilExists(uuid)) {
            return getProfil(uuid);
        }

        Document doc = collection.find(Filters.eq("uuid", uuid.toString())).first();
        if (doc == null) {
            // If no profile is found, create a new profile
            Profil profil = new Profil(uuid, new Date(), new ArrayList<>());
            // Save the new profile
            saveProfil(profil);
            // Store loaded profile in memory
            profilStore.put(uuid, profil);
            return profil;  // Return the newly created profile
        }

        String json = doc.toJson();
        Profil profil = gson.fromJson(json, Profil.class);

        // Store loaded profile in memory
        profilStore.put(uuid, profil);

        return profil;
    }

    // Retrieve a Profil by UUID
    public Profil getProfil(UUID uuid) {
        return profilStore.get(uuid);
    }

    // Update a Profil
    public void updateProfil(Profil profil) {
        saveProfil(profil);
    }

    // Delete a Profil
    public void deleteProfil(UUID uuid) {
        profilStore.remove(uuid);
    }

    // Check if a Profil exists
    public boolean profilExists(UUID uuid) {
        return profilStore.containsKey(uuid);
    }

}
