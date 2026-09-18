package ch.bbw.zork;

/**
 * Stellt einen Gegenstand im Zork-Spiel dar.
 * Ein Gegenstand besitzt einen Namen und ein Gewicht.
 */
public class Item {

    private String name;
    private double weight;

    /**
     * Erstellt einen neuen Gegenstand.
     *
     * @param name Name des Gegenstandes
     * @param weight Gewicht des Gegenstandes
     */
    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Gibt den Namen des Gegenstandes zurück.
     *
     * @return Name des Gegenstandes
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt das Gewicht des Gegenstandes zurück.
     *
     * @return Gewicht des Gegenstandes
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gibt den Gegenstand als Text mit Name und Gewicht zurück.
     *
     * @return Gegenstand mit Name und Gewicht
     */
    @Override
    public String toString() {
        return name + " (" + weight + " kg)";
    }
}