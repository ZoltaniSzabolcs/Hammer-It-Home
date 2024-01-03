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

    public GameView(GameModel gameModel, LeftHandView leftHandView, LeftHandModel leftHandModel, RightHandView rightHandView, RightHandModel rightHandModel, PlatformNailsView platformNailsView, PlatformNailsModel platformNailsModel) {
        this.gameModel = gameModel;
        this.leftHandView = leftHandView;
        this.leftHandModel = leftHandModel;
        this.rightHandView = rightHandView;
        this.rightHandModel = rightHandModel;
        this.platformNailsView = platformNailsView;
        this.platformNailsModel = platformNailsModel;
        this.setBackground(new Color(219, 221, 198));
        this.setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        leftHandView.draw(g);
        platformNailsView.draw(g);
        rightHandView.draw(g);
    }
}
