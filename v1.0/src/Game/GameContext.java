package Game;
import Entities.Player;
import States.GameState;
import States.StateFactory;

import java.awt.*;
import java.util.ArrayList;

public class GameContext{
    private GameState stopped;
    private GameState setup;
    private GameState play;
    private GameState menu;

    private GameState current;

    private Player player;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    private String levelName;

    public void stopGame(){
        current.stopGame();
    }
    public void changeToMenu(){
        current.changeToMenu();
    }
    public void changeToPlay(){
        current.changeToPlay();
    }
    public void gameUpdate(){
        current.gameUpdate();
    }
    public void gameRender(Graphics g){
        current.gameRender(g);
    }

    public void setCurrent(GameState state){
        current = state;
    }
    public GameState getCurrent(){
        return current;
    }

    public GameState getSetup(){
        return setup;
    }
    public GameState getStopped() {
        return stopped;
    }
    public GameState getPlay(){
        return play;
    }
    public GameState getMenu(){
        return menu;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public GameContext(){
        stopped = StateFactory.getInstance().createState("stopped");
        setup = StateFactory.getInstance().createState("setup");
        play = StateFactory.getInstance().createState("play");
        menu = StateFactory.getInstance().createState("menu");

        stopped.setGameContext(this);
        setup.setGameContext(this);
        play.setGameContext(this);
        menu.setGameContext(this);

        current = setup;
    }

}