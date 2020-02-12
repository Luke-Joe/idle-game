package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemTest {

    private Item item;


    @Test
    public void testGenericItem() {
        item = new Item(1000, 60, "Sin of Envy", true);
        assertEquals(1000, item.getCost());
        assertEquals(60, item.getStats());
        assertEquals("Sin of Envy", item.getName());
        assertTrue(item.getType());

    }
}
