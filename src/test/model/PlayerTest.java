package model;

import exceptions.CannotBuyException;
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

    public void testGettersSetters(){

//        assertEquals(MAX_SIZE, player.getSize());
//        assertEquals(1000 - 15, player.getBalance());
//        assertEquals(10 + 15, player.getAd());
//        assertFalse(player.buyItem(new Item(500, 5, "sin of envy", true)));
//        assertEquals(985, player.getBalance());
//        assertEquals(25, player.getAd());
//        assertFalse(player.buyItem(new Item(10000, 5, "eerie warning", true)));
//        assertEquals(985, player.getBalance());
//        assertEquals(25, player.getAd());
        assertEquals(0, player.getDmg());
        assertEquals(0, player.getCs());
        assertEquals(0, player.getInv().size());
        player.setBalance(123123);
        assertEquals(123123, player.getBalance());
        player.setCs(123);
        assertEquals(123 , player.getCs());
        player.setAd(45);
        assertEquals(45, player.getAd());
        player.setDmg(23);
        assertEquals(23, player.getDmg());
        assertEquals(0, player.getSize());




    }

//    @Test
//
//    public void testEmptyInventory(){
//
//        assertEquals(0, player.getSize());
//        assertTrue(player.buyItem(new Item(500, 5, "sin of envy", true)));
//        assertEquals(500, player.getBalance());
//        assertEquals(15, player.getAd());
//        assertFalse(player.buyItem(new Item (10000, 5, "bloodsport", true)));
//        assertEquals(500, player.getBalance());
//        assertEquals(15, player.getAd());
//        assertFalse(player.buyItem((new Item (6300, 5, "Lucas", false))));
//        assertTrue(player.buyItem((new Item (1, 100, "Lucas", false))));
//        assertEquals(100, player.getDmg());
//        assertEquals(0, player.getCs());
//
//
//
//    }

//    @Test
//
//    public void testSomeFilled(){
//        Item item1;
//        item1 = new Item(500, 50, "Dusk blade", true);
//
//        player.buyItem(item1);
//        assertEquals(500, player.getBalance());
//        assertFalse(player.sellItem(new Item(1, 1, "test", true)));
//        assertTrue(player.sellItem(item1));
//        assertFalse(player.buyItem((new Item (6300, 5, "Lucas", false))));
//        assertTrue(player.buyItem((new Item (1, 100, "Lucas", false))));
//        assertEquals(100, player.getDmg());
//        assertEquals(0, player.getCs());
//    }

    //TESTS REDONE BELOW

    @Test
    void testOnKill(){
        player.onKill();
        assertEquals(1, player.getCs());
        assertEquals(1010, player.getBalance());
    }

    @Test
    void testDisplayItems(){
        Item item1 = new Item(500, 50, "Dusk blade", true);
        Item item2 = new Item(500, 100, "Hi", true);

        try {
            player.buyItem(item1);
            player.buyItem(item2);
        } catch (CannotBuyException e) {
            fail("Should not have been thrown");
        }

        assertEquals("Inventory: \n" + "   - Dusk blade [50]\n   - Hi [100]\n" , player.displayItems());

    }

    @Test
    void testDisplayNoItems() {
        assertEquals("Inventory: \n", player.displayItems());
    }

    @Test
    void buyItemTooPoor() {
        try {
            player.buyItem(new Item(10000, 10, "Item1", true));
        } catch(CannotBuyException e) {
            //should be caught
        }
    }

    @Test
    void buyItemInvFull() {

        try {
            for (int i=0; i < player.MAX_SIZE; i++) {
                player.buyItem(new Item(1, 1, "Filler", true));
            }
            player.buyItem(new Item(10, 10, "Item1", true));
        } catch (CannotBuyException e) {
            //should be caught
        }
    }

    @Test
    void buyItemGood() {

        try {
            player.buyItem(new Item(100, 10, "Item1", true));
        } catch (CannotBuyException e) {
            fail("Exception should not have been thrown");
        }
    }






}