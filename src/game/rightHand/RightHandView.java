package game.rightHand;

import java.awt.*;

public class RightHandView{
    private RightHandModel rightHandModel;
    public RightHandView(RightHandModel rightHandModel){
        this.rightHandModel = rightHandModel;
    }
    public void draw(Graphics g) {
        if(rightHandModel.getCurrentImg() < rightHandModel.getSpriteNumber()) {
//            System.out.println(rightHandModel.getCurrentImg() + " -- " + (1280 - rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getWidth() / 2));
//            System.out.println(rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getWidth());
//            System.out.println(rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getWidth() / 2);
            g.drawImage(rightHandModel.getHitImg()[rightHandModel.getCurrentImg()], 1265 - rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getWidth() / 2, 0,rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getWidth() / 2, rightHandModel.getHitImg()[rightHandModel.getCurrentImg()].getHeight() / 2, null);
        }
    }
}
