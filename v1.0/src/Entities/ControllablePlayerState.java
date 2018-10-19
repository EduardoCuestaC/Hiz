package Entities;

import Engine.Jumper;
import Engine.Producer;
import Events.KeySubject;
import Events.MouseSubject;
import Events.Subject;
import Sound.SoundPlayer;

public class ControllablePlayerState extends PlayerState {
    public ControllablePlayerState(Player player){
        this.player = player;
    }

    @Override
    public void jump() {
        System.out.println("jumping");
        SoundPlayer.getInstance().playSound("dog", false);
        player.setProducer(new Jumper(player.getBuffer(), -12));
        player.getProducer().start();
        player.changeToJumping();


        /*
        if(subject == MouseSubject.getInstance()){
            if(player.getBoundingBox().contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println("hola");
            if(player.getBorders()[0].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(0);
            if(player.getBorders()[1].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(1);
            if(player.getBorders()[2].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(2);
            if(player.getBorders()[3].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(3);
        }
        */
    }

    @Override
    public void changeToControllable() {

    }

    @Override
    public void changeToFalling() {
        System.out.println("cf");
        player.setCurrent(player.getFalling());
    }

    @Override
    public void changeToJumping() {
        System.out.println("cj");
        player.setCurrent(player.getJumping());
    }

    @Override
    public void reactToFloor() {

    }

    @Override
    public void reactToCeiling() {

    }

    @Override
    public void reactToWall() {

    }

    @Override
    public void reactToAir() {
        player.setProducer(new Jumper(player.getBuffer(), 0));
        player.getProducer().start();
        player.changeToFalling();
    }
}
