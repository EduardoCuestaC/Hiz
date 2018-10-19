package Entities;

import java.awt.*;

public abstract class Entity {
    protected int x = 0;
    protected int y = 0;
    protected int w = 0;
    protected int h = 0;
    protected Color color;
    public abstract void update();
    public abstract void render(Graphics g);
    protected Rectangle boundingBox = new Rectangle(x, y, w, h);

    public Rectangle getBoundingBox(){
        return boundingBox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        boundingBox.setBounds(this.x, y, w, h);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        boundingBox.setBounds(x, this.y, w, h);
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
        boundingBox.setBounds(x, y, this.w, h);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
        boundingBox.setBounds(x, y, w, this.h);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
