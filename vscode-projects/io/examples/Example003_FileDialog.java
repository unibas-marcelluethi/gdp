import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

public class Example003_FileDialog {
    public static void main(String[] args) {
        Path currentLocation = Paths.get("").toAbsolutePath();

        // the dialog
        JFileChooser fileChooser = new JFileChooser(currentLocation.toFile());
        fileChooser.setDialogTitle("Please select a GOL file");

        // filter the files which are shown
        String extension = "gol";
        String description = "Game of life";
        FileFilter filter = new FileNameExtensionFilter(description, extension);
        fileChooser.setFileFilter(filter);

        // show the dialog
        int result = fileChooser.showSaveDialog(null);
        if ( result != JFileChooser.APPROVE_OPTION ) {
            
            return; // something went wrong or the user clicked on cancel, return for now
        }

        File userFile = fileChooser.getSelectedFile();

        // TODO mini exercise
        // - make a variable of type Path from the userFile
        // - print the path to the console
        // - what happens to the path when you omit a file extension in the dialog? Will it have the one from the file filter?
    }
}