# Jupyter Notebooks: Frequently Asked Questions

## Allgemeine Fragen

### Beim Öffnen eines Notebooks kommt die Fehlermeldung, dass das Notebook nicht geöffnet werden konnte. 

Wahrscheinlich ist das Notebook durch eine fehlerhafte Synchronisation beschädigt worden. Um diesen Fehler zu beheben, können Sie das entsprechende Notebook herunterladen. Durch Upload dieses Notebooks in Ihre Jupyter Umgebung können Sie dann das Notebook dann in Jupyter ersetzen (siehe Screenshot) 

![upload](images/upload.png)

Den Link zu allen Notebooks gibt es auf der [Vorlesungsseite](https://dmi.unibas.ch/de/studium/computer-science-informatik/lehrangebot-hs19/vorlesung-grundlagen-der-programmierung/). Um die Notebooks herunterzuladen öffnen Sie das gewünschte Notebook und gehen auf den Download Knopf (oben Rechts). Im Browser wird Ihnen nun eine Textdatei mit dem Inhalt des Notebooks angezeigt. Diese können Sie speichern indem Sie rechte Maustaste wählen "Seite speichern unter". 

## Virtualbox

### Der Bildschirm is gesperrt und ich brauche ein Passwort. Was ist das Passwort?
Das Passwort ist *notebook*.


### Ich habe Virtualbox installiert, kann aber die Virtuelle Maschine nicht starten
Wahrscheinlich ist in ihrem Bios die Virtualisierungsunterstützung (VT-X) nicht aktiviert. Wie sie dies aktivieren ist in diesem [Artikel](https://www.tactig.com/enable-intel-vt-x-amd-virtualization-pc-vmware-virtualbox/) gut beschrieben.

### Wie kann ich das Tastaturlayout in der Virtualbox umstellen?

Starten Sie die Virtuelle Maschine und gehen Sie auf Activities (oben Links) und tippen Sie *Regional* wie im Screenshot dargestellt
![keyboard1](images/select-keyboard-1.png)
Im Nachfolgenden Dialog können Sie ein neues Tastaturlayout hinzufügen, indem Sie auf den ```+``` Button drücken und das gewünschte Tastaurlayout auswählen.
![keyboard1](images/select-keyboard-2.png)


### Meine Virtuelle Maschine läuft zu langsam 

Sie können in den Einstellungen wählen, wieviel Ressourcen Sie der Virtuellen Maschine zuordnen. Dazu wählen Sie die Virtuelle Maschine *jupyter-java* und wählen dann *Ändern* wie im Screenshot gezeigt:
![vbox1](images/vbox.png)

Unter System können Sie der Virtuellen Maschine dann mehr Hauptspeicher und auch mehrere Prozessorkerne zuordnen.

![vbox1](images/vbox-2.png)

### Meine Virtualbox macht mein System langsam

Verfahren Sie wie in der vorigen Frage, aber reduzieren Sie den Hauptspeicher, der der Maschine zugeordnet ist. 

Wenn Sie Wert auf ein schnelles und Ressourcenschonendes System legen, empfehlen wir Ihnen stattdessen Docker zu verwenden. 

### Kann ich nicht einfach die Online Version nehmen?

Die Online Version funktioniert gut und kann als Ersatz für eine lokale Installation verwendet werden. Beachten Sie einfach, dass ihre Änderung nicht gespeichert wird und beim schliessen des Browsers verlorengeht. Sie können Ihre Änderung aber speichern, indem Sie das Notebook herunterladen und beim nächsten Start wieder hochladen. 

## Docker 

Es sind noch keine Dockerspezifischen Fragen oder Probleme aufgetaucht. 