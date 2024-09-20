import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BruteForceDialog {

    // Метод для дешифрования текста с русским алфавитом
    public static String caesarDecryptRussian(String ciphertext, int key) {
        StringBuilder decryptedText = new StringBuilder();
        String alphabetLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"; // Строчные русские буквы
        String alphabetUpper = alphabetLower.toUpperCase();         // Заглавные русские буквы

        int alphabetLength = alphabetLower.length();  // Длина русского алфавита (33 символа)

        for (int i = 0; i < ciphertext.length(); i++) {
            char character = ciphertext.charAt(i);

            // Если символ - это строчная буква русского алфавита
            if (alphabetLower.indexOf(character) != -1) {
                int originalPos = alphabetLower.indexOf(character);
                int newPos = (originalPos - key + alphabetLength) % alphabetLength;
                decryptedText.append(alphabetLower.charAt(newPos));
            }
            // Если символ - это заглавная буква русского алфавита
            else if (alphabetUpper.indexOf(character) != -1) {
                int originalPos = alphabetUpper.indexOf(character);
                int newPos = (originalPos - key + alphabetLength) % alphabetLength;
                decryptedText.append(alphabetUpper.charAt(newPos));
            }
            // Прочие символы остаются без изменений (пробелы, знаки препинания и т.д.)
            else {
                decryptedText.append(character);
            }
        }
        return decryptedText.toString();
    }

    // Метод brute force для перебора всех ключей от 1 до 32
    public static void bruteForce(String filePath) {
        try {
            // Чтение содержимого файла в строку
            String ciphertext = new String(Files.readAllBytes(Paths.get(filePath)));

            // Перебор ключей от 1 до 32 (для русского алфавита)
            for (int key = 1; key <= 32; key++) {
                String decryptedText = caesarDecryptRussian(ciphertext, key);
                System.out.println("Key " + key + ": " + decryptedText);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
