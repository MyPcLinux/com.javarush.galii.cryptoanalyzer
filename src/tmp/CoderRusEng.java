package tmp;

public class CoderRusEng {
    public static String coderMethod(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Шифрование для английских букв
            if (Character.isLetter(ch)) {
                if (ch >= 'A' && ch <= 'Z') {
                    char shiftedChar = (char) (((ch - 'A' + key) % 26 + 26) % 26 + 'A');
                    result.append(shiftedChar);
                } else if (ch >= 'a' && ch <= 'z') {
                    char shiftedChar = (char) (((ch - 'a' + key) % 26 + 26) % 26 + 'a');
                    result.append(shiftedChar);
                }
                // Шифрование для русских букв
                else if (ch >= 'А' && ch <= 'Я') {
                    char shiftedChar = (char) (((ch - 'А' + key) % 32 + 32) % 32 + 'А');
                    result.append(shiftedChar);
                } else if (ch >= 'а' && ch <= 'я') {
                    char shiftedChar = (char) (((ch - 'а' + key) % 32 + 32) % 32 + 'а');
                    result.append(shiftedChar);
                } else {
                    result.append(ch); // Прочие символы остаются без изменений
                }
            } else {
                result.append(ch); // Прочие символы остаются без изменений
            }
        }
        return result.toString();
    }
}
