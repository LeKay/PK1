package de.fh.Lessons.Lesson7;

import java.util.Calendar;

public class LabelingMachine implements Runnable{

    //Attributes
    private Conveyor conveyor;
    private int speed;
    private boolean terminate;

    //Constructor
    public LabelingMachine(Conveyor conveyor) {
        this.conveyor = conveyor;
        this.terminate = true;
    }

    //Methods
    @Override
    public void run() {
        while(terminate) {
            if(!conveyor.isEmpty()) {
                Bottle b = conveyor.withdraw();
                b.setLabel(new Label("Bier", Calendar.getInstance().get(Calendar.YEAR)+1));
                System.out.print("Etikettiermaschine: ");
                b.printLabel();
                System.out.println();
            } else
                System.out.println("Etikettiermaschine: Warten, da Foerderband leer.");
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Etikettiermaschine: Ausgefallen! " + e.getMessage());
            }
        }
    }

    public void terminate() {
        this.terminate = false;
    }

    //Getter and Setter
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
