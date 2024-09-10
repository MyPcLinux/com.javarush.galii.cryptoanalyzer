import java.io.*;
import java.util.Scanner;

public class DecoderDialog {

    public static void decoderDialog() {
        // Ввод данных
        Scanner inputScanner = new Scanner(System.in);
        File inputFile = null;
        boolean correctPathDec = false;

        //----- Проверка, существует ли файл, является ли он файлом и имеет ли расширение .txt-------
        while (!correctPathDec){
            System.out.print("Введите путь к зашифрованному файлу: ");
            String filrPath = inputScanner.nextLine();
            inputFile = new File(filrPath);

            if (!inputFile.exists()) {
                System.out.println("Ошибка: Файл не найден. Проверьте правильность пути.");
            } else if (!inputFile.isFile()) {
                System.out.println("Ошибка: Указанный путь не является файлом.");
            } else if (!filrPath.endsWith(".txt")) {
                System.out.println("Ошибка: Файл не имеет расширения .txt.");
            } else {
                System.out.println("Файл найден и имеет корректное расширение: " + inputFile.getPath());
                correctPathDec = true;// Завершаем цикл, если файл корректен
            }
        }

 //---------------------------- Проверка файла перед записью-----------------------
        File outputFile = null;
        boolean correctPathToSave = false;

        while (!correctPathToSave) {
            System.out.print("Введите путь для сохранения в файл с расшифрованным текстом: ");
            String outputFilePath = inputScanner.nextLine();
            outputFile = new File(outputFilePath);
// было бы не плохо создать проверку на создание только .txt файлов, но код увеличится
            if (!outputFile.exists()) {
                System.out.println("Файл " + outputFile.getPath() + " создан");
                correctPathToSave = true;
            } else if (!inputFile.isFile()) {
                System.out.println("Ошибка: Указанный путь не является файлом.");
            } else if (!inputFile.canWrite()) {
                System.out.println("Ошибка: Нет прав на запись в файл.");
            } else if (!outputFilePath.endsWith(".txt")) {
                System.out.println("Ошибка: Файл должен иметь расширение .txt.");
            } else {
                System.out.println("Файл найден, и он доступен для записи.");
                correctPathToSave = true;
            }
        }

//---------------Проверка ввода числа от 1 до 100 ---------------------------------

        int inputKey = 0; // создали переменую для сохранения в ней числа ввода
        boolean correctNumber = false;

        // Цикл для запроса корректного числа от 1 до 100
        while (!correctNumber) {
            System.out.print("Введите ключ для расшифровки (такой же, как использовался для шифрования) ");
            System.out.print("Напоминаю число должно быть от 0 до 100: ");
            // Проверяем, ввел ли пользователь целое число
            if (inputScanner.hasNextInt()) {
                inputKey = inputScanner.nextInt();

                // Проверяем, находится ли число в диапазоне от 1 до 100
                if (inputKey >= 1 && inputKey <= 100) {
                    correctNumber = true; // Число корректное, выходим из цикла
                } else {
                    System.out.println("Ошибка: Число должно быть от 1 до 100. Попробуйте снова.");
                }
            } else {
                // Если введено не число, выводим сообщение об ошибке
                System.out.println("Ошибка: Введено некорректное значение. Введите число от 1 до 100.");
                inputScanner.next(); // Пропускаем некорректный ввод
            }
        }
        System.out.println("Вы ввели число: " + inputKey);

        // Вызываем метод для декодирования
       DecryptFileWithScanner.decryptFileWithScanner(inputFile, outputFile, inputKey);
    }
}

