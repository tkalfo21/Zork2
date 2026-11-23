package ch.bbw.zork;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/** Testet die Kartenausgabe mit aktuellen Räumen und Gegenständen. */
public class MapPrinterTest {
    @Test public void testCurrentRoomMarked() {
        Room a = new Room("Klassenzimmer");
        assertTrue(new MapPrinter().render(Arrays.asList(a), a).contains("* Klassenzimmer <- aktueller Raum"));
    }
    @Test public void testOtherRoomNotMarked() {
        Room a = new Room("Start");
        Room b = new Room("Mensa");
        String result = new MapPrinter().render(Arrays.asList(a, b), a);
        assertTrue(result.contains("- Mensa"));
    }
    @Test public void testItemVisible() {
        Room room = new Room("Mensa");
        room.addItem(new Item("bottle", 1.0));
        assertTrue(new MapPrinter().render(Arrays.asList(room), room).contains("bottle"));
    }
    @Test public void testEmptyRoom() {
        Room room = new Room("Gang");
        assertTrue(new MapPrinter().render(Arrays.asList(room), room).contains("Gegenstände: keine"));
    }
    @Test public void testMultipleRooms() {
        Room a = new Room("Start");
        Room b = new Room("Gang");
        String result = new MapPrinter().render(Arrays.asList(a, b), a);
        assertTrue(result.contains("Start") && result.contains("Gang"));
    }
    @Test public void testMapHeading() {
        assertTrue(new MapPrinter().render(Arrays.asList(), null).startsWith("Karte:"));
    }
}
