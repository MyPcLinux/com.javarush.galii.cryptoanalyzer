public class Cipher {
    private final char[] alphabet;
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }
    public String encrypt(String text, int shift) {
        text = text.toLowerCase();
        char[] textArr = text.toCharArray();
        int charPosition = 0;
        for (int i = 0; i < textArr.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (textArr[i] == alphabet[j]) {
                    charPosition = j;
                    break;
                }
            }
            int result = charPosition + shift;
            if (result >= 40) {
                textArr[i] = alphabet[result - 40];
            } else if (result < 0) {
                textArr[i] = alphabet[result + 40];
            } else {
                textArr[i] = alphabet[result];
            }
        }
        return String.valueOf(textArr);
    }
    public String decrypt(String encryptedText, int shift) {
        encryptedText = encryptedText.toLowerCase();
        char[] textArr = encryptedText.toCharArray();
        int charPosition = 0;
        for (int i = 0; i < textArr.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (textArr[i] == alphabet[j]) {
                    charPosition = j;
                    break;
                }
            }
            int result = charPosition - shift;
            if (result < 0) {
                textArr[i] = alphabet[result + 40];
            } else if (result >= 40) {
                textArr[i] = alphabet[result - 40];
            } else {
                textArr[i] = alphabet[result];
            }
        }
        return String.valueOf(textArr);
    }
}