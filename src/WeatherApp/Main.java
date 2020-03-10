package WeatherApp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML ImageView backgroundPane;
    @FXML javafx.scene.layout.Pane Pane;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("WeatherApp.fxml"));
        primaryStage.setTitle("Weather App");
        primaryStage.setScene(new Scene(root, 645, 522));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
