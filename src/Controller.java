import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    // обработка событий в файле .fxml
    File file;
    @FXML
    private Button button;

    @FXML
    protected void onOpenFileButtonClick() {

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

    @FXML
    protected void onEncryptButtonClick() {

        // ПО НАЖАТИЮ НА КНОПКУ "Ave, Caesar!" ИЗ ИНТЕРФЕЙСА (fxml)
        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onEncryptButtonClick()
        // И ДАЛЬШЕ ЧИСТАЯ Java

        // ВЫЗВАЕМ МЕТОД ШИФРОВАНИЯ, ЧТО ИМЕННО ОН ДЕЛАЕТ - В НЕМ И ОПИСАНО
//        Encryptor.encrypt(file);

    }
}
