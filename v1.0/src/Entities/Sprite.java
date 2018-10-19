package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends Entity{
    private BufferedImage image;
    private BufferedImage sheet;
    private boolean hidden = false;

    public void setImage(String imgName){
        sheet = ImageLoader.getInstance().getImage(imgName);
        image = sheet.getSubimage(0, 0, sheet.getWidth(), sheet.getHeight());
        w = image.getWidth();
        h = image.getHeight();
        boundingBox = new Rectangle(x, y, w, h);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if(!hidden)
            g.drawImage(image, x, y, null);
    }

    public void hide(){
        hidden = true;
    }

    public void show(){
        hidden = false;
    }
}
