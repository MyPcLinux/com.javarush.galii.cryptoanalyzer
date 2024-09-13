import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    // обработка событий в файле .fxml
    @FXML
    private Button button;
    File file;
    // Привязываем текстовое поле из FXML
    @FXML
    private TextField inputField;

    // Кнопка "Выбрать файл"
    @FXML
    protected  void onOpenFileButtonClick(){
        // ПО НАЖАТИЮ НА КНОПКУ "ОТКРЫТЬ ФАЙЛ" ИЗ ИНТЕРФЕЙСА (fxml)
        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onOpenFileButtonClick()
        FileChooser fileChooser = new FileChooser();
        // УСТАНАВЛИВАЕМ ЗАГОЛОВОК ОКНА
        fileChooser.setTitle("ОТКРЫТЬ ФАЙЛ");
        // В МОМЕНТ ВЫБОРА ФАЙЛА ПУТЬ К НЕМУ ЗАПИШЕТСЯ В ПЕРЕМЕННУЮ file
        file = fileChooser.showOpenDialog(new Stage());

        // ВЫВОДИМ ИМЯ ФАЙЛА В КОНСОЛЬ, ИЛИ ИСПОЛЬЗУЕМ ПО НАЗНАЧЕНИЮ
        System.out.println(file);
    }
    // Метод, который вызывается при вводе текста
    public void inputFieldKey(ActionEvent inputKey) {
        System.out.println("Введенный ключ - " + inputKey);
    }

    // Кнопка начать кодировать файл
    @FXML
    protected void coderButtonClick() {
        System.out.println("coderButtonClick() - click");

        // Получаем введённый текст из текстового поля inputFieldKey
        String inputText = inputField.getText();
        System.out.println("Введённый текст: " + inputText);

        try{
            FileWriter fileWriter = new FileWriter("coderText.txt");
            fileWriter.write("Тест строки");
            fileWriter.flush();
        }catch (IOException exception){
            throw new RuntimeException();
        }

    }
}
