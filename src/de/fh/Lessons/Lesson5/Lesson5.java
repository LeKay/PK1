package de.fh.Lessons.Lesson5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lesson5 {

    public static void start() {
        try {
            new Lesson5().display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display() throws IOException {
        //Initiate Lesson8 window
        Parent root = FXMLLoader.load(getClass().getResource("lesson5.fxml"));
        Stage window = new Stage();
        window.setTitle("Lesson 5");
        window.setScene(new Scene(root));
        window.show();
    }
}
