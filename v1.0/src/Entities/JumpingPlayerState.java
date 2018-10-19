package Entities;

import Engine.Jumper;
import Events.Subject;

public class JumpingPlayerState extends PlayerState {
    public JumpingPlayerState(Player player){
        this.player = player;
    }

    @Override
    public void jump() {

    }

    @Override
    public void changeToControllable() {
        System.out.println("jc");
        player.setCurrent(player.getControllable());
    }

    @Override
    public void changeToFalling() {
        System.out.println("jf");
        player.setCurrent(player.getFalling());
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
        player.getProducer().stop();
        player.setProducer(new Jumper(player.getBuffer(), 0));
        player.getProducer().start();
        player.changeToFalling();
    }

    @Override
    public void reactToWall() {

    }

    @Override
    public void reactToAir() {

    }
}
