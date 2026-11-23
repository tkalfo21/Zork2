package ch.bbw.zork;

import java.util.ArrayList;

/**
 * Verwaltet das Inventar des Spielers und prüft die Traglast.
 */
public class Inventory {

    private final ArrayList<Item> items;
    private final double maxWeight;

    /**
     * Erstellt ein leeres Inventar.
     *
     * @param maxWeight maximal erlaubtes Gewicht in Kilogramm
     */
    public Inventory(double maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    /**
     * Berechnet das Gewicht der getragenen Gegenstände.
     *
     * @return Gesamtgewicht in Kilogramm
     */
    public double getTotalWeight() {
        double total = 0;
        for (Item item : items) {
            total += item.getWeight();
        }
        return total;
    }

    /**
     * Prüft, ob ein Gegenstand noch getragen werden kann.
     *
     * @param item gewünschter Gegenstand
     * @return true, wenn genügend Tragkapazität vorhanden ist
     */
    public boolean canCarry(Item item) {
        return getTotalWeight() + item.getWeight() <= maxWeight;
    }

    /**
     * Nimmt einen Gegenstand aus dem Raum auf.
     *
     * @param room aktueller Raum
     * @param name Name des Gegenstandes
     * @return Meldung über das Ergebnis
     */
    public String take(Room room, String name) {
        Item item = room.getItem(name);
        if (item == null) {
            return "Dieser Gegenstand ist nicht hier.";
        }
        if (!canCarry(item)) {
            return "Der Gegenstand ist zu schwer.";
        }
        room.removeItem(item);
        items.add(item);
        return "Du hast " + item.getName() + " aufgenommen.";
    }

    /**
     * Legt einen getragenen Gegenstand im Raum ab.
     *
     * @param room aktueller Raum
     * @param name Name des Gegenstandes
     * @return Meldung über das Ergebnis
     */
    public String drop(Room room, String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                items.remove(item);
                room.addItem(item);
                return "Du hast " + item.getName() + " abgelegt.";
            }
        }
        return "Du hast diesen Gegenstand nicht.";
    }

    /**
     * Zeigt Gegenstände und Gesamtgewicht an.
     *
     * @return Textansicht des Inventars
     */
    public String description() {
        StringBuilder result = new StringBuilder("Inventar:");
        if (items.isEmpty()) {
            return result.append("\nleer").toString();
        }
        for (Item item : items) {
            result.append("\n- ").append(item);
        }
        result.append("\nGewicht: ").append(getTotalWeight())
              .append(" / ").append(maxWeight).append(" kg");
        return result.toString();
    }
}
