package game.leftHand;

import java.awt.*;

public class LeftHandView {
    private LeftHandModel leftHandModel;

    public LeftHandView(LeftHandModel leftHandModel) {
        this.leftHandModel = leftHandModel;
    }

    public void draw(Graphics g) {
//        System.out.println(leftHandModel.getCurrentImg());
        if (leftHandModel.getCurrentImg() < leftHandModel.getSpriteNumber()) {
            g.drawImage(leftHandModel.getHitImg()[leftHandModel.getCurrentImg()], 0, 0, leftHandModel.getHitImg()[leftHandModel.getCurrentImg()].getWidth() / 2, leftHandModel.getHitImg()[leftHandModel.getCurrentImg()].getHeight() / 2, null);
        }
    }
}
