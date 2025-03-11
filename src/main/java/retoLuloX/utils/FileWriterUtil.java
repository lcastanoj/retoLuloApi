package retoLuloX.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    public static void writeToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
