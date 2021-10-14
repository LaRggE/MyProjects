package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Ignas Mikaliunas 4 grupe 2 pogrupis

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Uzduotis 2");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
