package game.leftHand;

import game.KeyHandler;

public class LeftHandControl {
    private LeftHandModel leftHandModel;
    private LeftHandView leftHandView;
    private KeyHandler keyHandler;
    private long startTime;
    public LeftHandControl(LeftHandModel leftHandModel, LeftHandView leftHandView, KeyHandler keyHandler) {
        this.leftHandModel = leftHandModel;
        this.leftHandView = leftHandView;
        this.keyHandler = keyHandler;
    }

    public void run() {
        // Left hand in action
        if(leftHandModel.getCurrentImg() < leftHandModel.getSpriteNumber()){
            double delta = 0;
            long currentTime = System.nanoTime();
            delta = Math.abs(startTime - currentTime);
            if(delta > leftHandModel.getTiming()[leftHandModel.getCurrentImg()]){
                leftHandModel.setCurrentImg(leftHandModel.getCurrentImg() + 1);
                startTime = System.nanoTime();
            }
        }
        else{
            // Left hand waits pressing the A key
            if(keyHandler.isLeftHand()){
                startTime = System.nanoTime();
                leftHandModel.setCurrentImg(0);
                run();
                System.out.println("Left hand starting action");
            }
        }
    }

    public LeftHandView getLeftHandView() {
        return leftHandView;
    }
}
