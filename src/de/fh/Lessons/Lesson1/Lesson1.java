package de.fh.Lessons.Lesson1;

import de.fh.Model.NoStream.Audio;
import de.fh.Model.NoStream.Bild;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lesson1 {

    public static void start() {
        try {
            new Lesson1().display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display() throws IOException {

        //Initiate Lesson 1 Window
        Parent root = FXMLLoader.load(getClass().getResource("lesson1.fxml"));
        Stage window = new Stage();
        window.setTitle("Lesson 1");
        window.setScene(new Scene(root));
        window.show();

        //Print to Console
        System.out.println("\n\nAUSGABE PRAKTIKUMSBLATT 1: \n");

        System.out.println("Anlegen einer Audio und Bild Datei sowie Aufruf von druckeDaten():");
        Audio track1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
        Bild pic1 = new Bild("Gebaeude FB Informatik", 2014, "Dortmund");

        track1.druckeDaten();
        pic1.druckeDaten();

        System.out.println("\nAufruf von alter():");
        System.out.println('"' + track1.getTitel() + '"' + " ist " + track1.alter() + " Jahre alt");
    }

}
