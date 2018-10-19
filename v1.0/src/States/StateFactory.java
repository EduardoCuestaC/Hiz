package States;

import java.util.Arrays;
import java.util.HashMap;

public class StateFactory {
    private static StateFactory instance;

    public static StateFactory getInstance(){
        if(instance == null)
            instance = new StateFactory();
        return instance;
    }


    public GameState createState(String type){
        switch(type){
            case "setup":
                return new SetupState();
            case "stopped":
                return new StoppedState();
            case "play":
                return new PlayState();
            case "menu":
                return new MenuState();
            default:
                return null;
        }
    }
}