package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;



public class ImageLoader {

    private HashMap<String, BufferedImage> images = new HashMap<>();
    private GraphicsConfiguration configuration;
    private static ImageLoader instance;

    private ImageLoader(){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        configuration = environment.getDefaultScreenDevice().getDefaultConfiguration();
        String[] list = {"gato"};
        for(String name : list){
            images.put(name, load("src/Images/"+name.toLowerCase()+".png"));
        }
    }

    public static ImageLoader getInstance() {
        if(instance == null)
            instance = new ImageLoader();
        return instance;
    }


    private BufferedImage load(String path){
        try{
            BufferedImage image = ImageIO.read(new File(path));
            /*
            BufferedImage frame = configuration.createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());
            Graphics2D g = frame.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            return frame;
            */
            return image;
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage getImage(String name){
        return (BufferedImage) images.get(name);
    }
}
