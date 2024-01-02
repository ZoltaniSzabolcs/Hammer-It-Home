package game;

import game.leftHand.LeftHandControl;
import game.leftHand.LeftHandModel;
import game.leftHand.LeftHandView;
import game.rightHand.RightHandControl;
import game.rightHand.RightHandModel;
import game.rightHand.RightHandView;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private final int screenWidth = 800;
    private final int screenHeight = 600;
    private KeyHandler keyHandler;
    public GameFrame(){
        this.setBounds(256, 256, screenWidth, screenHeight);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(219, 221,198));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setFocusable(true);
        this.setResizable(false);
        this.setTitle("Hammer It Home");

        keyHandler = new KeyHandler();

        LeftHandModel leftHandModel = new LeftHandModel(600,300);
        LeftHandView leftHandView = new LeftHandView(leftHandModel);
        LeftHandControl leftHandControl = new LeftHandControl(leftHandModel,leftHandView, keyHandler);

        RightHandModel rightHandModel = new RightHandModel(600,300);
        RightHandView rightHandView = new RightHandView(rightHandModel);
        RightHandControl rightHandControl = new RightHandControl(rightHandModel,rightHandView, keyHandler);

        GameModel gameModel = new GameModel(leftHandModel, rightHandModel);
        GameView gameView = new GameView(gameModel, leftHandView, leftHandModel, rightHandView, rightHandModel);
        GameControl gameControl = new GameControl(gameModel, gameView, leftHandControl, rightHandControl,keyHandler);

        this.addKeyListener(keyHandler);
        this.add(gameView);
        gameView.setBounds(0, 0,screenWidth, screenHeight);

        this.setVisible(true);
        gameControl.startGameThread();
    }
}
