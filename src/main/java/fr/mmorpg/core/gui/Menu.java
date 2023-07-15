package fr.mmorpg.core.gui;


import fr.mmorpg.core.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;

public abstract class Menu {


    //public abstract int id; < ID menu a set
    private String title;
    private Integer size;
    private Integer rows;
    private Inventory inv;
    private HashMap<Integer,MenuItem> items = new HashMap<>();



    public Menu(String title,Integer size){
        setMenuTitle(Strings.format(title));
        setMenuSize(size);

        if(getMenuSize() < 9){
            setMenuSize(size*9);
            setMenuRows(size);
        }

        setMenuInventory(Bukkit.createInventory(null, getMenuSize(), getMenuTitle()));
    }

    public void addItems(MenuItem item,int slot){
        ItemStack i = item.getItemStack();
        ItemMeta meta = i.getItemMeta();

        if(item.getItemLore()!=null)meta.setLore(Strings.format(item.getItemLoreArray()));
        meta.setDisplayName(Strings.format(item.getItemName()));

        if(item.getItemIsHead()==true){
            SkullMeta skullmeta = (SkullMeta)i.getItemMeta();
            skullmeta.setOwner(item.getOwnerSkull());
            if(item.getItemLore()!=null)skullmeta.setLore(Strings.format(item.getItemLoreArray()));
            skullmeta.setDisplayName(Strings.format(item.getItemName()));

            i.setItemMeta(skullmeta);
        }else i.setItemMeta(meta);
        setItemInventory(slot, i);
        this.setItemMap(item, slot);
    }

    public void setMenuTitle(String title){  this.title=title;  }


    public String getMenuTitle(){ return this.title;  }

    public void setMenuSize(Integer size){ this.size=size; }

    public Integer getMenuSize(){ return this.size; }

    public void openInventory(Player p){
        updateInventory(p);
        p.openInventory(getMenuInventory());
    }


    public void setMenuRows(Integer rows){ this.rows=rows; }

    public Integer getMenuRows(){ return this.rows; }

    public void setItemMap(MenuItem item,Integer slot){
        getItems().put(slot,item);
    }


    public void setMenuInventory(Inventory inv){ this.inv=inv; }

    public Inventory getMenuInventory(){ return this.inv; }

    public void setItemInventory(int slot, ItemStack stack){
        getMenuInventory().setItem(slot,stack);
    }


    public abstract void updateInventory(Player p);

    public HashMap<Integer,MenuItem> getItems(){
        return this.items;
    }

    public MenuItem getMenuItems(Integer id){
        return this.getItems().get(id);
    }

    public String getInventoryName(Inventory inv){
        return this.title;
    }

    public boolean getMenuItemContainsKey(Integer id){
        return this.getItems().containsKey(id);
    }


    @EventHandler
    public void onClickInventory(InventoryClickEvent e){
        Player player = (Player)e.getWhoClicked();


        if(getInventoryName(e.getInventory()).equals(getMenuTitle())){
            MenuItem m = getMenuItems(e.getRawSlot());

            if(!getMenuItemContainsKey(e.getRawSlot()))return;

            if(e.getClick().isLeftClick())m.onLeftClick(e);
            if(e.getClick().isRightClick())m.onRightClick(e);

            player.sendMessage("ID : "+e.getRawSlot());
            e.setCancelled(true);
     }
    }



}
