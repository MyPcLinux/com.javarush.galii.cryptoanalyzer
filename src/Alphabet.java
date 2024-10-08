import java.util.HashMap;
import java.util.Map;

public class Alphabet {
//    public static final String ALPHABET_RUS_TO_LOWER_CASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toLowerCase();
//    public static final String ALPHABET_RUS_TO_UPPERCASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toUpperCase();
    private final Map<Character, Integer> charToIndexMap;
    private final Map<Integer, Character> indexToCharMap;
    private final char[] ALPHABET_RUS = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п',
            'р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    public Alphabet() {
        charToIndexMap = new HashMap<>();
        indexToCharMap = new HashMap<>();

        for (int i = 0; i < ALPHABET_RUS.length; i++) {
            charToIndexMap.put(ALPHABET_RUS[i], i);
            indexToCharMap.put(i, ALPHABET_RUS[i]);
        }
    }
    public int getIndexOfChar(char c) {
        return charToIndexMap.getOrDefault(c, -1);  // Возвращает индекс символа или -1, если символ не найден
    }
    public char getCharAtIndex(int index) {
        return indexToCharMap.getOrDefault(index, '?');  // Возвращает символ по индексу или '?' если не найден
    }

    public int getAlphabetLength() {
        return ALPHABET_RUS.length;
    }

//--------- for brute force -----------------------
//    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
//            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
//            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');
}


