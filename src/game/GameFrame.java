package game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public final int screenWidth = 800;
    public final int screenHeight = 600;
    public GameFrame(){
        this.setLayout(new GridLayout(1, 1));
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(219, 221,198));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setResizable(false);
        this.setTitle("Hammer It Home");
        this.setLocationRelativeTo(null);

        GameModel gameModel = new GameModel(new LeftHandModel(100, 300), new RightHandModel(100,300));
        GameView gameView = new GameView(gameModel);
        GameControl gameControl = new GameControl(gameModel, gameView);
        add(gameView);
        new Thread(gameControl).start();

        this.setBounds(256, 256, screenWidth, screenHeight);
        this.setVisible(true);

        this.setVisible(true);
    }
}
