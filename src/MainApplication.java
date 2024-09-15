
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    // В этом месте стартуем .fxml
    @Override
    public void start(Stage primaryStage) throws IOException {
//в методе FXMLLoader.load() - даем ссылку на файл .fxml
        Parent panel = FXMLLoader.load(getClass().getResource("cryptoanalyzer.fxml"));

        Scene scene = new Scene(panel, 700, 450);

        primaryStage.setTitle("javafx: Caesar method");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
// метод main() можно не писать, он сработает автоматически
    public static void main(String[] args) {
        launch(args);
    }
}
