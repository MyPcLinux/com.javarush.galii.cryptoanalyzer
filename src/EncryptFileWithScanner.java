import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EncryptFileWithScanner {
    // Метод для чтения файла с помощью Scanner
    public static void encryptFileWithScanner(File inputFile,File outputFile, int key) {

        try( // Используем Scanner для чтения файла
                Scanner scanner = new Scanner(inputFile, StandardCharsets.UTF_8);
                // BufferedWriter для записи в файл с добавлением
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))
            )
        {
           StringBuilder fileContent = new StringBuilder();

            // Читаем весь файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line).append("\n");
            }

            // Шифруем текст с помощью шифра Цезаря
            String encryptedContent = MainCoderMethod.coderMethod(fileContent.toString(), key);

                writer.write(encryptedContent);

            System.out.println("Файл успешно зашифрован и записан по адресу : " + outputFile.getPath());
            System.out.println("Программа выполенеа успешно.");


            System.exit(0); // Завершаем программу
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

}
