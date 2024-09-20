import java.util.Scanner;
// Путь к файлам для проверки
//  src/tmp/rusNormalText.txt
//  src/tmp/rusCoded.txt
//  src/tmp/rusDecoded.txt
public class Start {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;
        boolean correctNumber = false;
//Проверка на корректный выбор действия 1 - кодируем, 2 - декодируем, 3 - перебор ключа (brute-force)
        while (!correctNumber) {
            System.out.println(Constants.CHOICE_MODE);
            System.out.print(Constants.MODE_1_2);

if (sc.hasNextInt()) {
    inputNum = sc.nextInt();
    if (inputNum >= 1 && inputNum <= 3) {
        correctNumber = true; // Число корректное, выходим из цикла
    } else {
        System.out.println(Constants.ERROR_INPUT_1_2);
    }
}else {
        // Если введено не число, выводим сообщение об ошибке
        System.out.println(Constants.ERROR_INPUT_VALUE_KEY);
        sc.next(); // Пропускаем некорректный ввод
    }
}
        if(inputNum == 1){
            //-----------Процесс кодирования-------------------------
            System.out.println(Constants.MODE_CODDING);
            CoderDialog.coderDialog();
        }if (inputNum == 2){
            //-----------Процесс декодирования-------------------------
            System.out.println(Constants.MODE_DECODING);
            DecoderDialog.decoderDialog();
        }else{
            //-----------Режим подбора ключа - brute force-------------
            System.out.println(Constants.MODE_BRUTE_FORCE);
            BruteForceDialog.bruteForceDialog("src//tmp//rusCoded.txt");
        }
    }
}
