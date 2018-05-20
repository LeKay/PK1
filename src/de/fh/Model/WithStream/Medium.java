package de.fh.Model.WithStream;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Medium implements Serializable{

    //Attributes
    private int id;
    private String titel;
    private int jahr;
    //counter to increment id
    private static int idCounter = 0;

    //Constructor
    public Medium(String titel, int jahr) {
        this.id = idCounter++;
        this.titel = titel;
        this.jahr = jahr;
    }

    public Medium(){}

    //Methods
    public int alter() {
        return new GregorianCalendar().get(Calendar.YEAR) - jahr;
    }

    public abstract void druckeDaten(OutputStream stream);

    //Getter and Setter
    //Readonly
    public int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public int getJahr() {
        return jahr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
