package Entities;

import Engine.Producer;
import Events.Subject;

public abstract class PlayerState {
    protected Player player;
    public abstract void jump();
    public abstract void changeToControllable();
    public abstract void changeToFalling();
    public abstract void changeToJumping();
    public abstract void reactToFloor();
    public abstract void reactToCeiling();
    public abstract void reactToWall();
    public abstract void reactToAir();
}
