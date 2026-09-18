# Zork 2 – Schulabenteuer

## Projektbeschreibung

Dieses Projekt ist eine Erweiterung des Spiels Zork.

Der Spieler wurde nach Schulschluss in der Schule eingeschlossen.
Er startet im Klassenzimmer und muss den Ausgang der Schule finden.

Auf dem Weg kann der Spieler verschiedene Räume besuchen und Gegenstände
aufnehmen oder ablegen.

## Ziel des Spiels

Das Ziel ist es, den Ausgang der Schule zu erreichen.

Sobald der Spieler den Raum "Ausgang" betritt, ist das Spiel gewonnen.

## Räume

- Klassenzimmer
- Gang
- Informatikraum
- Mensa
- Bibliothek
- Eingangshalle
- Ausgang

## Gegenstände

Im Spiel gibt es verschiedene Gegenstände:

- Laptop – 2.0 kg
- Bottle – 1.0 kg
- Book – 0.5 kg
- Key – 0.2 kg

Der Spieler kann Gegenstände aufnehmen und wieder ablegen.

Das maximale Gewicht des Inventars beträgt 3.0 kg.

## Befehle

Folgende Befehle können verwendet werden:

- `go north`
- `go east`
- `go south`
- `go west`
- `back`
- `map`
- `take <Gegenstand>`
- `drop <Gegenstand>`
- `inventory`
- `help`
- `quit`

## Gewinnen

Der Raum "Ausgang" ist als Gewinner-Raum definiert.

Wenn der Spieler diesen Raum erreicht, erscheint eine Gewinnmeldung
und das Spiel wird beendet.

## Weitere Funktionen

- Zurückgehen in vorherige Räume
- Karte mit allen Räumen anzeigen
- Gegenstände in Räumen
- Gegenstände aufnehmen
- Gegenstände ablegen
- Mehrere Gegenstände tragen
- Maximales Gewicht des Inventars
- Gewinner-Raum

## Tests

Für wichtige Klassen wurden JUnit-Tests erstellt.

Getestet werden unter anderem:

- Räume
- Ausgänge
- Gewinner-Raum
- Gegenstände
- Gewicht
- Befehle

## Autoren

Thanos Kalfopoulos
Lav Patil
Artem Semerenko
