package ch.bbw.zork;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import static org.junit.Assert.*;

/** Testet das Einlesen gültiger und ungültiger Spielbefehle. */
public class ParserTest {
    private Parser parser(String input) {
        return new Parser(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
    @Test public void testGoWithDirection() {
        Command cmd = parser("go north\n").getCommand();
        assertEquals("go", cmd.getCommandWord());
        assertEquals("north", cmd.getSecondWord());
    }
    @Test public void testHelp() {
        assertEquals("help", parser("help\n").getCommand().getCommandWord());
    }
    @Test public void testUnknownCommand() {
        assertTrue(parser("dance\n").getCommand().isUnknown());
    }
    @Test public void testQuit() {
        assertEquals("quit", parser("quit\n").getCommand().getCommandWord());
    }
    @Test public void testInventory() {
        assertEquals("inventory", parser("inventory\n").getCommand().getCommandWord());
    }
    @Test public void testShowCommandsContainsBack() {
        assertTrue(parser("help\n").showCommands().contains("back"));
    }
}
