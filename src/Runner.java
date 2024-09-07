import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите текст который хотите закодировать: ");
        String inputString = scan.nextLine();

        System.out.print("Введите ключ шага для кодирования текста: ");
        int inputKey = scan.nextInt();
        scan.close();
        String resultEncoding = Coder.coder(inputString, inputKey);

        System.out.println("Ваш закодированный текст - " + resultEncoding);

        System.out.println("Ваш декодированный текст - " + Decoder.decoder(resultEncoding, inputKey));


    }
}
