//public class Encoding {
//
//    public static String encoding(String textToCoding, int Key){
//        textToCoding = textToCoding.toLowerCase();
//        String textAlreadyEncoded = "";
//
//        for (int i = 0; i < textToCoding.length(); i++) {
//            int charIndex = Alphabet.ALPHABET_ENG.indexOf(textToCoding.charAt(i));
//            int newIndex = (charIndex + Key) % 26;
//            //cipherChar - закодированый символ
//            char cipherChar = Alphabet.ALPHABET_ENG.charAt(newIndex);
//            textAlreadyEncoded = textAlreadyEncoded + cipherChar;
//        }
//        return textAlreadyEncoded;
//    }
//}
