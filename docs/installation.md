# Installation von Jupyter-Notebooks für Java

Jupyter-Notebooks sind eine Webanwendung, die es ermöglicht Programme in einem Webbrowser zu schreiben, zu kommentieren und auszuführen. 
 Jupyter Notebooks wurden ursprünglich für Python geschrieben, sind aber inzwischen auch für andere Programmiersprachen verfügbar. Seit kurzen besteht auch die Möglichkeit, Jupyter Notebooks mit Java zur nutzen. 
 Da das dafür benötigte [ijava](https://github.com/SpencerPark/IJava) Programm noch nicht im Standardumfang von Jupyter Notebooks enthalten ist, ist die Installation noch etwas aufwändig. 
 Wir stellen Ihnen deshalb einen [Docker](https://www.docker.com/) Container mit der bereits fertig augesetzten Umgebung zur Verfügung.  Diese Anleitung beschreibt wie Sie diesen Docker Container auf Ihrem System nutzen können.

*Falls bei der Installation Probleme auftreten, können Sie in eines der Tutorate gehen um sich Hilfe zu holen. Falls Sie auch dann keine Lösung finden, lesen Sie bitte bei Punkt 2 unten weiter.* 

## 1. Installation mittels Docker oder Docker Toolbox

Damit Sie den unseren Docker Container nutzen können, müssen Sie zuerst Docker oder Docker toolbox auf Ihrem System installieren. Docker toolbox wählen Sie immer dann, wenn Sie auf einer Windows version arbeiten, die Docker nicht unterstützt (Wie zum Beispiel Windows 10 home) oder Sie bereits Virtualbox unter Windows einsetzen. 

1. Folgend Sie dann der Installationsanleitung für Ihr System:
    * Anleitung für [Windows (Docker)](https://docs.docker.com/docker-for-windows/install/)
    * Anleitung für [Windows (Docker toolbox)](https://docs.docker.com/toolbox/toolbox_install_windows/)
    * Anleitung für [MacOS](https://docs.docker.com/docker-for-mac/install/)
    * Anleitung für Linux: [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Debian](https://docs.docker.com/install/linux/docker-ce/debian/), [Fedora](https://docs.docker.com/install/linux/docker-ce/fedora/), [CentOS](https://docs.docker.com/install/linux/docker-ce/centos/)

2. Öffnen Sie eine Kommandozeile (Terminal). Sie sollten in dieser Kommandozeile Administrationsrechte haben.
    * Unter Windows können Sie die Kommandozeile als Administrator öffnen indem Sie im Startmenu auf den Kommandozeileneintrag Rechtsklicken und "als Administrator ausführen" auswählen.
    * Unter Linux und Mac können Sie die Kommandozeile als normaler Nutzer ausführen und dann ```sudo su ``` aufrufen um Administrator zu werden.
![start terminal](images/start-terminal.png)

Geben Sie nun folgenden Befehl ein um den Container mit dem Jupyter Notebook auf ihr System zu bringen.
```
docker pull marcelluethi/programmieren-notebooks:1.3
```

*Falls Sie in diesem Schritt eine Fehlermeldung bekommen, könnte es daran liegen, dass Docker nicht gestartet ist. Unter Windows und MacOS starten Sie Docker, in dem Sie die Docker Anwendung aufrufen (Sie finden diese im Startmenu). Unter Linux sollte dieses Problem nicht auftauchen.*


### Starten von Jupyter Notebooks

Um Jupyter notebook server zu starten, geben sie folgenden Befehl ein
```
docker run -p 8888:8888 -it marcelluethi/programmieren-notebooks:1.3
```

Starten Sie nun einen Browser und falls Sie Docker (und nicht Docker toolbox verwenden) geben Sie folgende URL ein 
```
http://localhost:8888
```
Falls Sie Docker toolbox verwenden, geben Sie folgende URL ein
```
http://192.168.99.100:8888 
```

Falls Sie folgende Webseite sehen, war die Installation erfolgreich.
![jupyter](images/jupyter.png) 

## 2. Jupyter Notebooks in der Cloud

Falls Sie Probleme mit der Installation von Docker haben, die auch von den Tutoren nicht gelöst werden können, können Sie auf eine Cloudbasierte Lösung zurückgreifen. Diese Lösung hat die Einschränkung, dass Sie zwar alle Programme ausführen und verändern können, diese aber nicht speichern können. Ausserdem kann das System bei hoher Nutzung langsam werden. *Eine lokale Installation ist deshalb immer die bevorzugte Lösung!*


Gehen Sie zurück auf die Github Seite: [https://github.com/unibas-marcelluethi/programmieren-notebooks](https://github.com/unibas-marcelluethi/programmieren-notebooks).
Drücken Sie dann auf *launch binder* (siehe Bild):
![github](images/github.png)
 
