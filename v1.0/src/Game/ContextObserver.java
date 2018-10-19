package Game;

import Entities.Player;
import Events.Counter;
import Events.Observer;
import Events.Subject;
import GUIElements.PButton;
import States.MenuState;
import States.StoppedState;

public class ContextObserver implements Observer {

    private GameContext context;
    private int transitions;

    public ContextObserver(GameContext context){
        this.context = context;
        Counter.getInstance().subscribe(this);
        ((MenuState) context.getMenu()).setExternalSubscriptor(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == Counter.getInstance()){
            context.changeToMenu();
        }else if(subject instanceof PButton){
            context.getPlayer().subscribe(this);
            context.setLevelName(((PButton) subject).getText());
            context.changeToPlay();

        }else if(subject instanceof Player){
            context.stopGame();
        }
    }
}
