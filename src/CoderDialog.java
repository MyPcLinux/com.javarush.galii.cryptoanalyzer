import java.io.File;
import java.util.Scanner;

public class CoderDialog {
    //Кодируем файл
    public static void coderDialog() {
        Alphabet alphabet = new Alphabet();
        Scanner inputScanner = new Scanner(System.in);

        // Получаем входной файл
        File inputFile = getFileFromUser(inputScanner, "Введите путь к файлу, который хотите зашифровать (.txt): ", true);

        // Получаем выходной файл
        File outputFile = getFileFromUser(inputScanner, "Введите путь для сохранения зашифрованного файла (.txt): ", false);

        // Получаем ключ для шифра
        int inputKey = getCipherKey(inputScanner);

        // Вызываем метод для шифрования файла
        EncryptFileWithScanner.encryptFileWithScanner(inputFile, outputFile, inputKey, alphabet);
        System.out.println("Файл успешно зашифрован.");
    }

    // Метод для получения файла от пользователя
    private static File getFileFromUser(Scanner scanner, String message, boolean inputFile) {
        File file = null;
        boolean validPath = false;

        while (!validPath) {
            System.out.print(message);
            String filePath = scanner.nextLine();
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
    private static int getCipherKey(Scanner scanner) {
        int key = 0;
        boolean validKey = false;

        while (!validKey) {
            System.out.print("Введите число от 1 до 100 для шифра Цезаря: ");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                scanner.nextLine(); // Очищаем сканнер
                if (key >= 1 && key <= 100) {
                    validKey = true;
                } else {
                    System.out.println("Ошибка: Число должно быть от 1 до 100.");
                }
            } else {
                System.out.println("Ошибка: Введите корректное число.");
                scanner.next(); // Пропускаем некорректный ввод
            }
        }
        return key;
    }
//    public static void coderDialog() {
//
//        Alphabet alphabet = new Alphabet();
//
//        Scanner inputScanner = new Scanner(System.in);
//        File inputFile = null;
//        boolean correctPath = false;
//
////----- Проверка, существует ли файл, является ли он файлом и имеет ли расширение .txt-------
//        while (!correctPath){
//            System.out.print("Введите путь к файлу который хотите зашивовать : ");
//            String filePath = inputScanner.nextLine();
//            inputFile = new File(filePath);
//
//            if (!inputFile.exists()) {
//                System.out.println("Ошибка: Файл не найден. Проверьте правильность пути.");
//            } else if (!inputFile.isFile()) {
//                System.out.println("Ошибка: Указанный путь не является файлом.");
//            } else if (!filePath.endsWith(".txt")) {
//                System.out.println("Ошибка: Файл не имеет расширения .txt.");
//            } else {
//                System.out.println("Файл найден и имеет корректное расширение: " + inputFile.getPath());
//                correctPath = true;// Завершаем цикл, если файл корректен
//            }
//        }
//
////---------------------------- Проверка файла перед записью-----------------------
//        File outputFile = null;
//        boolean correctPathToSave = false;
//
//        while (!correctPathToSave) {
//            System.out.print("Введите путь для сохранения файла: ");
//            String outputFilePath = inputScanner.nextLine();
//            outputFile = new File(outputFilePath);
//// было бы не плохо создать проверку на создание только .txt файлов, но код увеличится
//            if (!outputFile.exists()) {
//                System.out.println("Файл " + outputFile.getPath() + " создан");
//                correctPathToSave = true;
//            } else if (!inputFile.isFile()) {
//                System.out.println("Ошибка: Указанный путь не является файлом.");
//            } else if (!inputFile.canWrite()) {
//                System.out.println("Ошибка: Нет прав на запись в файл.");
//            } else if (!outputFilePath.endsWith(".txt")) {
//                System.out.println("Ошибка: Файл должен иметь расширение .txt.");
//            } else {
//                System.out.println("Файл найден, и он доступен для записи.");
//                correctPathToSave = true;
//            }
//        }
//
////---------------Проверка ввода числа от 1 до 100 ---------------------------------
//
//        int inputKey = 0; // создали переменую для сохранения в ней числа ввода
//        boolean correctNumber = false;
//
//        // Цикл для запроса корректного числа от 1 до 100
//        while (!correctNumber) {
//
//            System.out.print("Введите число от 0 до 100 для шифра Цезаря: ");
//            // Проверяем, ввел ли пользователь целое число
//            if (inputScanner.hasNextInt()) {
//                inputKey = inputScanner.nextInt();
//
//                // Проверяем, находится ли число в диапазоне от 1 до 100
//                if (inputKey >= 1 && inputKey <= 100) {
//                    correctNumber = true; // Число корректное, выходим из цикла
//                } else {
//                    System.out.println("Ошибка: Число должно быть от 1 до 100. Попробуйте снова.");
//                }
//            } else {
//                // Если введено не число, выводим сообщение об ошибке
//                System.out.println("Ошибка: Введено некорректное значение. Введите число от 1 до 100.");
//                inputScanner.next(); // Пропускаем некорректный ввод
//            }
//        }
//        System.out.println("Вы ввели корректное число: " + inputKey);
//
//            // Вызываем метод для шифрования файла
//        EncryptFileWithScanner.encryptFileWithScanner(inputFile, outputFile, inputKey, alphabet);
//    }
}
