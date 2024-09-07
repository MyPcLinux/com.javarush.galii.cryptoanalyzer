public class Decoder {
    public static String decoder(String inputStringToDecoding, int key, char[] alphabet) {
        // Декодирование — это то же самое, что кодирование, но с отрицательным ключом
        return Coder.coder(inputStringToDecoding, -key, alphabet);
    }
}