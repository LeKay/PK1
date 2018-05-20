package de.fh.Lessons.Lesson7;

public class Bottle implements Comparable{

    //Attributes
    private Label label;

    //Methods
    public void printLabel() {
        System.out.print(label.getType() + " mindest haltbar bis " + label.getBestBefore());
    }

    //Getter and Setter
    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
