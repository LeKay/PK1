package de.fh.Lessons.Lesson6.Timer;

public class Timer extends Thread {

    //Attributes
    private TimerListener listener;
    private boolean active = true;

    //Constructor
    public Timer(TimerListener listener) {
        this.listener = listener;
    }

    //Methods
    public void terminate() {
        active = false;
        System.out.println("Timer wird gestoppt!");
    }

    @Override
    public void run() {
        while(active) {
            listener.signalPerformed();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Timer failed to sleep: " + e.getMessage());
            }
        }
    }


}
