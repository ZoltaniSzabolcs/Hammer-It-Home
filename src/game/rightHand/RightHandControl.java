package game.rightHand;

import game.KeyHandler;
import game.SoundControl;


public class RightHandControl {
    private RightHandModel rightHandModel;
    private RightHandView rightHandView;
    private KeyHandler keyHandler;
    private long startTime;
    private SoundControl soundControl;
    public RightHandControl(RightHandModel rightHandModel, RightHandView rightHandView, KeyHandler keyHandler) {
        this.rightHandModel = rightHandModel;
        this.rightHandView = rightHandView;
        this.keyHandler = keyHandler;
        this.soundControl = new SoundControl();
    }

    public void run() {
        // Right hand in action
        if(rightHandModel.getCurrentImg() < rightHandModel.getSpriteNumber()){
            double delta = 0;
            long currentTime = System.nanoTime();
            delta = Math.abs(currentTime - startTime);
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
                soundControl.playRandomHitSound();
//                System.out.println("Right hand starting action");
            }
        }
    }
    public boolean isHitting(){
        return rightHandModel.getCurrentImg() == 0;
    }
}
