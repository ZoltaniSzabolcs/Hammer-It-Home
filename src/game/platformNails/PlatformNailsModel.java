package game.platformNails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlatformNailsModel {
    private BufferedImage nailImg[];
    private BufferedImage platformImg;
    private BufferedImage lineImg;
    private Point init;
    private int beforeEnd;
    private int end;
    private int platformSpeed;
    private Point platformPosition;
    private int screenWidth;
    private ArrayList<Nail> nails;
    public PlatformNailsModel(Point init, int beforeEnd, int end, int platformSpeed, int screenWidth){
        this.beforeEnd = beforeEnd;
        this.end = end;
        this.platformSpeed = platformSpeed;
        this.screenWidth = screenWidth;
        nailImg = new BufferedImage[3];
        try {
            nailImg[0] = ImageIO.read(new File("res/nail/nail.png"));
            nailImg[1] = ImageIO.read(new File("res/nail/nailedNail.png"));
            nailImg[2] = ImageIO.read(new File("res/nail/wrongNail.png"));
            platformImg = ImageIO.read(new File("res/platform.png"));
            lineImg = ImageIO.read(new File("res/line.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        this.init = new Point(init.x, init.y - nailImg[0].getHeight() / 2);
        nails = new ArrayList<>();
        platformPosition = new Point(-1 * platformImg.getWidth() / 2, init.y);
    }
    protected void addNail(){
        nails.add(new Nail(init));
    }
    protected void removeNail(Nail nail){
        nails.remove(nail);
    }

    public ArrayList<Nail> getNails() {
        return nails;
    }
    public void MoveNail(Nail nail){
        nail.setPosition(new Point(nail.getPosition().x + platformSpeed, nail.getPosition().y));
    }

    public BufferedImage[] getNailImg() {
        return nailImg;
    }

    public BufferedImage getPlatformImg() {
        return platformImg;
    }

    public BufferedImage getLineImg() {
        return lineImg;
    }

    public Point getPlatformPosition() {
        return platformPosition;
    }

    public void setPlatformPosition(Point platformPosition) {
        this.platformPosition = platformPosition;
    }
    public void resetPlatformPosition(){
        this.platformPosition = new Point(platformPosition.x - screenWidth, platformPosition.y);
    }
    public void movePlatformPosition() {
        this.platformPosition.x += platformSpeed;
    }

    public Point getInit() {
        return init;
    }

    public int getBeforeEnd() {
        return beforeEnd;
    }

    public int getEnd() {
        return end;
    }

    public int getPlatformSpeed() {
        return platformSpeed;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
}
