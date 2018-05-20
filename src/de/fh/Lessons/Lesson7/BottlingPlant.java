package de.fh.Lessons.Lesson7;

public class BottlingPlant implements Runnable{

    //Attributes
    private Conveyor conveyor;
    private int speed;
    public boolean terminate;

    //Constructor
    public BottlingPlant(Conveyor conveyor) {
        this.conveyor = conveyor;
        this.terminate = true;
    }

    //Methods
    @Override
    public void run() {
        while(terminate) {
            Bottle b = new Bottle();
            if(!conveyor.isOverloaded()) {
                conveyor.load(b);
                System.out.println("Abfuellanlage: Neue Flasche abgefuellt");
            }
            else
                System.out.println("Abfuellanlage: Warten, da Foerderband voll.");
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Abfüllanlage: Ausgefallen! " + e.getMessage());
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
