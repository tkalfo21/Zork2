# Zork 2 – 10-Minuten-Präsentation

**Datum:** Mittwoch, 25. November 2026  
**Team:** Thanos, Lav, Livio, Artem  
**Ziel:** Programm nachvollziehbar erklären, live zeigen und die Tests belegen.

## Minutenplan

| Zeit | Person | Inhalt |
| --- | --- | --- |
| 0:00–2:00 | Thanos | Einführung, Spielziel, Raumplan und Gewinnbedingung |
| 2:00–4:15 | Artem | Raumverwaltung, `Room`, Gegenstände im Raum, `back` |
| 4:15–6:30 | Lav | `Item`, Inventar, Maximalgewicht, `map` |
| 6:30–8:30 | Livio | Parser, Befehle, JUnit-Tests, Maven-Ergebnis |
| 8:30–10:00 | alle, Thanos führt | Live-Demo, Fazit und Fragen |

## Sprechtext – Thanos (ca. 2 Minuten)

„Unser Projekt heisst Zork 2 – Schulabenteuer. Zork ist ein textbasiertes Adventure-Spiel. Wir haben aus der Vorlage ein Spiel gemacht, in dem ein Schüler nach Schulschluss in der Schule eingeschlossen ist. Er beginnt im Klassenzimmer. Das Ziel ist, den Ausgang zu erreichen.

Hier ist unser Raumplan. Es gibt sieben Räume: Klassenzimmer, Gang, Informatikraum, Mensa, Bibliothek, Eingangshalle und Ausgang. Wir bewegen uns mit `go north`, `go south`, `go east` und `go west`.

In `Game.java` erstellen wir diese Räume und verbinden sie über `setExits`. Der Ausgang wird mit `setWinnerRoom(true)` als Gewinnerraum markiert. Wenn der Spieler ihn betritt, überprüft `Game` die Eigenschaft `isWinnerRoom()` und beendet das Spiel mit einer Gewinnmeldung.

Wir zeigen nun, wie die Räume technisch funktionieren.“

## Sprechtext – Artem (ca. 2 Minuten 15 Sekunden)

„Die Klasse `Room` speichert die Beschreibung und alle vier möglichen Ausgänge. Dafür verwenden wir eine `HashMap`, die Richtungen wie `north` den benachbarten Räumen zuordnet.

Ausserdem besitzt ein Raum eine `ArrayList<Item>`. Deshalb können mehrere Gegenstände im gleichen Raum liegen. Mit `addItem`, `getItem` und `removeItem` können wir sie verwalten.

Die Methode `longDescription()` zeigt die Raumbeschreibung, die Ausgänge und die vorhandenen Gegenstände.

Für den Befehl `back` speichern wir in `Game` die vorherigen Räume in einem Stack. Beim normalen Raumwechsel wird der alte Raum mit `push` gespeichert. Mit `back` holen wir ihn über `pop` zurück. Das ist das Last-in-first-out-Prinzip.

Wenn man am Anfang `back` eingibt, gibt es noch keinen vorherigen Raum. Dann erscheint eine Fehlermeldung.“

## Sprechtext – Lav (ca. 2 Minuten 15 Sekunden)

„Die Klasse `Item` enthält den Namen und das Gewicht eines Gegenstands. In unserem Spiel gibt es beispielsweise einen Laptop mit zwei Kilogramm und eine Flasche mit einem Kilogramm.

Die Klasse `Inventory` verwaltet, was der Spieler trägt. Sie ist von der Spielsteuerung getrennt, damit jede Klasse eine klare Verantwortung hat.

Wenn man `take laptop` eingibt, wird geprüft, ob der Laptop im Raum liegt und ob das Maximalgewicht von drei Kilogramm eingehalten wird. Danach wird der Gegenstand vom Raum ins Inventar verschoben.

Wenn das Gewicht überschritten würde, verweigert das Spiel die Aufnahme. Mit `drop bottle` kann man Gewicht freimachen.

Unsere Klasse `MapPrinter` zeigt alle Räume und ihre Gegenstände. Der aktuelle Raum wird mit einem Stern besonders markiert. Das demonstrieren wir gleich.“

## Sprechtext – Livio (ca. 2 Minuten)

„Für die Eingabe verwenden wir `Parser`, `Command` und `CommandWords`. Der Parser liest die Eingabe, erkennt das Befehlswort und gegebenenfalls ein zweites Wort, zum Beispiel `go east`.

Wir testen das Programm mit JUnit. Die Tests überprüfen unter anderem, ob ein Raum den richtigen Nachbarn liefert, ob ein Item richtig gespeichert wird und ob man Gegenstände aufnehmen und ablegen kann.

Für das Inventar testen wir ausdrücklich die Maximalgewichtsgrenze. Für die Karte prüfen wir, ob der aktuelle Raum markiert wird.

Mit Maven können wir alle Tests gemeinsam starten. Wir öffnen in IntelliJ **Maven → Lifecycle → test** und zeigen den aktuellen Testlauf. Entscheidend ist die Meldung `BUILD SUCCESS`.“

## Live-Demo – ca. 90 Sekunden

Vor der Präsentation **IntelliJ öffnen**, die Schrift ausreichend gross stellen und `Zork2.main()` starten. Für eine kurze Demo:

```text
map
go east
go north
take laptop
go south
go south
take bottle
go north
go east
take book
drop bottle
take book
inventory
go east
go south
```

**Falls wenig Zeit bleibt:** `map`, `go east`, `go east`, `go east`, `go south` (direkter Gewinnweg).

## Fazit – Thanos

„Wir haben ein funktionierendes Schuladventure mit sieben Räumen, Gewinnerraum, Inventar, Gewichtslimit, Karte und dem Befehl `back` entwickelt. Die Arbeit hat uns gezeigt, wie wichtig Klassen, Objekte, Collections, klare Verantwortlichkeiten und automatisierte Tests sind.“

## Fragen, die der Lehrer stellen könnte

**Warum `HashMap` für Ausgänge?**  
Weil man über eine Richtung wie `north` direkt den verbundenen Raum finden kann.

**Warum `ArrayList` für Gegenstände?**  
Weil die Anzahl Gegenstände unterschiedlich sein kann und wir mehrere speichern müssen.

**Warum `Stack` für `back`?**  
Weil der zuletzt betretene Raum als Erstes wieder verlassen wird (LIFO).

**Wo wird geprüft, ob man gewinnt?**  
In `Game.processCommand` nach einem `go` mit `currentRoom.isWinnerRoom()`.

**Wieso eine eigene `Inventory`-Klasse?**  
Sie kapselt die Gegenstände und die Gewichtskontrolle. `Game` muss die Details nicht selbst verwalten.

**Was ist Single Responsibility?**  
Jede Klasse sollte einen klaren Hauptzweck haben, z. B. `MapPrinter` für die Kartenansicht.

**Was passiert, wenn man zu viel trägt?**  
`canCarry` liefert `false`, die Aufnahme wird verweigert und das Item bleibt im Raum.

**Was zeigt euer Klassendiagramm?**  
Klassen mit Attributen, Methoden sowie Beziehungen zwischen ihnen.

## Checkliste vor dem Unterricht

- Aktuellen Stand vom Repository holen: `git pull --ff-only`
- **Maven → Lifecycle → test** starten und Fehlerfreiheit kontrollieren
- `Zork2.main()` starten und die Befehle ausprobieren
- `docs/Raumplan.md` und `docs/Klassendiagram.md` zum Zeigen öffnen
- Bildschirm gut lesbar einstellen und Rollen vorher einmal durchsprechen
