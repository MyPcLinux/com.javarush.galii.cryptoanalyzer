import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Decoder {

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
            String decryptedContent = Coder.coderMethod(fileContent.toString(), -key);

            // Записываем декодированный текст в выходной файл
            writer.write(decryptedContent);

            System.out.println("Файл успешно декодирован и записан в: " + outputFile.getPath());

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void decoderInfo() {
        System.out.println("Процес декодирования.....");
        // Ввод данных
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Введите путь к зашифрованному файлу: ");
        String inputFilePath = inputScanner.nextLine();

        System.out.print("Введите путь для файла с расшифрованным текстом: ");
        String outputFilePath = inputScanner.nextLine();

        System.out.print("Введите ключ для расшифровки (такой же, как использовался для шифрования): ");
        int key = inputScanner.nextInt();

        // Создаем объекты файлов
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        // Вызываем метод для декодирования
        decryptFileWithScanner(inputFile, outputFile, key);
    }
}

