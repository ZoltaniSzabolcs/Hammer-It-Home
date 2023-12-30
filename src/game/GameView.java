package game;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameModel gameModel;
    public GameView(GameModel gameModel){
        this.gameModel = gameModel;
        this.setBackground(new Color(219, 221,198));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
