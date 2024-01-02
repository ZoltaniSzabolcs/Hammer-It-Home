package game;

import game.leftHand.LeftHandModel;
import game.rightHand.RightHandModel;

public class GameModel {
    private LeftHandModel leftHandModel;
    private RightHandModel rightHandModel;
    public GameModel(LeftHandModel leftHandModel, RightHandModel rightHandModel){
        this.leftHandModel = leftHandModel;
        this.rightHandModel = rightHandModel;
    }
}
