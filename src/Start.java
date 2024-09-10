import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        start();


    }
    private static void start() {
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;
        boolean correctNumber = false;
//Проверка на корректный выбор действия 1 или 2
        while (!correctNumber) {
            System.out.println("Выберите один из вариантов : ");
            System.out.print("1 - Кодируем файл, 2 - Декодируем файл : ");

if (sc.hasNextInt()) {
    inputNum = sc.nextInt();
    if (inputNum >= 1 && inputNum <= 2) {
        correctNumber = true; // Число корректное, выходим из цикла
    } else {
        System.out.println("Ошибка: Число должно быть от 1 до 2. Попробуйте снова.");
    }
}else {
        // Если введено не число, выводим сообщение об ошибке
        System.out.println("Ошибка: Введено некорректное значение. Введите число от 1 до 100.");
        sc.next(); // Пропускаем некорректный ввод
    }
}
        if(inputNum == 1){
            //-----------Процесс кодирования-------------------------
            System.out.println("Выбран режим кодирования.");
            CoderDialog.coderDialog();
        }else{
            //-----------Процесс декодирования-------------------------
            System.out.println("Выбран режим декодирования.");
            DecoderDialog.decoderDialog();
        }
    }
}
