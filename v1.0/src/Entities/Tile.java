package Entities;

import Engine.Grid;

import java.awt.*;

public class Tile extends Entity{

    public Tile(int x, int y, int w, int h)
    {
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        Grid.getInstance().add(this);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x,y,w,h);
    }
}
