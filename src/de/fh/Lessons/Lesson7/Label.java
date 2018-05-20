package de.fh.Lessons.Lesson7;

public class Label {

    //Attributes
    private String type;
    private int bestBefore;

    //Constructor
    public Label(String type, int bestBefore) {
        this.type = type;
        this.bestBefore = bestBefore;
    }

    //Getter and Setter
    public String getType() {
        return type;
    }
    public int getBestBefore() {
        return bestBefore;
    }

}
