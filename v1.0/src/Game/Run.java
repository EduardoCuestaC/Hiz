package Game;

import javax.swing.*;

public class Run {
    public static void main(String[] args){
        GameContext context = new GameContext();
        JFrame window = new JFrame("Hiz");
        GamePanel panel = new GamePanel(context);
        ContextObserver observer = new ContextObserver(context);
        window.getContentPane().add(panel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(panel.getPreferredSize());
        window.setVisible(true);

    }
}
