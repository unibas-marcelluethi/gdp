---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
title : VSCode
---

# Installation von Visual Studio Code

Visual Studio Code (VS Code oder auch einfach Code genannt) ist ein auf den ersten Blick einfacher aber durchaus sehr mächtiger Code Editor für alle gängigen Betriebssysteme und Programmiersprachen. Von Haus aus wird JavaScript (mit NodeJS) unterstützt, aber es gibt sogenannte Extensions für alle gängigen Programmiersprachen.


## Download

Laden Sie bitte den entsprechenden Installer für Ihr System von der [VSCode Download Website](https://code.visualstudio.com/Download) und installieren Sie VSCode entsprechend der Installationsanleitung oder folgen Sie den Anweisung des Installers.

![VS Code Download Page](./code-download-page.png)


## Vorbereiten das Entwickeln mit Java

Wenn Sie das erste mal eine Datei mit der Endung ```.java``` in
Visual Studio Code öffnen, werden Sie gefragt, ob sie das Java Extension Pack installieren wollen. Das [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) ist eine Sammlung von nützlichen Tools um in VSCode Java zu programmieren. Wir empfehlen Ihnen, dies erst nach ein paar Wochen programmiererfahrung zu installieren,
da es einige Schritte so stark vereinfacht, dass Sie die zugrundeliegende Mechanik nicht mehr sehen.

Wenn Sie das JDK installiert haben, sollte sich diese Extension jederzeit ohne Probleme installieren lassen. Sollten wider Erwarten Probleme auftauchen, schauen Sie doch bitte ob Ihnen diese [Anleitung](https://code.visualstudio.com/docs/languages/java) weiter helfen kann.


## Nützliche Tricks

1. Ctrl+Shift+P öffnet eine Eingabefeld um verschiedene Sachen zu suchen.
1. Wenn Sie Probleme mit Java haben, dann suchen Sie nach `Java: Configure Java Runtime` um ein Dialogfenster zu öffnen mit mehr Informationen zu Ihrer Java Installation.
1. Sie können über das Menu `Terminal` eine Konsole öffnen im Ordner den Sie mit VS Code bearbeiten. Dort sollten die Befehle `javac` und `java` auch funktionieren.