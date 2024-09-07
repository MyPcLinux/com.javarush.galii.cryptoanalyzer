public class Alphabet {
    private static final String  ALPHABET_RU = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String ALPHABET_ENG =  "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = "!№;%:?*(){}";

    public static final String ALPHABET = ALPHABET_RU.toLowerCase() + ALPHABET_ENG.toLowerCase() + NUMERIC + SYMBOLS;

}
