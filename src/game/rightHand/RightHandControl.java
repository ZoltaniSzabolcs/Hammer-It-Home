package game.rightHand;

import game.KeyHandler;


public class RightHandControl {
    private RightHandModel rightHandModel;
    private RightHandView rightHandView;
    private KeyHandler keyHandler;
    private long startTime;
    public RightHandControl(RightHandModel rightHandModel, RightHandView rightHandView, KeyHandler keyHandler) {
        this.rightHandModel = rightHandModel;
        this.rightHandView = rightHandView;
        this.keyHandler = keyHandler;
    }

    public void run() {
        // Right hand in action
        if(rightHandModel.getCurrentImg() < rightHandModel.getSpriteNumber()){
            double delta = 0;
            long currentTime = System.nanoTime();
            delta = Math.abs(startTime - currentTime);
            if(delta > rightHandModel.getTiming()[rightHandModel.getCurrentImg()]){
                rightHandModel.setCurrentImg(rightHandModel.getCurrentImg() + 1);
                startTime = System.nanoTime();
            }
        }
        else{
            // Right hand waits pressing the L key
            if(keyHandler.isRightHand()){
                startTime = System.nanoTime();
                rightHandModel.setCurrentImg(0);
                run();
                System.out.println("Right hand starting action");
            }
        }
    }
}
