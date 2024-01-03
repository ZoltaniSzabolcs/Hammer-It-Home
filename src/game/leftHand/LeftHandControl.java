package game.leftHand;

import game.KeyHandler;
import game.SoundControl;

public class LeftHandControl {
    private LeftHandModel leftHandModel;
    private LeftHandView leftHandView;
    private KeyHandler keyHandler;
    private long startTime;
    private boolean putNail;
    private SoundControl soundControl;
    public LeftHandControl(LeftHandModel leftHandModel, LeftHandView leftHandView,KeyHandler keyHandler) {
        this.leftHandModel = leftHandModel;
        this.leftHandView = leftHandView;
        this.keyHandler = keyHandler;
        this.putNail = false;
        this.soundControl = new SoundControl();
    }

    public void run() {
        // Left hand in action
        if(leftHandModel.getCurrentImg() < leftHandModel.getSpriteNumber()){
            double delta = 0;
            long currentTime = System.nanoTime();
            delta = Math.abs(currentTime - startTime);
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
                putNail = true;
                soundControl.playRandomHitSound();
//                System.out.println("Left hand starting action");
            }
        }
    }
    public boolean isInAction(){
        return leftHandModel.getCurrentImg() < leftHandModel.getSpriteNumber();
    }

    public boolean isPutNail() {
        return putNail;
    }

    public void setPutNail(boolean putNail) {
        this.putNail = putNail;
    }
}
