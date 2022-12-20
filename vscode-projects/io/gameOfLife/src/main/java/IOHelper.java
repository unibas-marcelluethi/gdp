import java.nio.file.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class IOHelper {

    public static File askForFile(boolean forSaving) {
        Path currentLocation = Paths.get("").toAbsolutePath();

        // dialog for choosing a file
        JFileChooser fileChooser = new JFileChooser(currentLocation.toFile());
        fileChooser.setDialogTitle("Please select a GOL file");

        // preselection of files that will be shown
        FileFilter filter = new FileNameExtensionFilter("Game of life", "gol");
        fileChooser.setFileFilter(filter);

        // show the dialog to the user up to 5 times
        int result = -1;
        int nTries = 5;
        do {
            if(forSaving) {
                result = fileChooser.showSaveDialog(null);
            } else {
                result = fileChooser.showOpenDialog(null);
            }
            nTries -= 1;
        } while (result != JFileChooser.APPROVE_OPTION && nTries > 0);

        if(result != JFileChooser.APPROVE_OPTION) {
            throw new IllegalArgumentException("No reasonable file selected");
        }

        return fileChooser.getSelectedFile();
    }
    
}