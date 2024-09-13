package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    public static void saveFileOnDisk(String data){
        // СОХРАНЯЕТ ФАЙЛ НА ДИСК

        try {
            FileWriter fileWriter = new FileWriter("encrypted.txt");
            fileWriter.write(data);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
