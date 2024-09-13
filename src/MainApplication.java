
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent panel = FXMLLoader.load(getClass().getResource("cryptoanalyzer.fxml"));

        Scene scene = new Scene(panel, 700, 450);

        primaryStage.setTitle("javafx: Caesar method");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
