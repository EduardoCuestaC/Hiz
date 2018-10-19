package Sound;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import javax.sound.sampled.*;

public class SoundLoader {
    private static SoundLoader instance;
    private HashMap<String, Clip> sounds = new HashMap<>();


    private SoundLoader(){
        String[] list = {"dog", "chicken", "jump", "music"};
        for(String name : list)
            sounds.put(name, load("src/SoundFiles/"+name+".wav"));
    }

    public Clip getClip(String name){
        return (Clip) sounds.getOrDefault(name, null);
    }

    public static SoundLoader getInstance(){
        if(instance==null)
            instance = new SoundLoader();
        return instance;
    }


    public Clip load(String path){

        Clip c = null;
        try{
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
            c = AudioSystem.getClip();
            c.open(stream);
            stream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
