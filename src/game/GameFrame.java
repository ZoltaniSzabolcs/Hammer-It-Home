package game;

import game.leftHand.LeftHandControl;
import game.leftHand.LeftHandModel;
import game.leftHand.LeftHandView;
import game.platformNails.PlatformNailsControl;
import game.platformNails.PlatformNailsModel;
import game.platformNails.PlatformNailsView;
import game.rightHand.RightHandControl;
import game.rightHand.RightHandModel;
import game.rightHand.RightHandView;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameFrame extends JFrame {
    private final int screenWidth = 1280;
    private final int screenHeight = 800;
    private KeyHandler keyHandler;
    private String playerName1;
    private String playerName2;
    private PlatformNailsControl platformNailsControl;
    public GameFrame(String playerName1, String playerName2){
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
        System.out.println("The game has begun with: " + playerName1 + " " + playerName2);
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

        PlatformNailsModel platformNailsModel = new PlatformNailsModel(
                new Point(leftHandModel.getHitImg()[0].getWidth() / 4, leftHandModel.getHitImg()[0].getHeight() / 2),
                screenWidth - 455,
                screenWidth - 300,
                10,
                screenWidth);
        PlatformNailsView platformNailsView = new PlatformNailsView(platformNailsModel);
        platformNailsControl = new PlatformNailsControl(leftHandControl, rightHandControl, platformNailsModel, platformNailsView, screenWidth, keyHandler);

        GameModel gameModel = new GameModel(leftHandModel, rightHandModel);
        GameView gameView = new GameView(gameModel, leftHandView, leftHandModel, rightHandView, rightHandModel, platformNailsView, platformNailsModel, this);
        GameControl gameControl = new GameControl(gameModel, gameView, leftHandControl, rightHandControl,platformNailsControl, keyHandler);

        this.addKeyListener(keyHandler);
        this.add(gameView);
        gameView.setBounds(0, 0,screenWidth, screenHeight);

        this.setVisible(true);
        gameControl.startGameThread();
    }

    public void saveAndExit(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("res/highscores.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(playerName1 + " " + platformNailsControl.getLeftHandScore() + " " + playerName2 + " " + platformNailsControl.getRightHandScore());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setVisible(false);
        System.exit(0);
    }
}
