package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void testShortDescription() {
        Room room = new Room("Test room");
        assertEquals("Test room", room.shortDescription());
    }

    @Test
    public void testWinnerRoomDefault() {
        Room room = new Room("Test room");
        assertFalse(room.isWinnerRoom());
    }

    @Test
    public void testWinnerRoom() {
        Room room = new Room("Test room");
        room.setWinnerRoom(true);
        assertTrue(room.isWinnerRoom());
    }

    @Test
    public void testNextRoom() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");

        room1.setExits(room2, null, null, null);

        assertEquals(room2, room1.nextRoom("north"));
    }

    @Test
    public void testAddItem() {
        Room room = new Room("Test room");
        Item item = new Item("book", 0.5);

        room.addItem(item);

        assertEquals(item, room.getItem("book"));
    }

    @Test
    public void testRemoveItem() {
        Room room = new Room("Test room");
        Item item = new Item("book", 0.5);

        room.addItem(item);
        room.removeItem(item);

        assertNull(room.getItem("book"));
    }

    @Test
    public void testUnknownItem() {
        Room room = new Room("Test room");

        assertNull(room.getItem("computer"));
    }
}