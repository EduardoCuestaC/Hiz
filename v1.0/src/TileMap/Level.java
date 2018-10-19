package TileMap;

import Engine.Grid;
import Entities.Tile;

import java.awt.*;
import java.util.ArrayList;

public class Level {
    private ArrayList<Tile> tiles;
    private int x = 0, y = 0;

    public int getX() {
        return x;
    }

    public void scrollX(int x) {
        for(Tile tile : tiles)
            tile.setX(tile.getX()+x);
        Grid.getInstance().scrollX(-1);
    }

    public int getY() {
        return y;
    }

    public void scrollY(int y) {
        this.y = y;
        for(Tile tile : tiles)
            tile.setY(tile.getY()+y);
    }

    public void setTilemap(TileMap t){
        tiles = t.parseTiles();
    }

    public void update(){

    }

    public void render(Graphics g){
        if(tiles != null){
            for(Tile tile : tiles)
                tile.render(g);
        }
    }

    public ArrayList<Tile> getTiles(){
        return tiles;
    }

}
