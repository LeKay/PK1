package de.fh.Lessons.Lesson5;

import de.fh.Controller.WithStream.Medienverwaltung;
import de.fh.Model.WithStream.Audio;
import de.fh.Model.WithStream.Bild;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.util.Optional;

public class Lesson5Controller {

    //Attributes
    public Medienverwaltung mv;
    public AnchorPane window;

    //Constructor
    public Lesson5Controller() {
        mv = new Medienverwaltung();
        //Fill mv with mock data
        Audio track1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
        Bild pic1 = new Bild("Gebaeude FB Informatik", 2014, "Dortmund");
        mv.aufnehmen(track1);
        mv.aufnehmen(pic1);
    }

    //Menu Methods
    public void close() {
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }

    public void showAllMedia() {
        mv.zeigeMedien(System.out);
    }

    public void saveList() {
        //Setup the input Dialog
        TextInputDialog input = new TextInputDialog("");
        input.setTitle("Medienliste in Datei schreiben");
        input.setHeaderText("Dateipfad");

        //Setup alert Dialog
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message");
        alert.setContentText("Bitte ein gültigen Dateipfad eingeben");
        alert.setOnCloseRequest(event -> { alert.close();  saveList(); });

        Optional<String> result = input.showAndWait();

        if(result.isPresent()){
            File file = new File(result.get());
            if (file.exists()) {
                mv.setFile(file);
                mv.saveList();
            } else {
                alert.showAndWait();
            }
        }
    }

}
