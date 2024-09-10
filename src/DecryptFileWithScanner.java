import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DecryptFileWithScanner {
    // Метод для декодирования файла
    public static void decryptFileWithScanner(File inputFile, File outputFile, int key) {
        try (
                // Используем Scanner для чтения файла
                Scanner scanner = new Scanner(inputFile, StandardCharsets.UTF_8);
                // BufferedWriter для записи декодированного текста в файл
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))
        ) {
            StringBuilder fileContent = new StringBuilder();

            // Читаем весь файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line).append("\n");
            }

            // Декодируем текст с помощью обратного шифра Цезаря
            String decryptedContent = MainCoderMethod.coderMethod(fileContent.toString(), -key);

            // Записываем декодированный текст в выходной файл
            writer.write(decryptedContent);

            System.out.println("Файл успешно декодирован и записан в: " + outputFile.getPath());

            System.exit(0); // Завершаем программу
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
