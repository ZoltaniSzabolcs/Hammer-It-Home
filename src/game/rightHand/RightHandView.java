package game.rightHand;

import java.awt.*;

public class RightHandView{
    private RightHandModel rightHandModel;
    public RightHandView(RightHandModel rightHandModel){
        this.rightHandModel = rightHandModel;
    }
    public void draw(Graphics g) {
        if(rightHandModel.getCurrentImg() < rightHandModel.getSpriteNumber()) {
            g.drawImage(rightHandModel.getHitImg()[rightHandModel.getCurrentImg()], 400, 0,rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getWidth() / 2, rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getHeight() / 2, null);
        }
    }
}
