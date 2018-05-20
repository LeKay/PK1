package de.fh.Model.NoStream;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Medium {

    //Attributes
    private int id;
    private String titel;
    private int jahr;
    //counter to increment id
    private static final AtomicInteger idCounter = new AtomicInteger(-1);

    //Constructor
    public Medium(String titel, int jahr) {
        this.id = idCounter.incrementAndGet();
        this.titel = titel;
        this.jahr = jahr;
    }

    //Methods
    public int alter() {
        return new GregorianCalendar().get(Calendar.YEAR) - jahr;
    }

    public abstract void druckeDaten();

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
