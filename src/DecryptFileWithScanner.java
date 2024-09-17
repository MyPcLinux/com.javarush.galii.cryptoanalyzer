import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DecryptFileWithScanner {
    // Метод для декодирования файла
    // Метод для декодирования файла с использованием Scanner
    public static void decryptFileWithScanner(File inputFile, File outputFile, int key, Alphabet alphabet) {
        try (Scanner scanner = new Scanner(inputFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Считываем данные построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Декодируем каждую строку
                String decryptedLine = decrypt(line, key, alphabet);

                // Записываем декодированную строку в выходной файл
                writer.write(decryptedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }

    // Метод для декодирования строки (шифр Цезаря)
    public static String decrypt(String text, int key, Alphabet alphabet) {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            int originalIndex = alphabet.getIndexOfChar(c);
            if (originalIndex == -1) {
                decryptedText.append(c);  // Символы, которых нет в алфавите, не изменяются
            } else {
                // Для декодирования используем отрицательный сдвиг
                int newIndex = (originalIndex - key + alphabet.getAlphabetLength()) % alphabet.getAlphabetLength();
                decryptedText.append(alphabet.getCharAtIndex(newIndex));
            }
        }

        return decryptedText.toString();
    }
}
