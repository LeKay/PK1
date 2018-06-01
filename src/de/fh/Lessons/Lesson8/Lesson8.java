package de.fh.Lessons.Lesson8;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lesson8 {

    public static void start() {
        try {
            new Lesson8().display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display() throws IOException {
        //Initiate Lesson8 window
        Parent root = FXMLLoader.load(getClass().getResource("lesson8.fxml"));
        Stage window = new Stage();
        window.setTitle("Lesson 8");
        window.setScene(new Scene(root));
        window.show();
    }
}
