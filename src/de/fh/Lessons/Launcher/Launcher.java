package de.fh.Lessons.Launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void open() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Initiate Lesson8 window
        Parent root = FXMLLoader.load(getClass().getResource("launcher.fxml"));
        primaryStage.setTitle("Lesson8");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
