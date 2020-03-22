package persistence;

import model.Item;
import model.Player;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static persistence.Reader.parseSave;
import static persistence.Reader.readPlayer;
import static persistence.Writer.savePlayer;

public class WriterTest {
    private static final String TEST_FILE = "./data/save1.json";
    private Player player;


    @BeforeEach
    void runBefore() {
        Item item1 = new Item(0, 0, "   Sin of Envy", true);
        player = new Player();
        player.setDmg(235);
        player.setBalance(12363);
        player.setCs(3);
        player.setAd(43);
        player.getInv().add(item1);
    }

    @Test
    void testWriteSave() throws IOException {
        //Save player data to file
        savePlayer(player, "save");

        //Read back player data from file
        try {
            parseSave(readPlayer("./data/save.json"));
            assertEquals(235, player.getDmg());
            assertEquals(12363, player.getBalance());
            assertEquals(3, player.getCs());
            assertEquals(43, player.getAd());
            assertEquals(1, player.getInv().size());

        } catch (ParseException e) {
            fail("should not catch exception");
        }


    }

}
