package game;

import game.leftHand.LeftHandModel;
import game.leftHand.LeftHandView;
import game.platformNails.PlatformNailsModel;
import game.platformNails.PlatformNailsView;
import game.rightHand.RightHandModel;
import game.rightHand.RightHandView;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameModel gameModel;
    private LeftHandView leftHandView;
    private LeftHandModel leftHandModel;
    private RightHandView rightHandView;
    private RightHandModel rightHandModel;
    private PlatformNailsView platformNailsView;
    private PlatformNailsModel platformNailsModel;
    private GameFrame gameFrame;

    public GameView(GameModel gameModel, LeftHandView leftHandView, LeftHandModel leftHandModel, RightHandView rightHandView, RightHandModel rightHandModel, PlatformNailsView platformNailsView, PlatformNailsModel platformNailsModel, GameFrame gameFrame) {
        this.gameModel = gameModel;
        this.leftHandView = leftHandView;
        this.leftHandModel = leftHandModel;
        this.rightHandView = rightHandView;
        this.rightHandModel = rightHandModel;
        this.platformNailsView = platformNailsView;
        this.platformNailsModel = platformNailsModel;
        this.gameFrame = gameFrame;
        this.setBackground(new Color(219, 221, 198));
        this.setDoubleBuffered(true);
        setLayout(null);
        JButton endButton = new JButton("END");
        endButton.setBounds((platformNailsModel.getScreenWidth() - 150) / 2, 25, 150, 75);
        endButton.setBackground(new Color(246, 255, 212));
        endButton.setForeground(Color.BLACK);
        endButton.setBorder(BorderFactory.createLineBorder(new Color(169, 171, 158), 2));
        endButton.setFont(new Font("Arial", Font.BOLD, 36));
        endButton.setFocusable(false);
        endButton.addActionListener(e -> gameFrame.saveAndExit());
        add(endButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        leftHandView.draw(g);
        platformNailsView.draw(g);
        rightHandView.draw(g);
    }
}
