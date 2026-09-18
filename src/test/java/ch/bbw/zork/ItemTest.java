package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testName() {
        Item item = new Item("book", 0.5);
        assertEquals("book", item.getName());
    }

    @Test
    public void testWeight() {
        Item item = new Item("book", 0.5);
        assertEquals(0.5, item.getWeight(), 0.001);
    }

    @Test
    public void testDifferentName() {
        Item item = new Item("computer", 2.0);
        assertEquals("computer", item.getName());
    }

    @Test
    public void testDifferentWeight() {
        Item item = new Item("computer", 2.0);
        assertEquals(2.0, item.getWeight(), 0.001);
    }

    @Test
    public void testToStringName() {
        Item item = new Item("book", 0.5);
        assertTrue(item.toString().contains("book"));
    }

    @Test
    public void testToStringWeight() {
        Item item = new Item("book", 0.5);
        assertTrue(item.toString().contains("0.5"));
    }
}