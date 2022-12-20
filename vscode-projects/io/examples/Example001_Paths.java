import java.nio.file.Path;
import java.nio.file.Paths;

public class Example001_Paths {
    public static void main(String[] args) {
        Path currentLocation = Paths.get("");
        System.out.println("Ausführungsverzeichnis: \"" + currentLocation + "\"");
        System.out.println("Absolute Pfad: " + currentLocation.toAbsolutePath());
        System.out.println("\n\n=====================================================");

        Path home = Paths.get(System.getProperty("user.home"));
        System.out.println("Benutzerverzeichnis: " + home);

        Path output = currentLocation.resolve("output");
        System.out.println("Ausgabeverzeichnis: " + output.toAbsolutePath());

        System.out.println("\n\n=====================================================");

        System.out.println("Project name: " + currentLocation.toAbsolutePath().getFileName());
        System.out.println("Project location: " + currentLocation.toAbsolutePath().getParent());

        // TODO mini exercise
        // - create a path that represents the data directory
        // - create a path that points to a yet non-existing file in the data directory
        // - print the directory where your non-existing file is located (use only the path pointing to the file)
    }
}