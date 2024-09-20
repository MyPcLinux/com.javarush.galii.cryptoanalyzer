import java.io.*;
import java.util.Scanner;

public class CoderDecoder {
    // Метод для чтения файла с помощью Scanner
    public static void encryptFile(File inputFile, File outputFile, int inputKey, Alphabet alphabet) {
        try (Scanner scanner = new Scanner(inputFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Считываем данные построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Шифруем каждую строку
                String encryptedLine = encrypt(line, inputKey, alphabet);

                // Записываем зашифрованную строку в выходной файл
                writer.write(encryptedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println(Constants.PROCESSING_ERROR + e.getMessage());
        }
    }
//     Метод шифрования строки/ дешифрования строки
    public static String encrypt(String text, int key, Alphabet alphabet) {
        StringBuilder result = new StringBuilder();

        // Проходим по каждому символу текста
        for (char c : text.toCharArray()) {
            int originalIndex = alphabet.getIndexOfChar(c);  // Получаем индекс символа в алфавите

            // Если символ не найден в алфавите, оставляем его без изменений
            if (originalIndex == -1) {
                result.append(c);
            } else {
                // Вычисляем новый индекс с учетом сдвига ключа
                int newIndex = (originalIndex + key) % alphabet.getAlphabetLength();

                // Корректируем отрицательный индекс (если шифруем с отрицательным ключом)
                if (newIndex < 0) {
                    newIndex += alphabet.getAlphabetLength();
                }

                // Добавляем новый символ в результат
                result.append(alphabet.getCharAtIndex(newIndex));
            }
        }
        return result.toString();
    }
}
