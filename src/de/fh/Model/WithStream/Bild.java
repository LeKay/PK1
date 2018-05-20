package de.fh.Model.WithStream;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Locale;

public class Bild extends Medium implements Serializable{

    //Attributes
    private String ort;
    static final long serialVersionUID = 42L;

    //Constructor
    public Bild(String titel, int jahr, String ort) {
        super(titel,jahr);
        this.ort = ort;
    }

    public Bild() {}

    //Methods
    @Override
    public void druckeDaten(OutputStream stream) {
        PrintWriter ps = new PrintWriter(stream);
        ps.printf(Locale.GERMANY, "ID = " + getId() + '"' + ' ' + getTitel() + '"' + " aufgenommen im Jahr " + getJahr()
                    + " in " + getOrt() + "\n");
        ps.flush();
    }

    //Getter and Setter
    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
