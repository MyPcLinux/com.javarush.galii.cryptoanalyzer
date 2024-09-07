public class ScannerAlphabet {
     static int findCharInAlphabet(char symbol, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) {
                return i;
            }
        }
        return -1; // Если символ не найден в алфавите
    }
}
