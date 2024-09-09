package tmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptFileWithScanner {
    // Метод для чтения файла с помощью Scanner и шифрования текста
    public static void encryptFileWithScanner(File inputFile,File outputFile, int key) {
        try {
            // Используем Scanner для чтения файла
            Scanner scanner = new Scanner(inputFile, "UTF-8");
            StringBuilder fileContent = new StringBuilder();

            // Читаем весь файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line).append("\n");
            }

            // Шифруем текст с помощью шифра Цезаря
            String encryptedContent = CoderRusEng.coderMethod(fileContent.toString(), key);

            // Выводим зашифрованный текст в консоль (или можем записать его в файл)
//            System.out.println("Зашифрованный текст:");
//            System.out.println(encryptedContent);
            // Записываем зашифрованный текст в выходной файл
            FileWriter writer = new FileWriter(outputFile, true); // Параметр true означает "добавить в файл"
                writer.write(encryptedContent);
                writer.close();
            System.out.println("Файл успешно зашифрован и записан в: " + outputFile.getPath());
            scanner.close(); // Закрываем Scanner после использования
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

}
