package Entities;

import Engine.*;
import Events.*;


import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity implements Observer, RigidBody, Subject {
    private Figure figure;

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    private Sprite sprite;
    private Rectangle[] borders = {new Rectangle(x+w, y, 1, h),
                                    new Rectangle(x, y-1, w, 1),
                                    new Rectangle(x-1, y,1, h),
                                    new Rectangle(x, y+h, w, 1)};

    private PlayerState controllable = new ControllablePlayerState(this);
    private int lastType = 100;
    private ArrayList<Observer> observers = new ArrayList<>();

    public PlayerState getControllable() {
        return controllable;
    }

    public PlayerState getFalling() {
        return falling;
    }

    public PlayerState getJumping() {
        return jumping;
    }

    private PlayerState falling = new FallingPlayerState(this);
    private PlayerState jumping = new JumpingPlayerState(this);
    private PlayerState current;
    private Producer producer;

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    private Buffer buffer = new Buffer();

    public Buffer getBuffer() {
        return buffer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void setCurrent(PlayerState state){
        current = state;
    }

    public Player(){
        KeySubject.getInstance().subscribe(this);
        current = controllable;
    }

    @Override
    public void setX(int x){
        this.x = x;
        boundingBox.setBounds(this.x, y, w, h);
        updateBorders();
        figure.setX(this.x);
    }

    @Override
    public void setY(int y) {
        this.y = y;
        boundingBox.setBounds(x, this.y, w, h);
        updateBorders();
        figure.setY(this.y);
    }

    @Override
    public void setW(int w) {
        this.w = w;
        boundingBox.setBounds(x, y, this.w, h);
        updateBorders();
        figure.setW(this.w);
    }

    @Override
    public void setH(int h) {
        this.h = h;
        boundingBox.setBounds(x, y, w, this.h);
        updateBorders();
        figure.setH(this.h);
    }

    @Override
    public void update() {
        Grid.getInstance().checkCollisions(this);
        if(y>500) {
            notifyObservers();
            //return;
        }
        int a;
        try {
            if(!buffer.isEmpty()) {
                a = buffer.get();
                setY(getY() + a);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void updateBorders(){
        borders[0].setBounds(x+w, y, 1, h);
        borders[1].setBounds(x, y-1, w, 1);
        borders[2].setBounds(x-1, y,1, h);
        borders[3].setBounds(x, y+h, w, 1);
    }

    public Rectangle[] getBorders(){
        return borders;
    }

    @Override
    public void render(Graphics g) {
        figure.render(g);
        //sprite.render(g);
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == KeySubject.getInstance())
            current.jump();
    }

    @Override
    public void react(int type) {
        if(type != lastType){
            System.out.println("type is: "+type);
            lastType = type;
            switch(type){
                case 1:
                    current.reactToFloor();
                    break;
                case 2:
                    current.reactToCeiling();
                    break;
                case 3:
                    current.reactToWall();
                    break;
                case 4:
                    current.reactToAir();
                    break;
            }
        }
    }

    public void changeToControllable(){
        current.changeToControllable();
    }

    public void changeToJumping(){
        current.changeToJumping();
    }

    public void changeToFalling(){
        current.changeToFalling();
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
}
