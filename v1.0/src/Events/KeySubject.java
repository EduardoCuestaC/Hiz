package Events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeySubject implements Subject, KeyListener{
    private List<Observer> observers = new ArrayList<>();
    private List<Observer> toAdd = new ArrayList<>();
    private static KeySubject instance;

    @Override
    public void subscribe(Observer observer){
        toAdd.add(observer);
    }

    @Override
    public void notifyObservers(){
        if(toAdd.size()==3)
            observers.clear();
        observers.addAll(toAdd);
        toAdd.clear();
        for(Observer observer : observers)
            observer.updateOnEvent(this);

    }

    public static KeySubject getInstance(){
        if(instance == null)
            instance = new KeySubject();
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        notifyObservers();

        System.out.println("l->"+observers.size());
    }
}
