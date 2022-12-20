import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Example005_BinaryFile {
    public static void main(String[] args) {

        // our current location of our project
        Path outDir = Paths.get("").resolve("data").toAbsolutePath();

        boolean[][] field = {
            {true , true , true },
            {false, false, true },
            {false, true , false},
        };

        Path outFile = outDir.resolve("field_binary.txt");
        try(DataOutputStream dos = null) {
            dos.writeInt(field.length);
            dos.writeInt(field[0].length);
            for(boolean[] row : field) {
                for(boolean cell : row) {
                    dos.writeBoolean(cell);
                }
            }
        } catch (IOException ie) { }
        // TODO mini exercise
        // - replace null in the try with resources with
        // - create a DataOutputStream to which you pass
        // - a FileOutputStream
        // - check the written file and compare it with the non-binary version


        int height = -1;
        int width = -1;
        boolean[][] readField = null;
        try(DataInputStream dis = null) {
            height = dis.readInt();
            width = dis.readInt();
            readField = new boolean[height][width];
            for(int row = 0; row < height; row += 1) {
                for(int col = 0; col < width; col += 1) {
                    readField[row][col] = dis.readBoolean();
                }
            }
        } catch (IOException ie) { }
        // TODO mini exercise
        // - replace null in the try with resources with
        // - a DataInputStream to which you pass
        // - a FileInputStream

        System.out.println("= ORIGINAL ==================");
        print(field);
        System.out.println();
        System.out.println("= READ BACK IN =================");
        print(readField);
    }

    // prints a 2d boolean array to the console
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