package Events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MouseSubject implements Subject, MouseListener{
    private List<Observer> observers = new ArrayList<>();
    private List<Observer> toAdd = new ArrayList<>();
    protected int[] state;
    private static MouseSubject instance;

    public static int CLICKED = 1, PRESSED = 2, RELEASED = 3;


    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

    public void subscribe(Observer observer){
        toAdd.add(observer);
    }

    public void notifyObservers(){
        if(toAdd.size()==3)
            observers.clear();
        observers.addAll(toAdd);
        toAdd.clear();
        for(Observer observer : observers)
            observer.updateOnEvent(this);

    }



    private MouseSubject(){
        state =  new int[3];
    }

    public static MouseSubject getInstance(){
        if(instance == null)
            instance = new MouseSubject();
        return instance;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        state[0] = e.getX();
        state[1] = e.getY();
        state[2] = PRESSED;
        notifyObservers();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}