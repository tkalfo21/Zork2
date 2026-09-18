package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandWordsTest {

    @Test
    public void testGoCommand() {
        CommandWords commands = new CommandWords();
        assertTrue(commands.isCommand("go"));
    }

    @Test
    public void testBackCommand() {
        CommandWords commands = new CommandWords();
        assertTrue(commands.isCommand("back"));
    }

    @Test
    public void testMapCommand() {
        CommandWords commands = new CommandWords();
        assertTrue(commands.isCommand("map"));
    }

    @Test
    public void testTakeCommand() {
        CommandWords commands = new CommandWords();
        assertTrue(commands.isCommand("take"));
    }

    @Test
    public void testDropCommand() {
        CommandWords commands = new CommandWords();
        assertTrue(commands.isCommand("drop"));
    }

    @Test
    public void testInvalidCommand() {
        CommandWords commands = new CommandWords();
        assertFalse(commands.isCommand("hello"));
    }
}