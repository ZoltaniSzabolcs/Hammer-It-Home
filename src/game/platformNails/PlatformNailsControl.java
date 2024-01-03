package game.platformNails;

import game.KeyHandler;
import game.leftHand.LeftHandControl;
import game.rightHand.RightHandControl;

import java.awt.*;
import java.util.ArrayList;

public class PlatformNailsControl {
    private LeftHandControl leftHandControl;
    private RightHandControl rightHandControl;
    private PlatformNailsModel platformNailsModel;
    private PlatformNailsView platformNailsView;
    private KeyHandler keyHandler;
    private int screenWidth;

    public PlatformNailsControl(LeftHandControl leftHandControl, RightHandControl rightHandControl, PlatformNailsModel platformNailsModel, PlatformNailsView platformNailsView, int screenWidth, KeyHandler keyHandler) {
        this.leftHandControl = leftHandControl;
        this.rightHandControl = rightHandControl;
        this.platformNailsModel = platformNailsModel;
        this.platformNailsView = platformNailsView;
        this.screenWidth = screenWidth;
        this.keyHandler = keyHandler;
        platformNailsModel.setPlatformPosition(new Point(-1 * platformNailsModel.getPlatformImg().getWidth() / 2, platformNailsModel.getPlatformPosition().y));
    }
    public void putNail(){
        platformNailsModel.addNail();
    }
    private boolean leftHandHavePlatform(){
        if(platformNailsModel.getPlatformPosition().x + platformNailsModel.getPlatformImg().getWidth() / 2  > platformNailsModel.getScreenWidth() &&
                platformNailsModel.getPlatformPosition().x - platformNailsModel.getScreenWidth() < platformNailsModel.getInit().x &&
                platformNailsModel.getPlatformPosition().x - platformNailsModel.getScreenWidth() + platformNailsModel.getPlatformImg().getWidth() / 2  - platformNailsModel.getNailImg()[0].getWidth() / 4> platformNailsModel.getInit().x){
            return true;
        }
        return (platformNailsModel.getPlatformPosition().x < platformNailsModel.getInit().x &&
                platformNailsModel.getPlatformPosition().x + platformNailsModel.getPlatformImg().getWidth() / 2 - platformNailsModel.getNailImg()[0].getWidth() / 4 > platformNailsModel.getInit().x);
    }
    public void run() {
        if(leftHandHavePlatform()){
            keyHandler.setLeftHavePlatform(true);
        }
        else{
            keyHandler.setLeftHavePlatform(false);
        }
        if(leftHandControl.isPutNail()){
            putNail();
            leftHandControl.setPutNail(false);
        }
        if (platformNailsModel.getPlatformPosition().x < screenWidth + platformNailsModel.getPlatformImg().getWidth() / 2){
            platformNailsModel.movePlatformPosition();
//            System.out.println(platformNailsModel.getPlatformPosition());
        }
        else{
            platformNailsModel.resetPlatformPosition();
        }
        ArrayList<Nail> removeNail = new ArrayList<>();
        for (Nail nail :
                platformNailsModel.getNails()) {
            platformNailsModel.MoveNail(nail);
            if(rightHandControl.isHitting() && nail.getPosition().x > platformNailsModel.getBeforeEnd() && nail.getPosition().x < platformNailsModel.getEnd()){

                // Nailed nail

                nail.setCurrentImg(1);
                nail.setPosition(new Point(nail.getPosition().x, platformNailsModel.getInit().y + platformNailsModel.getNailImg()[0].getHeight() / 2 - platformNailsModel.getNailImg()[1].getHeight() / 2));
            }
            if(nail.getPosition().x > platformNailsModel.getEnd() && nail.getCurrentImg() == 0){

                // Wrong Nail

                nail.setCurrentImg(2);
                nail.setPosition(new Point(nail.getPosition().x, platformNailsModel.getInit().y + platformNailsModel.getNailImg()[0].getHeight() / 2 - platformNailsModel.getNailImg()[2].getHeight() / 2+38));
            }
            if(nail.getPosition().x > screenWidth && nail.getCurrentImg() == 0){
                //platformNailsModel.removeNail(nail);
                removeNail.add(nail);
            }
        }
        for (Nail nail :
                removeNail) {
            platformNailsModel.removeNail(nail);
        }
    }
}
