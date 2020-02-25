package model;

// items that can be bought

public class Item {
    private int cost;
    private int stats;
    private String name;
    private boolean type;

    //REQUIRES: cost and stats should be >= 0
    //EFFECTS: Item has given cost and stats, and is not closed

    public Item(int cost, int stats, String name, boolean type) {
        this.cost = cost;
        this.stats = stats;
        this.name = name;
        this.type = type;
        // type true = item that buffs player
        // type false = champion that gives passive damage
    }

    //EFFECTS: returns cost of item
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns stats of item
    public int getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

    public boolean getType() {
        return type;
    }
}

