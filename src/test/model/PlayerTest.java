package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Player.MAX_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach

    public void setup(){
        player = new Player();

    }

    @Test

    public void testFullInventory(){
        for (int i = 0; i < MAX_SIZE; i++) {
            player.buyItem(new Item(i, i, "item" + i, true));
        }
        assertEquals(MAX_SIZE, player.getSize());
        assertEquals(1000 - 15, player.getBalance());
        assertEquals(10 + 15, player.getAd());
        assertFalse(player.buyItem(new Item(500, 5, "sin of envy", true)));
        assertEquals(985, player.getBalance());
        assertEquals(25, player.getAd());
        assertFalse(player.buyItem(new Item(10000, 5, "eerie warning", true)));
        assertEquals(985, player.getBalance());
        assertEquals(25, player.getAd());
        assertEquals(0, player.getDmg());
        assertEquals(0, player.getCs());



    }

    @Test

    public void testEmptyInventory(){

        assertEquals(0, player.getSize());
        assertTrue(player.buyItem(new Item(500, 5, "sin of envy", true)));
        assertEquals(500, player.getBalance());
        assertEquals(15, player.getAd());
        assertFalse(player.buyItem(new Item (10000, 5, "bloodsport", true)));
        assertEquals(500, player.getBalance());
        assertEquals(15, player.getAd());
        assertFalse(player.buyItem((new Item (6300, 5, "Lucas", false))));
        assertTrue(player.buyItem((new Item (1, 100, "Lucas", false))));
        assertEquals(100, player.getDmg());
        assertEquals(0, player.getCs());



    }

    @Test

    public void testSomeFilled(){
        Item item1;
        item1 = new Item(500, 50, "Dusk blade", true);

        player.buyItem(item1);
        assertEquals(500, player.getBalance());
        assertFalse(player.sellItem(new Item(1, 1, "test", true)));
        assertTrue(player.sellItem(item1));
        assertFalse(player.buyItem((new Item (6300, 5, "Lucas", false))));
        assertTrue(player.buyItem((new Item (1, 100, "Lucas", false))));
        assertEquals(100, player.getDmg());
        assertEquals(0, player.getCs());
    }






}