package GUIElements;

import Entities.Entity;
import Events.MouseSubject;
import Events.Observer;
import Events.Subject;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PButton extends Entity implements Subject, Observer{
    private String text;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public String getText() {
        return text;
    }

    public PButton(int x, int y, String text){
        setX(x);
        setY(y);
        setW(100);
        setH(40);
        this.text = text;
        MouseSubject.getInstance().subscribe(this);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, w, h);
        g.setColor(Color.white);
        g.drawString(text, x+20, y+30);
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers)
            observer.updateOnEvent(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == MouseSubject.getInstance()){
            if(boundingBox.contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1])){
                System.out.println("asdf");
                notifyObservers();
            }
        }
    }
}
