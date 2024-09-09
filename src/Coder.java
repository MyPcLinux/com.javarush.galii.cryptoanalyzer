import java.io.File;
import java.util.Scanner;

public class Coder {
    public static String coderMethod(String inputText, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char inputTextChar = inputText.charAt(i);

            //-------------Шифрование для английских букв--------------------------

            if (Character.isLetter(inputTextChar)) {
                if (inputTextChar >= 'A' && inputTextChar <= 'Z') {
                    char shiftedChar = (char) (((inputTextChar - 'A' + key) % 26 + 26) % 26 + 'A');
                    result.append(shiftedChar);
                } else if (inputTextChar >= 'a' && inputTextChar <= 'z') {
                    char shiftedChar = (char) (((inputTextChar - 'a' + key) % 26 + 26) % 26 + 'a');
                    result.append(shiftedChar);
                }
                //------------Шифрование для русских букв-------------------------
                else if (inputTextChar >= 'А' && inputTextChar <= 'Я') {
                    char shiftedChar = (char) (((inputTextChar - 'А' + key) % 32 + 32) % 32 + 'А');
                    result.append(shiftedChar);
                } else if (inputTextChar >= 'а' && inputTextChar <= 'я') {
                    char shiftedChar = (char) (((inputTextChar - 'а' + key) % 32 + 32) % 32 + 'а');
                    result.append(shiftedChar);
                } else {
                    result.append(inputTextChar); // Прочие символы остаются без изменений
                }
            } else {
                result.append(inputTextChar); // Прочие символы остаются без изменений
            }
        }
        return result.toString();
    }

    public static void coderInfo() {
        // Используем Scanner для ввода пути к файлу
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу который хотите зашивовать : ");
        String filePath = inputScanner.nextLine();

        System.out.print("Введите путь для сохранения файла: ");
        String outputFilePath = inputScanner.nextLine();

        System.out.print("Введите сдвиг для шифра Цезаря: ");
        int inputKey = inputScanner.nextInt();

        // Создаем объект File на основе введенного пути
        File inputFile = new File(filePath);
        File outputFile = new File(outputFilePath);
        // Вызываем метод для шифрования файла
        EncryptFileWithScanner.encryptFileWithScanner(inputFile, outputFile, inputKey);

    }
}
