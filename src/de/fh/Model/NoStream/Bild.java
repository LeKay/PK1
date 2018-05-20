package de.fh.Model.NoStream;

public class Bild extends Medium {

    //Attributes
    private String ort;

    //Constructor
    public Bild(String titel, int jahr, String ort) {
        super(titel,jahr);
        this.ort = ort;
    }

    //Methods
    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getId() + ' ' + '"' + getTitel() + '"' + " aufgenommen im Jahr " + getJahr()
                    + " in " + getOrt());
    }

    //Getter and Setter
    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
