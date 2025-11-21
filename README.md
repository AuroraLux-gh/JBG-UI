# JBG-UI

Dieses Projekt ist ein Java-Swingprojekt, das im Rahmen des Ausbildungsblocks **Programmierung III** entwickelt wurde. Es ermöglicht dem Benutzer, sich Daten von einer API zu holen und diese anzuzeigen. Man kann auswählen, welche Daten man bekommen möchte.

## Projektstruktur

Das Projekt besteht aus folgenden Klassen:

- **Main**: Einstiegspunkt des Programms.
- **memeClient**: Steuert die Verbindung mit dem Backend-Programm `jungbrutalgutaussehend 3-5`.
- **UI**: STeuert die UI Schaltflächen und erstellt das einzeige Fenster.
- **Exception**: Eigene Exception, wenn das Bild nicht gefunden wird.

## Funktionsweise

1. Der Benutzer gibt an welchen Eintrag mit welcher ID er bekommen möchte.
2. Danach wird diese ID an die API gegeben und an das Backend geschickt:
3. Das Backend schickt eine Anfrage an die Datenbank.
4. Das Backend schickt die Daten an die UI welche die Daten ausgibt.

## Technologien

- Programmiersprache: Java
- Build-Tool: Maven
- UI-Klasse: Swing


***Autoren: Aileen, Lux, Jakob***
