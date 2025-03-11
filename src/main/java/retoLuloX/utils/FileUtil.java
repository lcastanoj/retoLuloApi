package retoLuloX.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static void saveToFile(String content, String fileName) {
        try {
            String baseDir = System.getProperty("user.dir");

            Path filePath = Paths.get(baseDir, fileName);

            FileWriter fileWriter = new FileWriter(filePath.toFile());
            fileWriter.write(content);
            fileWriter.close();

            System.out.println("Respuesta guardada en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
