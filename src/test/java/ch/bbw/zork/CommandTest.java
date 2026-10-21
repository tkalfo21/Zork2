package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void testCommandWord() {
        Command command = new Command("go");
        assertEquals("go", command.getCommandWord());
    }

    @Test
    public void testSecondWord() {
        Command command = new Command("go", "north");
        assertEquals("north", command.getSecondWord());
    }

    @Test
    public void testHasSecondWord() {
        Command command = new Command("go", "north");
        assertTrue(command.hasSecondWord());
    }

    @Test
    public void testHasNoSecondWord() {
        Command command = new Command("help");
        assertFalse(command.hasSecondWord());
    }

    @Test
    public void testUnknownCommand() {
        Command command = new Command(null);
        assertTrue(command.isUnknown());
    }

    @Test
    public void testKnownCommand() {
        Command command = new Command("go");
        assertFalse(command.isUnknown());
    }
}