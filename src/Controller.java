import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;

public class Controller {
    @FXML
    private TextField encrypterKey;

    @FXML
    private TextField decrypterKey;

    @FXML
    private Label decryptedProblem;

    @FXML
    private Label encryptedProblem;

    @FXML
    protected void selectFileOnClick() {
        decryptedProblem.setText("");
        encryptedProblem.setText("");
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(MainApplication.getStage());
        FileManager.setFile(file);
    }

    @FXML
    protected void encryptOnClick() {
        encryptedProblem.setText("");
        String key = encrypterKey.getText();
        encrypterKey.setText("");
        if (!Validator.isFileExists()) {
            encryptedProblem.setText("Choose File!");
            return;
        } else if (!Validator.isValidKey(key, Alphabet.getAlphabet())) {
            encryptedProblem.setText("Write another key!");
            return;
        }
        FileManager fileManager = new FileManager();
        String path = FileManager.getFile().toString();
        Cipher encrypter = new Cipher(Alphabet.getAlphabet());
        String text = fileManager.readFile(path);
        String encrypted = encrypter.encrypt(text, Integer.parseInt(key));
        fileManager.writeFile(encrypted, path.replace(FileManager.getFile().getName(), "Encrypted.txt"));
        FileManager.setFile(null);
    }

    @FXML
    protected void decryptOnClick() {
        decryptedProblem.setText("");
        String key = decrypterKey.getText();
        decrypterKey.setText("");
        if (!Validator.isFileExists()) {
            decryptedProblem.setText("Choose File!");
            return;
        } else if (!Validator.isValidKey(key, Alphabet.getAlphabet())) {
            decryptedProblem.setText("Write another key!");
            return;
        }
        FileManager fileManager = new FileManager();
        String path = FileManager.getFile().toString();
        Cipher decrypter = new Cipher(Alphabet.getAlphabet());
        String text = fileManager.readFile(path);
        String decrypted = decrypter.decrypt(text, Integer.parseInt(key));
        fileManager.writeFile(decrypted, path);
        FileManager.setFile(null);
    }
}

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Controller {
//    // обработка событий в файле .fxml
//    @FXML
//    private Button button;
//    File file;
//    // Привязываем текстовое поле из FXML
//    @FXML
//    private TextField inputFieldCoder;
//    @FXML
//    private TextField inputFieldDecoder;
//
//    // Кнопка "Выбрать файл" (работает для шифрования и дешифрования)
//    @FXML
//    protected  void onOpenFileButtonClick(){
//        // ПО НАЖАТИЮ НА КНОПКУ "ОТКРЫТЬ ФАЙЛ" ИЗ ИНТЕРФЕЙСА (fxml)
//        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onOpenFileButtonClick()
//        FileChooser fileChooser = new FileChooser();
//        // УСТАНАВЛИВАЕМ ЗАГОЛОВОК ОКНА
//        fileChooser.setTitle("ОТКРЫТЬ ФАЙЛ");
//        // В МОМЕНТ ВЫБОРА ФАЙЛА ПУТЬ К НЕМУ ЗАПИШЕТСЯ В ПЕРЕМЕННУЮ file
//        file = fileChooser.showOpenDialog(new Stage());
//
//        // ВЫВОДИМ ИМЯ ФАЙЛА В КОНСОЛЬ, ИЛИ ИСПОЛЬЗУЕМ ПО НАЗНАЧЕНИЮ
//        System.out.println(file);
//    }
//    // Метод, который вызывается при вводе текста
//    public void inputFieldKey(ActionEvent inputKey) {
//
////        System.out.println("Введенный ключ - " + inputKey);
//    }
//
//    // Кнопка начать кодировать файл
//    @FXML
//    protected void coderButtonClick() {
//        System.out.println("coderButtonClick() - click");
//
//        // Получаем введённый текст из текстового поля inputFieldKey
//        String inputText = inputFieldCoder.getText();
//        System.out.println("Введённый ключ: " + inputText);
//
//        try{
//            FileWriter fileWriter = new FileWriter("coderText.txt");
//            fileWriter.write("Тест строки");
//            fileWriter.flush();
//        }catch (IOException exception){
//            throw new RuntimeException();
//        }
//
//    }
//
//    //-----------------Декодер------------------------------------
//
//
//    @FXML
//    protected void decoderButtonClick(){
//        System.out.println("decoderButtonClick() - click");
//
//        // Получаем введённый текст из текстового поля inputFieldKey
//        String inputText = inputFieldDecoder.getText();
//        System.out.println("Введённый ключ: " + inputText);
//    }
//}
