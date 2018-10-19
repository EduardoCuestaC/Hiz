package TileMap;

import Engine.Grid;
import Entities.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TileMap {
    private int x;
    private int y;

    private int tileSize;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;

    public TileMap(String path, int tileSize){
        this.tileSize = tileSize;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            mapWidth = Integer.parseInt(reader.readLine());
            mapHeight = Integer.parseInt(reader.readLine());
            System.out.println("height = " + mapHeight);
            System.out.println("width = " + mapWidth);
            map = new int[mapHeight][mapWidth];

            String delimiters = " ";
            for(int fila = 0; fila < mapHeight; fila++){
                String line = reader.readLine();
                String[] tokens = line.split(delimiters);
                for (int col = 0; col < mapWidth; col++){
                    map[fila][col] = Integer.parseInt(tokens[col]);

                }
            }
        }catch (Exception e){
            System.out.println("EXC"+e);
        }
    }

    public ArrayList<Tile> parseTiles(){
        ArrayList<Tile> tiles = new ArrayList<>();
        Tile t;
        for (int fila = 0; fila < mapHeight; fila++)
        {
            for (int col = 0; col < mapWidth; col++)
            {
                if(map[fila][col] == 0){

                }
                else if (map[fila][col] == 1){
                    t = new Tile(x + col * tileSize, y + fila * tileSize, tileSize, tileSize);
                    tiles.add(t);
                    Grid.getInstance().add(t);
                }
                else if (map[fila][col] == 2){
                    /*
                    g.setColor(Color.red);
                    g.fillRect(x + col * tileSize, y + fila * tileSize, tileSize, tileSize);
                    */
                }
                else if (map[fila][col] == 3){
                    /*
                    g.setColor(Color.white);
                    g.setColor(Color.red);
                    g.fillOval(x + col * tileSize, y + fila * tileSize, tileSize, tileSize);
                    */
                }

            }
        }
        return tiles;
    }

}
