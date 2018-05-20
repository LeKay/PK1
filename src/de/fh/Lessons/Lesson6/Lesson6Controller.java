package de.fh.Lessons.Lesson6;

import de.fh.Controller.WithStream.Medienverwaltung;
import de.fh.Lessons.Lesson6.Timer.Zeitansage;
import de.fh.Model.WithStream.Audio;
import de.fh.Model.WithStream.Bild;
import de.fh.Model.WithStream.Medium;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Lesson6Controller {

    //Attributes
    public AnchorPane window;
    public Medienverwaltung mv;

    //Constructor
    public Lesson6Controller() {
        mv = new Medienverwaltung();
        //Fill mv with mock data
        Audio track1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
        Bild pic1 = new Bild("Gebaeude FB Informatik", 2014, "Dortmund");
        mv.aufnehmen(track1);
        mv.aufnehmen(pic1);
    }

    //Timer
    public void startTimer() {
        Zeitansage.start();
    }

    //Menu Methods
    public void save() {
        //Create File
        try {
            FileOutputStream fileOut = new FileOutputStream("data.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for( Medium m : mv.getMedien() ) {
                out.writeObject(m);
                out.reset();
            }
            out.close();
            fileOut.close();
        } catch(IOException e) {
            System.out.println("Unable to save: " + e.getMessage());
        }
    }

    public void load(){
        try {
            FileInputStream fileIn = new FileInputStream("data.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Medium> list = new LinkedList<>();
            while(true) {
                try {
                    Medium m = (Medium) in.readObject();
                    m.druckeDaten(System.out);
                    list.add(m);
                } catch(EOFException e) {
                    break;
                }
            }
            this.mv.setMedien(list);
            in.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Unable to load File: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Medienverwaltung class not found: " + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Cannot convert SaveFile to Object: " + e.getMessage());
        }
    }

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
