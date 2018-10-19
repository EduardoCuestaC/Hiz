package States;

import Engine.Grid;
import Entities.Player;
import Entities.Rect;
import Events.Observer;
import GUIElements.PButton;
import Game.GameContext;
import TileMap.Level;
import TileMap.TileMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StoppedState extends GameState {


    @Override
    public void stopGame() {

    }

    @Override
    public void changeToMenu() {
    }

    @Override
    public void changeToPlay() {

    }

    @Override
    public void gameUpdate() {
    }


    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Fin del juego!", 100, 100);
    }
}
