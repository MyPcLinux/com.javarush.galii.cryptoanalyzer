import java.util.HashMap;
import java.util.Map;

public class Cipher {
    private final char[] alphabet;
    private final Map<Character, Integer> charPositionMap; // Для быстрого поиска позиции символа

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
        this.charPositionMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            charPositionMap.put(alphabet[i], i); // Создаем карту символ -> индекс
        }
    }
    //Метод кодирует текст по ключу
    public String encrypt(String text, int inputKey) {
        return shiftText(text, inputKey);
    }
//Метод декодирует текст
    public String decrypt(String encryptedText, int negativeInputKey) {
        return shiftText(encryptedText, -negativeInputKey);
    }
// Сдвиг текста по ключу encrypt() или decrypt()
    private String shiftText(String text, int inputKey) {
        text = text.toLowerCase();
        char[] textArr = text.toCharArray();
        int alphabetLength = alphabet.length;

        for (int i = 0; i < textArr.length; i++) {
            char currentChar = textArr[i];

            // Пропускаем символы, которых нет в алфавите (например, пробелы, знаки препинания)
            if (!charPositionMap.containsKey(currentChar)) {
                continue;
            }

            int charPosition = charPositionMap.get(currentChar);
            int shiftedPosition = (charPosition + inputKey) % alphabetLength;

            // Если позиция стала отрицательной, добавляем длину алфавита
            if (shiftedPosition < 0) {
                shiftedPosition += alphabetLength;
            }

            textArr[i] = alphabet[shiftedPosition];
        }
        return String.valueOf(textArr);
    }
}
