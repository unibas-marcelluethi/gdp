# Installation von Jupyter-Notebooks für Java

*Jupyter-Notebooks sind eine Webanwendung, die es ermöglicht Programme in einem Webbrowser zu schreiben, zu kommentieren und auszuführen. Jupyter Notebooks wurden ursprünglich für Python geschrieben, sind aber inzwischen auch für andere Programmiersprachen verfügbar. Seit kurzen steht auch eine Umgebung für Java zur Verfügung.
Da diese aber noch nicht im Standardumfang von Jupyter Notebooks beinhaltet sind, sind noch ziemlich viele Arbeitsschritte für die Installation nötig. Wir haben Ihnen deshalb bereits vordefinierte Virtuelle Maschinen zur Verfügung gestellt, die bereits die ganze Umgebung fertig aufgesetzt beinhaltet. Diese Anleitung führt Sie durch die Installation.*

## 1. Virtualbox oder Docker

Sie haben zwei verschiedene Möglichkeiten Jupyter Notebooks zu installieren: 
1. Sie nutzen Oracle Virtualbox und lassen darauf eine virtuelle Maschine laufen, die wir für Sie aufgesetzt haben.
2. Sie nutzen Docker Container.

Die erste Variante ist einfacher und kann komplett via einer Graphischen Oberfläche durchgeführt werden. Dies ist die empfohlene Variante für alle, die noch nicht so mit der Kommandozeile vertraut sind. Der Hauptnachteil davon ist, dass sie etwas Festplattenspeicher verschwenden (die Virtuelle Maschine ist ca 5. GB gross) und die Ausführung leicht langsamer ist.

Die zweite Variate, die Nutzung von Docker ist deutlich schlanker. Wir empfehlen diese Variante für alle, die gerne mit der Kommondozeile arbeiten und Wert auf ein schlankes System legen. Docker kann man unter allen gängigen Betriebssystemen (Windows, Linux, MacOS) installieren, ist aber besonders einfach von Linux nutzbar. 

## 2. Installation mittels Virtualbox

1. Gehen Sie auf die [Downloadseite](https://www.virtualbox.org/wiki/Downloads) von Oracle Virtualbox 
2. Wählen Sie unter *VirtualBox 5.2.22 platform packages* das Ihrem Betriebssystem entsprechende Paket und installieren Sie dieses. 
    * Weitere Details finden Sie in dieser [Anleitung](https://www.wikihow.com/Install-VirtualBox)
3. Downloaden Sie die Virtuelle Machine mit Jupyter-Notebooks von [hier](https://drive.switch.ch/index.php/s/FYNLOsoo5RalhYS)
4. Starten Sie nun Virtualbox. Sie sollten folgendes Fenster sehen ![vbox-startup](./images/vbox-start.png)
5. Importieren Sie die in Schritt 3 heruntergeladene Datei indem Sie ```Datei->Appliance importieren``` wählen, und die entsprechende Datei im Dialogfenster auswählen. Drücken Sie Weiter und wählen Sie ```importieren``` auf der nächsten Seite. 
6. Starten Sie die Virtuelle Machine indem Sie diese in der Liste Links auswählen und den Startbutton drücken.

Herzliche Gratulation! Die Installation ist hiermit abgeschlossen und Sie können mit den Notebooks arbeiten. 

### 2.1 Starten von Jupyter Notebooks
Auf dem Desktop in ihrer Virtuellen Maschine sollten Sie nun zwei Icons sehen: ```start-notebook-server``` und ```start-notebook-client```
![Desktop]()
Starten Sie den Server indem Sie das entsprechende Icon doppelklicken. Starten Sie danach den Client. Sie sollten nun folgendes Browswerfenster sehen:

![Browser]

*Wichtig! Der Benutzername für die Virtualbox ist ```jupyter``` und das Passwort ```notebook```.*

## 3. Installation mittels Docker

1. Installieren Sie Docker auf ihrem System gemäss dieser [Anleitung](https://docs.docker.com/install/)
2. Öffnen Sie ein Terminal (Kommandozeile). Sie sollten in diesem Terminal Administrationsrechte haben.
    * Unter Windows können Sie das Terminal als Administrator öffnen indem Sie im Startmenu auf den Kommandozeileneintrag Rechts klicken und "als Administrator ausführen" auswählen.)
    * Unter Linux und Mac können Sie die Kommandozeile als normaler Nutzer ausführen und dann ```sudo su ``` aufrufen um administrator zu werden.


Geben Sie nun folgenden Befehl ein um den Container mit dem Jupyter Notebook auf ihr System zu bringen.
```
docker pull marcelluethi/programming-notebooks:1.1
```


### Starten von Jupyter Notebooks

Um Jupyter notebook server zu starten, geben sie folgenden Befehl ein
```
docker run -p 8888:8888 -it marcelluethi/programming-notebooks:1.1
```

Starten Sie nun einen Browser und geben Sie folgende URL ein 
```
http://localhost:8888
```

Sie sollten nun folgende Webseite sehen:
![Browser]