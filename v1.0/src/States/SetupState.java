package States;

import Engine.Grid;
import Entities.*;
import Events.Counter;
import Game.GameContext;
import Sound.SoundPlayer;
import Sound.Track;

import java.awt.*;

public class SetupState extends GameState {
    private boolean once = false;
    private Sprite s;

    public SetupState(){
        Counter.getInstance().startNew(3000);
        s = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        s.setImage("gato");
    }

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToMenu() {

        Player player = new Player();
        player.setFigure(new Rect(player.getX(), player.getY(), player.getW(), player.getH()));
        //player.setSprite(s);
        player.setX(200);
        player.setY(410);
        player.setW(40);
        player.setH(40);
        context.setPlayer(player);
        context.setCurrent(context.getMenu());
    }


    @Override
    public void changeToPlay() {

    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void gameRender(Graphics g) {
        if(!once){
            SoundPlayer.getInstance().playSound("music", true);
            once = true;
        }
        g.setColor(Color.black);
        g.drawString("Bienvenido!", 100, 100);
        s.render(g);

    }
}
