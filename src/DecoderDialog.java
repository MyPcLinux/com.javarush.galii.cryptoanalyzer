import java.io.*;
import java.util.Scanner;

public class DecoderDialog {
    // Метод декодирует файл
    public static void decoderDialog() {

        Alphabet alphabet = new Alphabet();
        Scanner inputScanner = new Scanner(System.in);

        // Получаем входной файл
        File inputFile = CoderDialog.getFileFromUser(inputScanner, Constants.INPUT_PATH_TO_DECODE_FILE, true);

        // Получаем выходной файл
        File outputFile = CoderDialog.getFileFromUser(inputScanner, Constants.INPUT_PATH_TO_SAVE_FILE, false);

        // Получаем ключ для шифра и присваиваем ему отрицательное значение
        int inputKey = CoderDialog.getCipherKey(inputScanner);
        int negativeInputKey = -inputKey;

        // Вызываем метод для декодирования файла (ключ с отрицательным значением)
        CoderDecoder.encryptFile(inputFile, outputFile, negativeInputKey, alphabet);
        System.out.println(Constants.FILE_DECODED);
    }
}
