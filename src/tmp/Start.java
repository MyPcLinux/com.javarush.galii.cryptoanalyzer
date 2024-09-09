package tmp;

import java.io.File;
import java.util.Scanner;

import static tmp.EncryptFileWithScanner.encryptFileWithScanner;

public class Start {
    public static void main(String[] args) {
        // Используем Scanner для ввода пути к файлу
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Введите путь к текстовому файлу: ");
        String filePath = inputScanner.nextLine();

        System.out.print("Введите путь для сохранения файла: ");
        String outputFilePath = inputScanner.nextLine();

        System.out.print("Введите сдвиг для шифра Цезаря: ");
        int inputKey = inputScanner.nextInt();

        // Создаем объект File на основе введенного пути
        File inputFile = new File(filePath);
        File outputFile = new File(outputFilePath);
        // Вызываем метод для шифрования файла
        encryptFileWithScanner(inputFile, outputFile, inputKey);
    }
}
