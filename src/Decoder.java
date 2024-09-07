public class Decoder {
    public static String decoder(String inputStringToDecoding, int key) {
        //условие if решает проблему не работающего ключа со значением кратным 26 == 0
        if (key % 26 == 0) {
            key++;
        }

        // сдвигаем ключ в обратную сторону я тупой здесь два часа думал
        key = -key;

        char[] symbol = new char[inputStringToDecoding.length()];

        for (int i = 0; i < inputStringToDecoding.length(); i++) {

            // Проверяем, является ли символ буквой и заглавной
            if (Character.isLetter(inputStringToDecoding.charAt(i)) && Character.isUpperCase(inputStringToDecoding.charAt(i))) {
                // Декодируем заглавные буквы
                symbol[i] = (char) (((((int) (inputStringToDecoding.charAt(i))) - 65 + key) % 26 + 26) % 26 + 65);
            }
            // Проверяем, является ли символ строчной буквой
            else if (Character.isLetter(inputStringToDecoding.charAt(i)) && Character.isLowerCase(inputStringToDecoding.charAt(i))) {
                // Декодируем строчные буквы
                symbol[i] = (char) (((((int) (inputStringToDecoding.charAt(i))) - 97 + key) % 26 + 26) % 26 + 97);
            } else {
                // Если символ не буква, просто копируем его
                symbol[i] = inputStringToDecoding.charAt(i);
            }
        }
        // Преобразуем массив символов в строку
        String strDecrypted = String.copyValueOf(symbol);
        return strDecrypted;
    }
}
