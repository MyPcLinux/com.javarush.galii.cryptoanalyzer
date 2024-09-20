import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BruteForceDialog {
    // Метод для дешифрования текста с помощью заданного ключа
    public static String caesarDecrypt(String ciphertext, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char character = ciphertext.charAt(i);

            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int decryptedChar = (character - base - key + 26) % 26 + base;  // Смещение символа
                decryptedText.append((char) decryptedChar);
            } else {
                decryptedText.append(character);  // Пропуск символов, не являющихся буквами
            }
        }
        return decryptedText.toString();
    }

    // Метод brute force для перебора всех возможных ключей от 1 до 99
    public static void bruteForceDialog(String filePath) {
        try {
            // Чтение содержимого файла в строку
            String ciphertext = new String(Files.readAllBytes(Paths.get(filePath)));

            // Перебор ключей от 1 до 99
            for (int key = 1; key <= 25; key++) {
                String decryptedText = caesarDecrypt(ciphertext, key);
                System.out.println("Key " + key + ": " + decryptedText);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
