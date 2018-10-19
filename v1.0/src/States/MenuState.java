package States;

import Events.Observer;
import GUIElements.PButton;

import java.awt.*;

public class MenuState extends GameState {

    private Observer externalSubscriptor;
    private boolean once = false;
    private PButton pbl1;
    private PButton pbl2;

    public void setExternalSubscriptor(Observer externalSubscriptor) {
        this.externalSubscriptor = externalSubscriptor;
    }


    public MenuState(){
        pbl1 = new PButton(300, 200, "L1");
        pbl2 = new PButton(300, 300, "L2");
    }

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToMenu() {

    }

    @Override
    public void changeToPlay() {
        context.setCurrent(context.getPlay());
    }

    @Override
    public void gameUpdate() {
        if(!once){
            pbl1.subscribe(externalSubscriptor);
            pbl2.subscribe(externalSubscriptor);
            once = true;
        }
    }

    @Override
    public void gameRender(Graphics g) {
        pbl1.render(g);
        pbl2.render(g);
    }
}
