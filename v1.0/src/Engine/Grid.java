package Engine;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;

import java.util.ArrayList;

import java.lang.Math;

public class Grid {
    private ArrayList<Entity>[][] grid;
    private int cellSize, width, height, lsx = 0, lsy = 0, lex = 0, ley = 0, x=0, y=0;
    private static Grid instance;

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void scrollX(int x){
        this.x += x;
    }

    public static Grid getInstance(){
        if(instance == null)
            instance = new Grid();
        return instance;
    }

    private Grid(){
        width = 103;//width = 26;
        height = 10;
        cellSize = 50;
        grid = new ArrayList[width][height];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                grid[i][j] = new ArrayList<>();
            }
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void add(Entity e){
        int startX = Math.max(x,e.getX()/cellSize);
        int startY = Math.max(y,e.getY()/cellSize);
        int endX = Math.min(width-1, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height-1, (e.getY()+e.getH())/cellSize);
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                grid[i][j].add(e);
            }
        }
    }

    public void delete(Entity e){
        int startX = Math.max(x,e.getX()/cellSize);
        int startY = Math.max(y,e.getY()/cellSize);
        int endX = Math.min(width, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height, (e.getY()+e.getH())/cellSize);
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                grid[i][j].remove(e);
            }
        }
    }



    public void addPlayer(Entity e){

        for(int i = lsx; i<=lex; i++){
            for(int j = lsy; j<=ley; j++){
                grid[i][j].remove(e);
            }
        }

        int startX = Math.max(x,e.getX()/cellSize);
        int startY = Math.max(y,e.getY()/cellSize);
        int endX = Math.min(width, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height, (e.getY()+e.getH())/cellSize);
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                grid[i][j].add(e);
            }
        }
        lsx = startX;
        lsy = startY;
        lex = endX;
        ley = endY;
    }

    public ArrayList<Entity> getSurroundingEntities(Entity e){

        int startX = Math.max(x,(e.getX()-x)/cellSize);
        int startY = Math.max(y,e.getY()/cellSize);
        int endX = Math.min(width-1, (e.getX()+e.getW()-x)/cellSize);
        int endY = Math.min(height-1, (e.getY()+e.getH())/cellSize);

        ArrayList<Entity> collectedEntities = new ArrayList<>();
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                for(Entity entity : grid[i][j]) {
                    if (!collectedEntities.contains(entity))
                        collectedEntities.add(entity);
                }
            }
        }
        return collectedEntities;
    }

    public void checkCollisions(Entity e){
        int type = 4;
        ArrayList<Entity> surrounders = getSurroundingEntities(e);
        for(Entity surrounder : surrounders){
            for(int i = 0; i<4; i++){
                if(surrounder.getBoundingBox().intersects(((Player) e).getBorders()[i])){
                    if(surrounder instanceof Enemy){
                        ((RigidBody) e).react(0);
                        return;
                    }

                    switch(i){
                        //bottom border
                        case 3:
                            if(1<type)
                                type=1;

                            break;

                        //top border
                        case 1:
                            if(2<type)
                                type=2;

                            break;

                        //left or right border
                        default:
                            if(3<type)
                                type=3;

                            break;
                    }
                }
            }
        }
        ((RigidBody) e).react(type);
    }


    /*
    public ArrayList<Entity> getEntitiesInArea(int[] bounds){
        int startX = bounds[0];
        int startY = bounds[1];
        int endX = bounds[2];
        int endY = bounds[3];
        ArrayList<Entity> collectedEntities = new ArrayList<>();
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                collectedEntities.addAll(grid[i][j]);
            }
        }
        return collectedEntities;
    }

    public int[] getCellNumberOfEntity(Entity e){
        int startX = Math.max(0,e.getX()/cellSize);
        int startY = Math.max(0,e.getY()/cellSize);
        int endX = Math.min(width, (e.getX()+e.getW())/cellSize);
        int endY = Math.min(height, (e.getY()+e.getH())/cellSize);
        int[] f = {startX, startY, endX, endY};
        return f;
    }
    */
}
