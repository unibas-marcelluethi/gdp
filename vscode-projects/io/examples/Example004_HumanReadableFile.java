import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Example004_HumanReadableFile {
    public static void main(String[] args) {

        // use the folder data as output location
        Path outDir = Paths.get("").resolve("data").toAbsolutePath();

        // dummy data for writing
        boolean[][] field = {
            {true , true , true },
            {false, false, true },
            {false, true , false},
        };

        // write data
        Path outFile = outDir.resolve("field.txt");
        try(PrintWriter pw = new PrintWriter(outFile.toFile())) {
            for(boolean[] row : field) {
                for(boolean cell : row) {
                }
            }
        } catch (IOException ie) { }
        // TODO mini exercise
        // - write the data to the file
        // - check the file how the data looks like


        // read data
        int height = -1;
        int width = -1;
        boolean[][] readField = null;
        try(Scanner scanner = new Scanner(outFile.toFile())) {
            for(int row = 0; row < height; row += 1) {
                for(int col = 0; col < width; col += 1) {
                }
            }            
        } catch (IOException ie) { }
        // TODO mini exercise
        // - read the data from the file
        // - compare the output printed to the console, does it match?
        

        System.out.println("= ORIGINAL ==================");
        print(field);
        System.out.println();
        System.out.println("= READ BACK IN =================");
        print(readField);
    }

    static void print(boolean[][] field) {
        if (field != null) {
            for(boolean[] row : field) {
                if (row != null) {
                    System.out.println(java.util.Arrays.toString(row));
                }
            }
        }
    }
}