package de.fh.Lessons.Lesson2;

import de.fh.Controller.NoStream.Medienverwaltung;
import de.fh.Model.NoStream.Audio;
import de.fh.Model.NoStream.Bild;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lesson2 {

    public static void start() {
        try {
            new Lesson2().display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display() throws IOException {

        //Initiate Lesson 2 Window
        Parent root = FXMLLoader.load(getClass().getResource("lesson2.fxml"));
        Stage window = new Stage();
        window.setTitle("Lesson 2");
        window.setScene(new Scene(root));
        window.show();

        //Print to Console
        //Initiate data
        Audio track1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
        Bild pic1 = new Bild("Gebaeude FB Informatik", 2014, "Dortmund");

        System.out.println("\n\nAUSGABE PRAKTIKUMSBLATT 2: \n");

        Medienverwaltung medienverwaltung = new Medienverwaltung();

        medienverwaltung.aufnehmen(track1);
        medienverwaltung.aufnehmen(pic1);
        System.out.println("Aufruf von zeigeMedien():");
        medienverwaltung.zeigeMedien();
        System.out.println("\nAufruf von sucheNeuesMedium():");
        medienverwaltung.sucheNeuesMedium();
        System.out.println("\nAufruf von berechneErscheinungsJahr():");
        System.out.println("Durchschnittsliches Erscheinungjahr: " + medienverwaltung.berechneErscheinungsJahr());
    }

}
