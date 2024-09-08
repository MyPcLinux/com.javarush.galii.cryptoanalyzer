import coder_decoder.Coder;
import coder_decoder.Decoder;
import constants.Alphabet;

import java.util.Scanner;

public class Runner {
  public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        mainMethodRunnProgram();
    }

    private static void mainMethodRunnProgram() {
        System.out.print("Добрый день вас приветствует программа \"Шифр Цезаря\"\n ");

        System.out.print("Введите язык который хотите закодировать 1 русский, 2 английский :");

        int inputKey1 = scan.nextInt();//когда вы используете nextInt(), он оставляет символ новой строки (\n)
        scan.nextLine(); // Очищаем строку после nextInt()

        if(inputKey1 == 1){
            System.out.println("* Вы выбрали русский язык ввода.");
            System.out.println("Введите текст который хотите закодировать: ");
            String inputString = scan.nextLine();

            System.out.print("Введите ключ шага для кодирования текста: ");
            int inputKey = scan.nextInt();

            String resultEncoding = Coder.coder(inputString, inputKey, Alphabet.cyrillicAlphabet);

            System.out.println("Ваш закодированный текст - " + resultEncoding);
            System.out.println("Ваш декодированный текст - " + Decoder.decoder(resultEncoding, inputKey, Alphabet.cyrillicAlphabet));

        } else if (inputKey1 == 2) {
            System.out.println("* Вы выбрали английский язык ввода.");

            System.out.println("Введите текст который хотите закодировать: ");
            String inputString = scan.nextLine();

            System.out.print("Введите ключ шага для кодирования текста: ");
            int inputKey = scan.nextInt();

            String resultEncoding = Coder.coder(inputString, inputKey, Alphabet.latinAlphabet);

            System.out.println("Ваш закодированный текст - " + resultEncoding);

            System.out.println("Ваш декодированный текст - " + Decoder.decoder(resultEncoding, inputKey, Alphabet.latinAlphabet));
        }else{
                System.out.print("Вы ввели что то другое. Пожлуйста перезапустите программу");
        }
    }
}
