package ch.bbw.zork;

import java.util.List;

/**
 * Erstellt eine Textübersicht aller Räume und ihrer Gegenstände.
 */
public class MapPrinter {

    /**
     * Gibt die Räume samt Gegenständen aus und markiert den aktuellen Raum.
     *
     * @param rooms alle Räume
     * @param currentRoom Aufenthaltsraum des Spielers
     * @return formatierte Übersicht
     */
    public String render(List<Room> rooms, Room currentRoom) {
        StringBuilder result = new StringBuilder("Karte:");
        for (Room room : rooms) {
            if (room == currentRoom) {
                result.append("\n* ").append(room.shortDescription())
                      .append(" <- aktueller Raum");
            } else {
                result.append("\n- ").append(room.shortDescription());
            }
            if (room.getItems().isEmpty()) {
                result.append("\n  Gegenstände: keine");
            } else {
                result.append("\n  Gegenstände:");
                for (Item item : room.getItems()) {
                    result.append("\n  - ").append(item);
                }
            }
        }
        return result.toString();
    }
}
