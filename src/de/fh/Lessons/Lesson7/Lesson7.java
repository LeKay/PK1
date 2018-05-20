package de.fh.Lessons.Lesson7;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.NoSuchElementException;

public class Lesson7 {

    public static void start(){
        //Setup the input Dialog
        TextInputDialog input = new TextInputDialog("");
        input.setTitle("Lesson 7");
        input.setHeaderText("Maschinentaktung Abfuellmaschine");

        //Setup alert Dialog
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Message");
        alert1.setContentText("Bitte ein gültige Geschwindigkeit eingeben");
        alert1.setOnCloseRequest(event -> { alert1.close();  Lesson7.start(); });

        int speed1 = -1;

        try {
            speed1 = Integer.parseInt(input.showAndWait().get());
        } catch (NumberFormatException | NoSuchElementException e) {
            //NoSuchElementException occurs when the user closes the dialog so it doesn't need to be handled
            if(e instanceof NumberFormatException)
                alert1.showAndWait();
        }

        input.setTitle("Lesson 7");
        input.setHeaderText("Maschinentaktung Etikettiermaschine");

        int speed2 = -1;

        try {
            speed2 = Integer.parseInt(input.showAndWait().get());
        } catch (NumberFormatException | NoSuchElementException e) {
            //NoSuchElementException occurs when the user closes the dialog so it doesn't need to be handled
            if(e instanceof NumberFormatException)
                alert1.showAndWait();
        }

        Conveyor conveyor = new Conveyor();
        BottlingPlant plant = new BottlingPlant(conveyor);
        LabelingMachine labler = new LabelingMachine(conveyor);

        //Check if values where inputted
        if(speed1 != -1 && speed2 != -1) {
            plant.setSpeed(speed1);
            Thread t1 = new Thread(plant);
            t1.start();
            labler.setSpeed(speed2);
            Thread t2 = new Thread(labler);
            t2.start();

            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Message");
            alert2.setContentText("Getraenkemaschinen herunterfahren");
            alert2.setOnCloseRequest(event -> {
                alert2.close();
                labler.terminate();
                plant.terminate();
            });
            alert2.showAndWait();
        }
    }

}
