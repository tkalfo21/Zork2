package ch.bbw.zork;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Hauptklasse des Zork-Spiels.
 * Verwaltet die Räume, Gegenstände, Befehle und den Spielablauf.
 */
public class Game {

	private Parser parser;
	private Room currentRoom;

	private Room klassenzimmer;
	private Room gang;
	private Room informatikraum;
	private Room mensa;
	private Room bibliothek;
	private Room eingangshalle;
	private Room ausgang;

	private ArrayList<Room> rooms;
	private Stack<Room> previousRooms;
	private Inventory inventory;
	private MapPrinter mapPrinter;

	

	/**
	 * Erstellt das Spiel, die Räume und die Gegenstände.
	 */
	public Game() {

		parser = new Parser(System.in);

		rooms = new ArrayList<>();
		previousRooms = new Stack<>();
		inventory = new Inventory(3.0);
		mapPrinter = new MapPrinter();

		// Räume erstellen
		klassenzimmer = new Room("Klassenzimmer");
		gang = new Room("Gang");
		informatikraum = new Room("Informatikraum");
		mensa = new Room("Mensa");
		bibliothek = new Room("Bibliothek");
		eingangshalle = new Room("Eingangshalle");
		ausgang = new Room("Ausgang");

		// Gewinner-Raum festlegen
		ausgang.setWinnerRoom(true);

		// Ausgänge festlegen: Norden, Osten, Süden, Westen
		klassenzimmer.setExits(null, gang, null, null);
		gang.setExits(informatikraum, bibliothek, mensa, klassenzimmer);
		informatikraum.setExits(null, null, gang, null);
		mensa.setExits(gang, null, null, null);
		bibliothek.setExits(null, eingangshalle, null, gang);
		eingangshalle.setExits(null, null, ausgang, bibliothek);
		ausgang.setExits(eingangshalle, null, null, null);

		// Räume zur Liste hinzufügen
		rooms.add(klassenzimmer);
		rooms.add(gang);
		rooms.add(informatikraum);
		rooms.add(mensa);
		rooms.add(bibliothek);
		rooms.add(eingangshalle);
		rooms.add(ausgang);

		// Gegenstände erstellen
		informatikraum.addItem(new Item("laptop", 2.0));
		mensa.addItem(new Item("bottle", 1.0));
		bibliothek.addItem(new Item("book", 0.5));
		eingangshalle.addItem(new Item("key", 0.2));

		// Start-Raum
		currentRoom = klassenzimmer;
	}

	/**
	 * Startet das Spiel und verarbeitet Befehle,
	 * bis das Spiel beendet wird.
	 */
	public void play() {

		printWelcome();

		boolean finished = false;

		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}

		System.out.println("Danke fürs Spielen. Tschüss!");
	}

	/**
	 * Gibt die Begrüssung und den aktuellen Raum aus.
	 */
	private void printWelcome() {

		System.out.println();
		System.out.println("Willkommen bei Zork!");
		System.out.println("Du wurdest nach Schulschluss in der Schule eingeschlossen.");
		System.out.println("Finde den Ausgang, um das Spiel zu gewinnen.");
		System.out.println("Gib 'help' ein, wenn du Hilfe brauchst.");
		System.out.println();
		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Verarbeitet einen eingegebenen Befehl.
	 *
	 * @param command eingegebener Befehl
	 * @return true, wenn das Spiel beendet werden soll
	 */
	private boolean processCommand(Command command) {

		if (command.isUnknown()) {
			System.out.println("Diesen Befehl kenne ich nicht.");
			return false;
		}

		String commandWord = command.getCommandWord();

		if (commandWord.equals("help")) {

			printHelp();

		} else if (commandWord.equals("go")) {

			goRoom(command);

			if (currentRoom.isWinnerRoom()) {
				System.out.println("Glückwunsch! Du hast den Ausgang gefunden und gewonnen!");
				return true;
			}

		} else if (commandWord.equals("back")) {

			goBack();

		} else if (commandWord.equals("map")) {

			printMap();

		} else if (commandWord.equals("take")) {

			takeItem(command);

		} else if (commandWord.equals("drop")) {

			dropItem(command);

		} else if (commandWord.equals("inventory")) {

			printInventory();

		} else if (commandWord.equals("quit")) {

			if (command.hasSecondWord()) {
				System.out.println("Quit what?");
			} else {
				return true;
			}
		}

		return false;
	}

	/**
	 * Zeigt die verfügbaren Befehle an.
	 */
	private void printHelp() {

		System.out.println("Du musst den Ausgang der Schule finden.");
		System.out.println();
		System.out.println("Verfügbare Befehle:");
		System.out.println(parser.showCommands());
	}

	/**
	 * Bewegt den Spieler in einen anderen Raum.
	 *
	 * @param command Befehl mit der gewünschten Richtung
	 */
	private void goRoom(Command command) {

		if (!command.hasSecondWord()) {

			System.out.println("Wohin möchtest du gehen?");

		} else {

			String direction = command.getSecondWord();
			Room nextRoom = currentRoom.nextRoom(direction);

			if (nextRoom == null) {

				System.out.println("Dort gibt es keinen Ausgang!");

			} else {

				previousRooms.push(currentRoom);
				currentRoom = nextRoom;

				System.out.println(currentRoom.longDescription());

				if (currentRoom == informatikraum) {
					System.out.println("Das Fenster ist offen, brrrrrrr");
				}
			}
		}
	}

	/**
	 * Bewegt den Spieler in den vorherigen Raum zurück.
	 */
	private void goBack() {

		if (previousRooms.isEmpty()) {

			System.out.println("Du kannst nicht weiter zurückgehen.");

		} else {

			currentRoom = previousRooms.pop();
			System.out.println(currentRoom.longDescription());
		}
	}

	/**
	 * Zeigt alle Räume, Gegenstände und den aktuellen Raum an.
	 */
	private void printMap() {
		System.out.println(mapPrinter.render(rooms, currentRoom));
	}

	/**
	 * Nimmt einen Gegenstand aus dem aktuellen Raum auf.
	 *
	 * @param command Befehl mit dem Namen des Gegenstandes
	 */
	private void takeItem(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("Was möchtest du aufnehmen?");
			return;
		}
		System.out.println(inventory.take(currentRoom, command.getSecondWord()));
	}

	/**
	 * Legt einen Gegenstand aus dem Inventar im aktuellen Raum ab.
	 *
	 * @param command Befehl mit dem Namen des Gegenstandes
	 */
	private void dropItem(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("Was möchtest du ablegen?");
			return;
		}
		System.out.println(inventory.drop(currentRoom, command.getSecondWord()));
	}

	/**
	 * Zeigt alle getragenen Gegenstände und das Gesamtgewicht an.
	 */
	private void printInventory() {
		System.out.println(inventory.description());
	}
}