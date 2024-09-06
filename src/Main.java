import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String randomStr = "Hello world"; // Input point того что нужно кодировать
        //ключ кратный 26 == 0
        int key = 52;// ключ смещения вывести вопрос в Scanner


        coder(randomStr, key);
    }
    private static void coder(String strInput, int key) {
//условие if решает проблему не работающего ключа со значением кратным 26 == 0
        if(key % 26 == 0){key ++;}

        char[] symbol = new char[strInput.length()];

        for (int i = 0; i < strInput.length(); i++) {

            // В условии проверяем является ли перебираемый strInput буквой и isUpperCase регистром
            if(Character.isLetter(strInput.charAt(i)) && Character.isUpperCase(strInput.charAt(i))){
                //charAt(i) - обращение к каждому символу в symbol[i]
                //(char) ((int)(strInput.charAt(i) + key)) - char to int(нужен для сложения ключа) to char
                //эта кострукция зацикливает алфавит больших символов(65) - не дает ключу выйти в аэроглифы
                symbol[i] = (char) (((((int)(strInput.charAt(i))) - 65 + key ) % 26) + 65);
            }
            // --- и isLowerCase регистром
            else if (Character.isLetter(strInput.charAt(i)) && Character.isLowerCase(strInput.charAt(i))){
                //эта кострукция зацикливает алфавит маленьких символов(97) - не дает ключу выйти в аэроглифы
                symbol[i] = (char) (((((int)(strInput.charAt(i))) - 97 + key ) % 26) + 97);
            }else {
                symbol[i] = strInput.charAt(i);
            }

        }
//        System.out.println(symbol);// это массив символов
        String strCrypted = String.copyValueOf(symbol);// стринг

        System.out.println("Оригинал предложение - " + " \"" + strInput + "\"");
        System.out.println("Закодированное предложение с ключем смещения = "+ key + " \"" + strCrypted + "\"");
    }
}