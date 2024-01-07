package game;

import game.leftHand.LeftHandModel;
import game.rightHand.RightHandModel;

public class GameModel {


    // EVERY PIC IN LEFT AND RIGHT HAND MODEL ARE SCALED WHEN DREW 0.5 (width / 2, height / 2)


    private LeftHandModel leftHandModel;
    private RightHandModel rightHandModel;
    public GameModel(LeftHandModel leftHandModel, RightHandModel rightHandModel){
        this.leftHandModel = leftHandModel;
        this.rightHandModel = rightHandModel;
    }
}
