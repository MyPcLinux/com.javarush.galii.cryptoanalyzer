import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EncryptFileWithScanner {
    // Метод для чтения файла с помощью Scanner
    public static void encryptFileWithScanner(File inputFile, File outputFile, int key, Alphabet alphabet) {
        try (Scanner scanner = new Scanner(inputFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Считываем данные построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Шифруем каждую строку
                String encryptedLine = encrypt(line, key, alphabet);

                // Записываем зашифрованную строку в выходной файл
                writer.write(encryptedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
//     Метод шифрования строки
    public static String encrypt(String text, int key, Alphabet alphabet) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            int originalIndex = alphabet.getIndexOfChar(c);
            if (originalIndex == -1) {
                encryptedText.append(c);  // Символы, которых нет в алфавите, не изменяются
            } else {
                int newIndex = (originalIndex + key) % alphabet.getAlphabetLength();
                encryptedText.append(alphabet.getCharAtIndex(newIndex));
            }
        }
        return encryptedText.toString();
    }

}
