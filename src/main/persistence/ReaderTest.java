package persistence;

import model.Item;
import model.Player;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static persistence.Reader.parseSave;
import static persistence.Reader.readPlayer;
import static persistence.Writer.savePlayer;

public class ReaderTest {

    private Player player;

    @BeforeEach
    void setup() throws IOException {
        Item item1 = new Item(0, 0, "Sin of Envy", true);
        player = new Player();
        player.setDmg(235);
        player.setBalance(12363);
        player.setCs(3);
        player.setAd(43);
        player.getInv().add(item1);
        savePlayer(player, "test123");
    }

    @Test
    void testParseSave() {
        try {
            parseSave(readPlayer("./data/test123.json"));
            assertEquals(235, player.getDmg());
            assertEquals(12363, player.getBalance());
            assertEquals(3, player.getCs());
            assertEquals(43, player.getAd());
            assertEquals(1, player.getInv().size());

        } catch (IOException | ParseException e) {
            fail("should not have run");
        }
    }

    @Test
    void testIOException() throws ParseException {
        try {
            parseSave(readPlayer("./data/save123123123.json"));
        } catch (IOException e) {
           // expected
        }
    }
}
