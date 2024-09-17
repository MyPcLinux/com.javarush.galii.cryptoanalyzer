import java.io.File;
import java.util.Scanner;

public class CoderDialog {
    private static final String INPUT_PATH_TO_CODE_FILE = "Введите путь к файлу, который хотите зашифровать (.txt): ";
    private static final String INPUT_PATH_TO_SAVE_FILE = "Введите путь для сохранения зашифрованного файла (.txt): ";
    private static final String FILE_SUCCESSFULLY_ENCRYPTED = "Файл успешно зашифрован.";

    //Кодируем файл
    public static void coderDialog() {
        Alphabet alphabet = new Alphabet();
        Scanner inputScanner = new Scanner(System.in);

        // Получаем входной файл
        File inputFile = getFileFromUser(inputScanner, INPUT_PATH_TO_CODE_FILE, true);

        // Получаем выходной файл
        File outputFile = getFileFromUser(inputScanner, INPUT_PATH_TO_SAVE_FILE, false);

        // Получаем ключ для шифра
        int inputKey = getCipherKey(inputScanner);

        // Вызываем метод для шифрования файла
        EncryptFileWithScanner.encryptFileWithScanner(inputFile, outputFile, inputKey, alphabet);
        System.out.println(FILE_SUCCESSFULLY_ENCRYPTED);
    }

    // Метод для получения файла от пользователя
    private static File getFileFromUser(Scanner inputValueScanner, String message, boolean inputFile) {
        File file = null;
        boolean validPath = false;

        while (!validPath) {
            System.out.print(message);
            String filePath = inputValueScanner.nextLine();
            file = new File(filePath);

            if (inputFile) { // Если это входной файл
                if (!file.exists()) {
                    System.out.println("Ошибка: Файл не найден.");
                } else if (!file.isFile()) {
                    System.out.println("Ошибка: Это не файл.");
                } else if (!filePath.endsWith(".txt")) {
                    System.out.println("Ошибка: Файл должен быть с расширением .txt.");
                } else {
                    validPath = true;
                }
            } else { // Если это выходной файл
                if (!filePath.endsWith(".txt")) {
                    System.out.println("Ошибка: Файл должен иметь расширение .txt.");
                } else if (file.exists() && !file.canWrite()) {
                    System.out.println("Ошибка: Нет прав для записи в файл.");
                } else {
                    validPath = true;
                }
            }
        }
        return file;
    }
    // Метод для получения ключа шифра
    private static int getCipherKey(Scanner inputValueScanner) {
        int key = 0;
        boolean validKey = false;

        while (!validKey) {
            System.out.print("Введите число от 1 до 100 для шифра Цезаря: ");
            if (inputValueScanner.hasNextInt()) {
                key = inputValueScanner.nextInt();
                inputValueScanner.nextLine(); // Очищаем сканнер
                if (key >= 1 && key <= 100) {
                    validKey = true;
                } else {
                    System.out.println("Ошибка: Число должно быть от 1 до 100.");
                }
            } else {
                System.out.println("Ошибка: Введите корректное число.");
                inputValueScanner.next(); // Пропускаем некорректный ввод
            }
        }
        return key;
    }
}
