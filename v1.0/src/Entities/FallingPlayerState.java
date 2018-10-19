package Entities;

import Events.Subject;

public class FallingPlayerState extends PlayerState{
    public FallingPlayerState(Player player){
        this.player = player;
    }
    @Override
    public void jump() {

    }

    @Override
    public void changeToControllable() {
        System.out.println("fc");
        player.setCurrent(player.getControllable());
    }

    @Override
    public void changeToFalling() {

    }

    @Override
    public void changeToJumping() {

    }

    @Override
    public void reactToFloor() {
        player.getProducer().stop();
        player.changeToControllable();
    }

    @Override
    public void reactToCeiling() {

    }

    @Override
    public void reactToWall() {

    }

    @Override
    public void reactToAir() {

    }
}
