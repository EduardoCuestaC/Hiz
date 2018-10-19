package Events;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Counter implements Subject{
    private ArrayList<Observer> observers = new ArrayList<>();
    private Timer timer = new Timer();
    private double startTime;
    private static Counter instance;

    public static Counter getInstance(){
        if(instance == null)
            instance = new Counter();
        return instance;
    }

    public void restart(){
        startTime = System.nanoTime();
    }

    public void startNew(int ms){
        startTime = System.nanoTime();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                notifyObservers();
            }
        }, ms);
    }

    public double getElapsedTime(){
        return (System.nanoTime()-startTime)/1000000000L;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.updateOnEvent(this);
        }
    }
}
