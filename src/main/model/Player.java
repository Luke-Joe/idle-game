package model;

import java.util.ArrayList;
import java.util.List;

// The player and their stats
public class Player {
    private  List<Item> inv;
    private int balance;
    private  int ad;
    private  int dmg;
    private int cs;

    public static final int MAX_SIZE = 6;

    public Player() {
        inv = new ArrayList<>();
        balance = 1000;
        ad = 10;
        dmg = 0;
        cs = 0;
    }

    //MODIFIES: this
    //EFFECTS: if the inventory is not full and there is enough money to purchase, adds item to inventory,
    //         deducts cost of item from balance, applies stats to user, and returns true

    public Boolean buyItem(Item item) {
        if (balance < item.getCost()) {
            return false;
            // System.out.println("You are too poor to purchase this item");
        } else if (!item.getType()) {
            balance = balance - item.getCost();
            dmg = dmg + item.getStats();
            return true;
        } else if (inv.size() >= MAX_SIZE) {
            return false;
            //System.out.println("Your inventory is full!");
        }
        balance = balance - item.getCost();
        inv.add(item);
        ad = ad + item.getStats();


        return true;
        // System.out.println("You have purchased " item.getName() " Your remaining balance is" + balance"!");
    }

    //REQUIRES: must have at least one item in inventory
    //MODIFIES: this
    //EFFECTS: removes item from inventory
    public Boolean sellItem(Item item) {
        if (inv.contains(item)) {
            inv.remove(item);
            balance = balance + item.getCost();
            ad = ad - item.getStats();
            return true;
        }

        return false;

    }

    public void onKill() {
        balance = balance + ((cs / 10) + ad);
        cs = cs + 1;
    }

    public String displayItems() {
        String listItem;
        listItem = "Inventory: \n";

        for (Item i : inv) {
            listItem += "   - " + i.getName() + " [" + i.getStats() + "]\n";
        }

        return listItem;
    }

    //EFFECTS: returns the users balance
    public  int getBalance() {
        return balance;
    }

    //EFFECTS: returns the users attack damage
    public int getAd() {
        return ad;
    }

    public int getSize() {
        return inv.size();
    }

    public int getCs() {
        return cs;
    }

    public int getDmg() {
        return dmg;
    }

    public List<Item> getInv() {
        return inv;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }



}
