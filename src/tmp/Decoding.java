//public class Decoding {
//
//    public static String decoding(String textToDecoding, int Key){
//        textToDecoding = textToDecoding.toLowerCase();
//        String textAlreadyDecoded = "";
//
//        for (int i = 0; i < textToDecoding.length() ; i++) {
//            int charIndex = constants.Alphabet.ALPHABET_ENG.indexOf(textToDecoding.charAt(i));
//            int newIndex = (charIndex - Key) % 26;
//           //избежать отрицательных значений
//            if(newIndex < 0){
//                newIndex = constants.Alphabet.ALPHABET_ENG.length() + newIndex;
//            }
//            //plainChar - обычный символ
//            char plainChar = constants.Alphabet.ALPHABET_ENG.charAt(newIndex);
//            textAlreadyDecoded = textAlreadyDecoded + plainChar;
//        }
//        return textAlreadyDecoded;
//    }
//}
