package coder_decoder;

import utils.ScannerAlphabet;

public class Coder {
    // Метод для кодирования строки с использованием заданного алфавита
    public static String coder(String inputStringToCoding, int key, char[] alphabet) {
        int alphabetLength = alphabet.length;
        char[] symbol = new char[inputStringToCoding.length()];

        for (int i = 0; i < inputStringToCoding.length(); i++) {
            char currentChar = inputStringToCoding.charAt(i);

            // Используем кастомный метод для поиска символа в алфавите
            int index = ScannerAlphabet.findCharInAlphabet(currentChar, alphabet);

            if (index != -1) { // Символ найден в алфавите
                // Рассчитываем новый индекс с учётом сдвига и зацикливания
                int newIndex = (index + key) % alphabetLength;
                if (newIndex < 0) {
                    newIndex += alphabetLength; // Зацикливание на случай отрицательного индекса
                }
                symbol[i] = alphabet[newIndex];
            } else {
                // Если символ не из алфавита, оставляем его без изменений
                symbol[i] = currentChar;
            }
        }
        // Преобразуем массив символов в строку и возвращаем
        return String.copyValueOf(symbol);
    }
}