package de.fh.Model.WithStream;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Locale;

public class Audio extends Medium implements Serializable{

    //Attributes
    private String interpret;
    private int dauer;
    static final long serialVersionUID = 42L;

    //Constructor
    public Audio(String titel, int jahr, String interpret, int dauer) {
        super(titel, jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public Audio(){}

    //Methods
    @Override
    public void druckeDaten(OutputStream stream) {
        PrintStream ps = new PrintStream(stream);
        ps.printf(Locale.GERMANY, "ID = " + getId() + '"' + ' ' + getTitel() + '"' + " von " + getInterpret()
                + " aus " + getJahr() + " Spieldauer: " + getDauer() + " sek.\n");
        ps.flush();
    }

    //Getter and Setter
    public String getInterpret() {
        return interpret;
    }

    public int getDauer() {
        return dauer;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }
}
