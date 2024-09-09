package tmp;

public class CoderRusEng {
    public static String coderMethod(String inputText, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char inputTextChar = inputText.charAt(i);

            //-------------Шифрование для английских букв--------------------------

            if (Character.isLetter(inputTextChar)) {
                if (inputTextChar >= 'A' && inputTextChar <= 'Z') {
                    char shiftedChar = (char) (((inputTextChar - 'A' + key) % 26 + 26) % 26 + 'A');
                    result.append(shiftedChar);
                } else if (inputTextChar >= 'a' && inputTextChar <= 'z') {
                    char shiftedChar = (char) (((inputTextChar - 'a' + key) % 26 + 26) % 26 + 'a');
                    result.append(shiftedChar);
                }
                //------------Шифрование для русских букв-------------------------
                else if (inputTextChar >= 'А' && inputTextChar <= 'Я') {
                    char shiftedChar = (char) (((inputTextChar - 'А' + key) % 32 + 32) % 32 + 'А');
                    result.append(shiftedChar);
                } else if (inputTextChar >= 'а' && inputTextChar <= 'я') {
                    char shiftedChar = (char) (((inputTextChar - 'а' + key) % 32 + 32) % 32 + 'а');
                    result.append(shiftedChar);
                } else {
                    result.append(inputTextChar); // Прочие символы остаются без изменений
                }
            } else {
                result.append(inputTextChar); // Прочие символы остаются без изменений
            }
        }
        return result.toString();
    }
}
