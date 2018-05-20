package de.fh.Lessons.Lesson4;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Lesson4 {

    public static void start() {
        try {
            new Lesson4().display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display() throws IOException {

        //Setup the input Dialog
        TextInputDialog input = new TextInputDialog("");
        input.setTitle("Lesson 4");
        input.setHeaderText("Erscheinungsjahr");

        //Setup alert Dialog
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message");
        alert.setContentText("Bitte ein gültiges Erscheinungsjahr eingeben");
        alert.setOnCloseRequest(event -> { alert.close();  Lesson4.start(); });

        int result = -1;

        try {
            result = Integer.parseInt(input.showAndWait().get());
        } catch (NumberFormatException | NoSuchElementException e) {
            //NoSuchElementException occurs when the user closes the dialog so it doesn't need to be handled
            if(e instanceof NumberFormatException)
                alert.showAndWait();
        }

        //Initialising result with -1 and checking for it here is bad practise since the user could input -1
        //But since its just to control unnecessary output and you would normally check if the input value
        //is in a valid range (-1 isn't) it should be okay
        if(result != -1) {
            System.out.println("\n\nAUSGABE PRAKTIKUMSBLATT 4:\n");
            System.out.println("Der User gab folgenden Input:");
            System.out.println(result);
        }
    }

}
