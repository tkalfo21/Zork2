# Zork 2 – Fragen

## 1.1 Konstruktor der Klasse Game

Der Konstruktor lautet:

```java
public Game()
```

Ein Objekt wird in der `main`-Methode der Klasse `Zork2` erzeugt:

```java
Game zorkgame = new Game();
zorkgame.play();
```

## 1.2 Konstruktor der Klasse Room

```java
public Room(String description)
```

## 1.3 Konstruktoren der Klasse Command

```java
public Command(String commandWord)
public Command(String commandWord, String secondWord)
```

## 1.4 Ausgänge eines Raumes

Die Objektvariable wird in `Room` deklariert:

```java
private HashMap<String, Room> exits;
```

Sie wird im Konstruktor von `Room` instanziert:

```java
this.exits = new HashMap<>();
```

## 1.5 Hier drin ist es aber kalt!

Beim Betreten des Informatikraums prüft `Game`:

```java
if (currentRoom == informatikraum) {
    System.out.println("Das Fenster ist offen, brrrrrrr");
}
```
