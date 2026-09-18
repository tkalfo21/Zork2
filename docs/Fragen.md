# Zork 2 – Fragen

## 1.1 Konstruktor der Klasse Game

Der Konstruktor der Klasse Game lautet:

```java
public Game()

## 1.2 Konstruktor der Klasse Room

**Frage:**  
Wie lautet die Signatur des Konstruktors der Klasse Room?

**Antwort:**

public Room(String description)


## 1.3 Konstruktor der Klasse Command

**Frage:**  
Wie lautet die Signatur des Konstruktors der Klasse Command?

**Antwort:**

public Command(String commandWord)

public Command(String commandWord, String secondWord)


## 1.4 Ausgänge eines Raumes

**Frage:**  
Wo wird die Objektvariable für die Ausgänge deklariert und wo wird das Objekt instanziert?

**Antwort:**

Die Objektvariable wird in der Klasse Room deklariert:

private HashMap<String, Room> exits;

Das Objekt wird im Konstruktor instanziert:

this.exits = new HashMap<>();


## 1.5 Hier drin ist es aber kalt!

**Frage:**  
Wie wird beim Betreten eines bestimmten Raumes die Meldung ausgegeben?

**Antwort:**

In der Klasse Game wird geprüft, ob der Spieler das lab betreten hat:

if (currentRoom == lab) {
System.out.println("Das Fenster ist offen, brrrrrrr");
}


---

# 5. `docs/klassendiagramm.md`

Erstellen und das reinkopieren:

```markdown
# Klassendiagramm

## Zork2

- main(String[] args)

Zork2 erstellt ein Objekt der Klasse Game und startet das Spiel.

## Game

Attribute:

- Parser parser
- Room currentRoom
- ArrayList<Room> rooms
- Stack<Room> previousRooms
- ArrayList<Item> inventory
- double maxWeight

Aufgaben:

- Spiel starten
- Räume erstellen
- Befehle verarbeiten
- Spieler bewegen
- Gegenstände aufnehmen
- Gegenstände ablegen
- Inventar verwalten
- Karte anzeigen
- Gewinner-Raum erkennen

## Room

Attribute:

- String description
- HashMap<String, Room> exits
- boolean winnerRoom
- ArrayList<Item> items

Aufgaben:

- Raum beschreiben
- Ausgänge speichern
- Gegenstände speichern
- Gewinner-Raum speichern

## Item

Attribute:

- String name
- double weight

Aufgaben:

- Name eines Gegenstandes speichern
- Gewicht eines Gegenstandes speichern

## Parser

Aufgaben:

- Eingaben des Spielers lesen
- Eingaben in Command-Objekte umwandeln

## Command

Attribute:

- String commandWord
- String secondWord

Aufgabe:

- Einen eingegebenen Befehl speichern

## CommandWords

Aufgabe:

- Alle gültigen Befehle verwalten

## Beziehungen

Zork2
↓
Game

Game
↓
Parser

Parser
↓
Command

Parser
↓
CommandWords

Game
↓
Room

Room
↓
Item