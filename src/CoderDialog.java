import java.io.File;
import java.util.Scanner;

public class CoderDialog {


    //Кодируем файл
    public static void coderDialog() {
        Alphabet alphabet = new Alphabet();
        Scanner inputScanner = new Scanner(System.in);

        // Получаем входной файл
        File inputFile = getFileFromUser(inputScanner, Constants.INPUT_PATH_TO_CODE_FILE, true);

        // Получаем выходной файл
        File outputFile = getFileFromUser(inputScanner, Constants.INPUT_PATH_TO_SAVE_FILE, false);

        // Получаем ключ для шифра
        int inputKey = getCipherKey(inputScanner);

        // Вызываем метод для шифрования файла
        CoderDecoder.encryptFile(inputFile, outputFile, inputKey, alphabet);
        System.out.println(Constants.FILE_SUCCESSFULLY_ENCRYPTED);
    }

    // Метод для получения файла от пользователя
    static File getFileFromUser(Scanner inputValueScanner, String message, boolean inputFile) {
        File file = null;
        boolean validPath = false;

        while (!validPath) {
            System.out.print(message);
            String filePath = inputValueScanner.nextLine();
            file = new File(filePath);

            if (inputFile) { // Если это входной файл
                if (!file.exists()) {
                    System.out.println(Constants.ERROR_FILE_NOT_FOUND);
                } else if (!file.isFile()) {
                    System.out.println(Constants.ERROR_IT_IS_NOT_FILE);
                } else if (!filePath.endsWith(".txt")) {
                    System.out.println(Constants.ERROR_INCORRECT_EXTENSION);
                } else {
                    validPath = true;
                }
            } else { // Если это выходной файл
                if (!filePath.endsWith(".txt")) {
                    System.out.println(Constants.ERROR_INCORRECT_EXTENSION);
                } else if (file.exists() && !file.canWrite()) {
                    System.out.println(Constants.ERROR_NO_RIGHTS_TO_WRITE_THE_FILE);
                } else {
                    validPath = true;
                }
            }
        }
        return file;
    }
    // Метод для получения ключа шифра
    static int getCipherKey(Scanner inputValueScanner) {
        int key = 0;
        boolean validKey = false;

        while (!validKey) {
            System.out.print(Constants.INPUT_VALUE_KEY);
            if (inputValueScanner.hasNextInt()) {
                key = inputValueScanner.nextInt();
                inputValueScanner.nextLine(); // Очищаем сканер
                if (key >= 1 && key <= 33) {
                    validKey = true;
                } else {
                    System.out.println(Constants.ERROR_INPUT_VALUE_KEY);
                }
            } else {
                System.out.println(Constants.ERROR_KEY_NOT_CORRECT);
                inputValueScanner.next(); // Пропускаем некорректный ввод
            }
        }
        return key;
    }
}
