package persistence;


import model.Item;
import model.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Reads save file
public class Reader {

    //EFFECTS: Reads file with given name
    public static JSONObject readPlayer(String filename) throws IOException, ParseException {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(reader);
    }

    //EFFECTS: Loads aspects stored inside of save and applies it to player
    public static Player parseSave(JSONObject save) {
        Player player = new Player();

        //get player balance
        int balance = ((Long) save.get("balance")).intValue();

        //get player attack damage
        int ad = ((Long) save.get("ad")).intValue();

        //get player creep score
        int cs = ((Long) save.get("cs")).intValue();

        //get player help damage
        int dmg = ((Long) save.get("dmg")).intValue();

        // get inventory
        JSONArray inventory = (JSONArray) save.get("inventory");

        for (int i = 0; i < inventory.size(); i++) {
            JSONObject item = (JSONObject) inventory.get(i);
            String name = (String) item.get("name");
            boolean type = (boolean) item.get("type");
            int cost = ((Long) item.get("cost")).intValue();
            int stats = ((Long) item.get("stats")).intValue();

            Item item1 = new Item(cost, stats, name, type);
            player.getInv().add(item1);

        }


        player.setBalance(balance);
        player.setAd(ad);
        player.setDmg(dmg);
        player.setCs(cs);

        return player;

    }
}
