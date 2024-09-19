import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private static File file;

    public String readFile(String filePath) {
        try {
            // Читаем файл построчно и объединяем в одну строку
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return String.join("\n", lines); // Соединяем строки с разделителем новой строки
        } catch (IOException exception) {
            System.out.println("You have " + exception.getLocalizedMessage());
        }
        return null;
    }

    public void writeFile(String content, String filePath) {
        try {
            // Записываем содержимое в файл
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException exception) {
            System.out.println("You have " + exception.getLocalizedMessage());
        }
    }

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        FileManager.file = file;
    }
}