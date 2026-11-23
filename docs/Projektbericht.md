# Zork 2 – Projektbericht und Präsentationsvorbereitung

## Projektziel
Das ursprünglich einfache Zork-Spiel wurde zu einem Schulabenteuer erweitert. Die Spielfigur startet im Klassenzimmer, erkundet sieben miteinander verbundene Räume und gewinnt beim Betreten des Ausgangs.

## Objektorientierter Aufbau
- `Zork2`: startet das Spiel über `main`.
- `Game`: steuert Spielablauf, Befehle, Raumwechsel und Gewinnbedingung.
- `Room`: verwaltet Beschreibung, Ausgänge (`HashMap<String, Room>`), Gegenstände (`ArrayList<Item>`) und die Markierung als Gewinnerraum.
- `Item`: besitzt einen Namen und ein Gewicht.
- `Inventory`: trägt Gegenstände, prüft 3,0 kg Maximalgewicht und legt Gegenstände wieder ab.
- `MapPrinter`: erzeugt die übersichtliche Ausgabe aller Räume und Gegenstände.
- `Parser`: liest Texteingaben und erstellt `Command`-Objekte.
- `Command`: speichert Befehlswort und optionales zweites Wort.
- `CommandWords`: prüft die verfügbaren Befehle.

Die Trennung von `Inventory` und `MapPrinter` aus `Game` sorgt für klarere Zuständigkeiten (Single Responsibility).

## Implementierte Anforderungen und Vorgehen

### Gewinnerraum
`Room` besitzt das Attribut `winnerRoom`. Beim Erstellen der Welt wird `ausgang.setWinnerRoom(true)` gesetzt. Nach `go` prüft `Game` mit `currentRoom.isWinnerRoom()`, ob das Spiel endet.

### Zurückgehen
Bei jedem gültigen Raumwechsel legt `Game` den bisherigen Raum auf einen `Stack<Room>`. `back` holt mit `pop()` den zuletzt besuchten Raum zurück. Ein leerer Stack ergibt eine verständliche Fehlermeldung.

### Gegenstände im Raum
Jeder `Room` besitzt eine `ArrayList<Item>`. `addItem` fügt hinzu, `getItem(String)` sucht nach Namen, `removeItem` entfernt Gegenstände. `longDescription()` zeigt die vorhandenen Objekte.

### Gewicht und Inventar
`Item.getWeight()` liefert das Einzelgewicht. `Inventory.getTotalWeight()` summiert die Gewichte. `canCarry()` verhindert, dass mehr als 3,0 kg getragen werden. `take` entfernt ein Item aus dem Raum und fügt es dem Inventar hinzu; `drop` macht den Schritt rückgängig.

### Karte
`Game` hält alle Räume in einer `ArrayList<Room>`. `MapPrinter.render` zeigt jeden Raum, seine verbliebenen Gegenstände und markiert den aktuellen Raum mit einem Stern.

### Vererbung
Die optionale Vererbungsaufgabe wurde bewusst nicht umgesetzt. Stattdessen wurden die geforderten Spielfunktionen und die Trennung der Verantwortlichkeiten priorisiert.

## Live-Demo für Mittwoch, 25.11.2026

Spiel über `Zork2.main()` starten. Anschliessend Befehle einzeln eingeben:

```text
map
back
go east
go north
take laptop
inventory
go south
go south
take bottle
inventory
go north
go east
take book
drop bottle
take book
inventory
drop book
map
go east
go south
```

Erwartete Schlüsselstellen:
- `back` direkt am Anfang: keine vorherige Position.
- `go north` aus dem Gang: Informatikraum und Hinweis „Das Fenster ist offen, brrrrrrr“.
- Nach Laptop (2,0 kg) und Bottle (1,0 kg) ist das Inventar voll.
- `take book`: „Der Gegenstand ist zu schwer.“
- `drop bottle` und danach `take book`: Buch lässt sich tragen.
- `map`: aktuelle Position markiert und die Gegenstände werden angezeigt.
- `go south` von der Eingangshalle: Gewinnmeldung und Spielende.

## Qualitätssicherung
Die Tests prüfen unter anderem Raumwechsel, Gewinnerraum, Gegenstände, Befehle, Parser, Karte und Inventar. Für die aktuelle Version muss in IntelliJ über **Maven → Lifecycle → test** ein neuer Lauf mit **BUILD SUCCESS** durchgeführt werden.

## Git und Zusammenarbeit
Die Repository-Datei `CONTRIBUTORS.md` dokumentiert die Aufgabenverteilung. Bei der Präsentation zeigen wir die Git-Commits und erklären die tatsächlichen Beiträge.
