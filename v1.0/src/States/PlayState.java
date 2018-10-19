package States;

import Entities.Player;
import Entities.Rect;
import Game.GameContext;
import Sound.Track;
import TileMap.*;

import java.awt.*;

public class PlayState extends GameState {
    private Level level = new Level();
    private boolean once = false;
    private int iter = 0;
    private Player player;

    public PlayState(){

    }

    @Override
    public void stopGame() {
        context.setCurrent(context.getStopped());
    }

    @Override
    public void changeToMenu() {

    }

    @Override
    public void changeToPlay() {

    }

    @Override
    public void gameUpdate() {
        if(!once){
            player = context.getPlayer();
            level.setTilemap(new TileMap("src/TileMap/"+context.getLevelName()+".txt", 32));
            once = true;
        }
        player.update();
        iter++;
        if(iter%20 == 0){
            level.scrollX(-1);
        }
    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        if(player!=null)
            player.render(g);
        level.render(g);
    }
}
