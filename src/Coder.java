public class Coder {
    public static String coder(String inputStringToCoding, int key) {
//условие if решает проблему не работающего ключа со значением кратным 26 == 0
        if(key % 26 == 0){key ++;}

        char[] symbol = new char[inputStringToCoding.length()];

        for (int i = 0; i < inputStringToCoding.length(); i++) {

            // В условии проверяем является ли перебираемый inputStringToCoding буквой и isUpperCase регистром
            if(Character.isLetter(inputStringToCoding.charAt(i)) && Character.isUpperCase(inputStringToCoding.charAt(i))){
                //charAt(i) - обращение к каждому символу в symbol[i]
                //(char) ((int)(inputStringToCoding.charAt(i) + key)) - char to int(нужен для сложения ключа) to char
                //эта кострукция зацикливает алфавит больших символов(65) - не дает ключу выйти в аэроглифы
                symbol[i] = (char) (((((int)(inputStringToCoding.charAt(i))) - 65 + key ) % 26) + 65);
            }
            // --- и isLowerCase регистром
            else if (Character.isLetter(inputStringToCoding.charAt(i)) && Character.isLowerCase(inputStringToCoding.charAt(i))){
                //эта кострукция зацикливает алфавит маленьких символов(97) - не дает ключу выйти в аэроглифы
                symbol[i] = (char) (((((int)(inputStringToCoding.charAt(i))) - 97 + key ) % 26) + 97);
            }else {
                symbol[i] = inputStringToCoding.charAt(i);
            }

        }
//        System.out.println(symbol);// это массив символов
        String strCrypted = String.copyValueOf(symbol);// стринг
       return strCrypted;

//        System.out.println("Оригинал предложение - " + " \"" + inputStringToCoding + "\"");
//        System.out.println("Закодированное предложение с ключем смещения = "+ key + " \"" + strCrypted + "\"");
    }
}
