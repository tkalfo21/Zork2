package ch.bbw.zork;

import org.junit.Test;
import static org.junit.Assert.*;

/** Testet die Gewichtsgrenze und das Aufnehmen/Ablegen. */
public class InventoryTest {
    @Test public void testInitiallyEmpty() {
        assertTrue(new Inventory(3.0).description().contains("leer"));
    }
    @Test public void testInitiallyZeroWeight() {
        assertEquals(0.0, new Inventory(3.0).getTotalWeight(), 0.001);
    }
    @Test public void testTakeRemovesFromRoom() {
        Room room = new Room("Test");
        room.addItem(new Item("book", 0.5));
        Inventory inv = new Inventory(3.0);
        inv.take(room, "book");
        assertNull(room.getItem("book"));
    }
    @Test public void testWeightAfterTake() {
        Room room = new Room("Test");
        room.addItem(new Item("book", 0.5));
        Inventory inv = new Inventory(3.0);
        inv.take(room, "book");
        assertEquals(0.5, inv.getTotalWeight(), 0.001);
    }
    @Test public void testHeavyItemStaysInRoom() {
        Room room = new Room("Test");
        Item heavy = new Item("computer", 4.0);
        room.addItem(heavy);
        Inventory inv = new Inventory(3.0);
        assertEquals("Der Gegenstand ist zu schwer.", inv.take(room, "computer"));
        assertSame(heavy, room.getItem("computer"));
    }
    @Test public void testMultipleItemsAtLimit() {
        Room room = new Room("Test");
        room.addItem(new Item("laptop", 2.0));
        room.addItem(new Item("bottle", 1.0));
        room.addItem(new Item("book", 0.5));
        Inventory inv = new Inventory(3.0);
        inv.take(room, "laptop");
        inv.take(room, "bottle");
        assertEquals("Der Gegenstand ist zu schwer.", inv.take(room, "book"));
        assertEquals(3.0, inv.getTotalWeight(), 0.001);
    }
    @Test public void testDropReturnsItemToRoom() {
        Room room = new Room("Test");
        room.addItem(new Item("key", 0.2));
        Inventory inv = new Inventory(3.0);
        inv.take(room, "key");
        inv.drop(room, "key");
        assertNotNull(room.getItem("key"));
        assertEquals(0.0, inv.getTotalWeight(), 0.001);
    }
    @Test public void testDropMissingItem() {
        assertEquals("Du hast diesen Gegenstand nicht.",
                     new Inventory(3.0).drop(new Room("Test"), "key"));
    }
}
