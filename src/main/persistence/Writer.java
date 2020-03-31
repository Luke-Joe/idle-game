package persistence;


import model.Item;
import model.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Writes save file
// Citation: https://stackabuse.com/reading-and-writing-json-in-java/

public class Writer {

    //EFFECTS: saves player data to a JSON file
    public static void savePlayer(Player player, String input) throws IOException {
        JSONObject save = new JSONObject();
        save.put("balance", player.getBalance());
        save.put("cs", player.getCs());
        save.put("dmg", player.getDmg());
        save.put("ad", player.getAd());

        JSONArray inventory = new JSONArray();
        for (Item i : player.getInv()) {
            JSONObject item = new JSONObject();
            item.put("name", i.getName());
            item.put("type", i.getType());
            item.put("cost", i.getCost());
            item.put("stats", i.getStats());
            inventory.add(item);
        }


        save.put("inventory", inventory);
        Files.write(Paths.get("./data/save.json"), save.toJSONString().getBytes());


    }

}
