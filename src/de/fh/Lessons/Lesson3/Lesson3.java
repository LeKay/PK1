package de.fh.Lessons.Lesson3;

import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class Lesson3 {

    public static void start() {
        try {
            new Lesson3().display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display() throws IOException {

        //Setup the input Dialog
        TextInputDialog input = new TextInputDialog("");
        input.setTitle("Lesson 3");
        input.setHeaderText("Erscheinungsjahr");

        Optional<String> result = input.showAndWait();

        //Print to Console
        System.out.println("\n\nAUSGABE PRAKTIKUMSBLATT 3: \n");
        System.out.println("Da ich das 3.Blatt nicht vorliegen habe nehme ich aus dem Kontext des 4. Blattes an " +
                "\ndass ein Fenster mit einem Input Dialog erstellt werden soll.\n");
        System.out.println("Der User gab folgenden Input:");
        System.out.println(result.orElse(""));
    }

}
