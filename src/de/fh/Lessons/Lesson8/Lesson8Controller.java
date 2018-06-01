package de.fh.Lessons.Lesson8;

import de.fh.Controller.L8.Medienverwaltung;
import de.fh.Lessons.Lesson8.Dialogs.PictureInputDialog;
import de.fh.Model.WithStream.Audio;
import de.fh.Model.WithStream.Bild;
import de.fh.Model.WithStream.Medium;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class Lesson8Controller implements IMvDAO{

    //Attributes
    public AnchorPane window;
    public Medienverwaltung mv;
    public DialogPane dialogPane;

    //Constructor
    public Lesson8Controller() {
        mv = new Medienverwaltung();
        //Fill mv with mock data
        Audio track1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
        Bild pic1 = new Bild("Gebaeude FB Informatik", 2014, "Dortmund");
        mv.aufnehmen(track1);
        mv.aufnehmen(pic1);
    }


    //Methods
    @Override
    public void speichern(List<Medium> liste) throws PersistenzException {
        //Create File
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"));
            out.writeObject(mv.getMedien());
            out.close();
        } catch(IOException e) {
            throw new PersistenzException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Medium> laden() throws PersistenzException {
        List<Medium> list;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.bin"));
            list = (List<Medium>) in.readObject();
            in.close();
        } catch (Exception e) {
            throw new PersistenzException(e.getMessage(), e.getCause());
        }
        //set the idCounter
        Medium.setIdCounter(list.size());
        return list;
    }

    //Menu Methods
    public void save() {
        try {
            speichern(mv.getMedien());
        } catch (PersistenzException e) {
            System.out.println("Unable to Save Medialist: " + e.getMessage());
        }
    }

    public void load() {
        try {
            mv.setMedien(laden());
        } catch (PersistenzException e) {
            System.out.println("Unable to Load Medialist: " + e.getMessage());
        }
    }

    public void close() {
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }

    public void addPicture() throws IOException{
        PictureInputDialog dialog = new PictureInputDialog();
        Optional<Bild> result = dialog.showAndWait();
        if(result.isPresent())
            mv.aufnehmen(result.get());
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
