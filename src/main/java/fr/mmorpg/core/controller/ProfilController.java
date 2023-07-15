package fr.mmorpg.core.controller;

import fr.mmorpg.core.model.Character;
import fr.mmorpg.core.data.GameRole;
import fr.mmorpg.core.model.Profil;
import fr.mmorpg.core.view.ProfilView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ProfilController {
    private Profil profil;
    private ProfilView view;

    public ProfilController(Profil model, ProfilView view){
        this.profil = model;
        this.view = view;
    }


    public UUID getProfilUuid(){
        return profil.getUuid();
    }

    public Date getProfilDate(){
        return profil.getDate();
    }

    public void setProfilCharacters(List<Character> characters){
        profil.setCharacters(characters);
    }

   public void setProfilRole(GameRole role){
        this.profil.setRole(role);
   }
    public List<Character> getProfilCharacters(){
        return profil.getCharacters();
    }

    public void updateView(){
       // view.printProfilDetails(profil.getUuid().toString(), profil.getDate().toString(), profil.getCharacters().toString());
    }
}
