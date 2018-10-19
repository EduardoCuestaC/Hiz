package States;

import Game.GameContext;

import java.awt.*;

public abstract class GameState {
    GameContext context;
    public abstract void stopGame();
    public abstract void changeToMenu();
    public abstract void changeToPlay();
    public abstract void gameUpdate();
    public abstract void gameRender(Graphics g);
    public void setGameContext(GameContext context){
        this.context = context;
    }
}
