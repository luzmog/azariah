package fr.mmorpg.core.event;

import com.google.gson.Gson;
import fr.mmorpg.core.Core;
import fr.mmorpg.core.controller.ProfilController;
import fr.mmorpg.core.model.Character;
import fr.mmorpg.core.data.GameRole;
import fr.mmorpg.core.model.ChestExtension;
import fr.mmorpg.core.model.Profil;
import fr.mmorpg.core.view.ProfilView;


import net.kyori.adventure.text.format.NamedTextColor;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bson.Document;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Indexes.text;

public class DataSyncEvent implements Listener {

    Core core;
    public DataSyncEvent(Core core){
        this.core = core;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = (Player) e.getPlayer();


        // Create a view to write profil details to console
        Profil profil = core.getDatabase().getProfilManager().loadProfil(p.getUniqueId());

        TextComponent message1 = new TextComponent("Load Account "+profil.getUuid()+" "+profil.getCharacters().size()+" character");
        message1.setColor(ChatColor.GREEN);
        p.sendMessage(message1);


        Character character = profil.getLoadCharacter();

        giveChestsItems(p, null);
    }

    public void giveChestsItems(Player player, List<ChestExtension> chests){

        for (int i = 0; i < chests.size(); i++){ // i = slot
            ChestExtension chest = chests.get(i);

            int slotDeducted = 9 - i; // TODO


        }

    }


    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Player killer = entity.getKiller();

        if (killer != null) {
            ProfilView view = new ProfilView();
            Profil model = core.getDatabase().getProfilManager().getProfil(killer.getUniqueId());
            ProfilController controller = new ProfilController(model, view);
            controller.getProfilCharacters().get(0).gainExp(5000);
            Character game = controller.getProfilCharacters().get(0);
            TextComponent message = new TextComponent(game.getLevel()+" level exp requis: "+game.getExp()+" / "+game.getExpToNextLevel());
            message.setColor(ChatColor.GREEN);
            killer.sendMessage(message);
            killer.sendMessage("You killed a " + entity.getType().name() + "!");
        }
    }

    @EventHandler
    public void onSendMessage(AsyncPlayerChatEvent event){
        Profil model = core.getDatabase().getProfilManager().getProfil(event.getPlayer().getUniqueId());

        String message = event.getMessage();
        String modifiedMessage = model.getRole().getPrefix()+ message;  // modify the message as you want
       // Component nameToDisplay = Component.text(model.getRole().getPrefix(), NamedTextColor.RED)
      //          .append(Component.text(model.getCharacters().get(0).getName()));
       // event.getPlayer().displayName(nameToDisplay);
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e){
        Profil profil = core.getDatabase().getProfilManager().getProfil(e.getPlayer().getUniqueId());
        core.getDatabase().getProfilManager().exitGame(profil);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerItemHeld (PlayerItemHeldEvent e){
        Player p = e.getPlayer();
        ItemStack item = p.getItemInHand();
        int newSlot = e.getNewSlot();
        int prevSlot = +e.getPreviousSlot();

        // player has effect on prevSlot -> disable

        switch (newSlot) {
            case 1: p.
        }
        //appuie sur 1 > 9
        p.getInventory().setHeldItemSlot(9);

//appuyer sur 1 fait action appuyer sur 2 fait telle
        p.sendMessage("Test = "+e.getPreviousSlot()+" | "+e.getNewSlot());
    }
}

