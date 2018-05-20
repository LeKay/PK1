package de.fh.Model.NoStream;

public class Audio extends Medium{

    //Attributes
    private String interpret;
    private int dauer;

    //Constructor
    public Audio(String titel, int jahr, String interpret, int dauer) {
        super(titel, jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    //Methods
    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getId() + '"' + ' ' + getTitel() + '"' + " von " + getInterpret()
                + " aus " + getJahr() + " Spieldauer: " + getDauer() + " sek.");
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
