package de.fh.Lessons.Lesson7;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Conveyor {

    //Attributes
    private Queue<Bottle> bottles;

    //Constructor
    public Conveyor() {
        bottles = new PriorityBlockingQueue<>();
    }

    //Methods
    public void load(Bottle b) {
        bottles.add(b);
    }

    public Bottle withdraw() {
        return bottles.poll();
    }

    public boolean isEmpty() {
        return bottles.isEmpty();
    }

    public boolean isOverloaded() {
        return bottles.size() == 50;
    }

}
