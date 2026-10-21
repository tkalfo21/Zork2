# Raumplan – Zork 2 Schulabenteuer

Die Pfeile entsprechen den Richtungsbefehlen `go north`, `go east`, `go south` und `go west`. Der Spieler beginnt im Klassenzimmer. Der Ausgang ist der Gewinner-Raum.

```mermaid
flowchart TB
    I["Informatikraum<br/>Laptop (2,0 kg)"]
    K["Klassenzimmer<br/>START"]
    G["Gang"]
    M["Mensa<br/>Bottle (1,0 kg)"]
    B["Bibliothek<br/>Book (0,5 kg)"]
    E["Eingangshalle<br/>Key (0,2 kg)"]
    A["Ausgang<br/>GEWONNEN"]

    K <-->|Osten / Westen| G
    G <-->|Norden / Süden| I
    G <-->|Süden / Norden| M
    G <-->|Osten / Westen| B
    B <-->|Osten / Westen| E
    E <-->|Süden / Norden| A
```

**Gewinnweg:** `go east` → `go east` → `go east` → `go south`.

Die Befehle `back`, `map`, `take`, `drop` und `inventory` können unterwegs genutzt werden.
