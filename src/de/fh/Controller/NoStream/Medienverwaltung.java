package de.fh.Controller.NoStream;

import de.fh.Model.NoStream.Medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Medienverwaltung {

    //Attribute
    private Collection<Medium> medien;

    //Constructor
    public Medienverwaltung() {
        medien = new ArrayList<>();
    }

    //Methods
    public void aufnehmen(Medium medium) {
        medien.add(medium);
    }

    public void zeigeMedien() {
        //Use of an foreach
        for (Medium m : medien)
            m.druckeDaten();
    }

    public void sucheNeuesMedium() {
        //Use of an Iterator
        Iterator<Medium> iterator = medien.iterator();
        //Secure if Collection is empty
        if(iterator.hasNext()) {
            //Assign the first entry
            Medium youngestMedium = iterator.next();
            while(iterator.hasNext()){
                Medium m = iterator.next();
                if(youngestMedium.alter() > m.alter()) {
                    youngestMedium = m;
                }
            }
            youngestMedium.druckeDaten();
        }
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
}
