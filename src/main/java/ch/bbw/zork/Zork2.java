package ch.bbw.zork;

/**
 * Startklasse des Zork-Spiels.
 * Enthält die main-Methode und startet das Spiel.
 */
public class Zork2 {

	/**
	 * Startet das Zork-Spiel.
	 *
	 * @param args Kommandozeilenargumente
	 */
	public static void main(String[] args) {

		Game zorkgame = new Game();
		zorkgame.play();
	}
}