package service;


import utils.FileSaver;

import java.io.File;

public class Encryptor {

    // ЭТОМУ МЕТОДУ НУЖЕН ФАЙЛ КОТОРЫЙ ШИФРУЕМ ИЛИ СОДЕРЖИМОЕ ЭТОГО ФАЙЛА
    public static void encrypt(File file) {
        // ЗДЕСЬ ПРОИСХОДИТ ШИФРОВАНИЕ
        // ЧИТАЕМ ФАЙЛ, ШИФРУЕМ СОДЕРЖИМОЕ
        // И ПЕРЕДАЕМ ДАЛЬШЕ - В МЕТОД ДЛЯ СОХРАНЕНИЯ НОВОГО ФАЙЛА
        // С РЕЗУЛЬТАТОМ
        String encryptionResult = "Результат шифрования";

        FileSaver.saveFileOnDisk(encryptionResult);
    }

}
