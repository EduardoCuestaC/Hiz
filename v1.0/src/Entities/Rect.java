package Entities;

import java.awt.*;

public class Rect extends Figure{

    public Rect(int x, int y , int w, int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.fillRect(x, y, w, h);
    }
}
