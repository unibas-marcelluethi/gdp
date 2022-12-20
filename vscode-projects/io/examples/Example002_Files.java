import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example002_Files {
    public static void main(String[] args) {
        Path currentLocation = Paths.get("").toAbsolutePath();


        boolean exists = Files.exists(currentLocation);
        System.out.println("Current location exists: " + exists);

        Path fantasyLocation = Paths.get("fantasy");
        System.out.println("Fantasy location exists: " + Files.exists(fantasyLocation));


        Path sourceFile = currentLocation.resolve("Example002_Files.java");
        System.out.println(Files.isRegularFile(sourceFile));
        System.out.println(Files.isDirectory(sourceFile));


        try {
            for(Path p : Files.newDirectoryStream(sourceFile)) {
                System.out.println(p);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        // TODO mini exercise
        // - change the above loop in order to print all files in the project directory.

        /* how to create a directory
        try {
            Path logDir = Paths.get("").resolve("log");
            if( !Files.exists(logDir));
            Files.createDirectories(logDir); 
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        */

    }
}