package de.fh.Controller.L8;

import de.fh.Model.WithStream.Medium;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Medienverwaltung {

    //Attribute
    private List<Medium> medien;
    private File file;

    //Constructor
    public Medienverwaltung() {
        medien = new LinkedList<>();
    }

    //Methods
    public void aufnehmen(Medium medium) {
        medien.add(medium);
    }

    public void zeigeMedien(OutputStream stream) {
        //Use of an foreach
        for (Medium m : medien)
            m.druckeDaten(stream);
    }

    public Iterator<Medium> iterator(){
        return medien.iterator();
    }

    public Medium sucheNeuesMedium() {
        //Use of an Iterator
        Iterator<Medium> iterator = iterator();
        Medium youngestMedium = null;
        //Secure if Collection is empty
        if(iterator.hasNext()) {
            //Assign the first entry
            youngestMedium = iterator.next();
            while(iterator.hasNext()){
                Medium m = iterator.next();
                if(youngestMedium.alter() > m.alter()) {
                    youngestMedium = m;
                }
            }
        }
        return youngestMedium;
    }

    public double berechneErscheinungsJahr() {
        double median = 0.0;
        for(Medium m : medien) {
            median += m.getJahr();
        }
        //Secure Devision by 0
        if(medien.size() != 0)
             median = median / medien.size();
        return median;
    }

    public void saveList() {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(file));
            zeigeMedien(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Getter and Setter
    public void setFile(File file){
        this.file = file;
    }
    public List<Medium> getMedien() {
        return medien;
    }
    public void setMedien(List<Medium> medien) {
        this.medien = medien;
    }
}
