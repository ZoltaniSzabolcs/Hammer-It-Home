package game.leftHand;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LeftHandModel {
    private int width;
    private int height;
    private BufferedImage hitImg[];
    private int currentImg;
    private long timing[];

    public LeftHandModel(int width, int height) {
        this.width = width;
        this.height = height;
        hitImg = new BufferedImage[5];
        try {
            hitImg[0] = ImageIO.read(new File("res/leftHand/put01.png"));
            hitImg[1] = ImageIO.read(new File("res/leftHand/put02.png"));
            hitImg[2] = ImageIO.read(new File("res/leftHand/put03.png"));
            hitImg[3] = ImageIO.read(new File("res/leftHand/put04.png"));
            hitImg[4] = ImageIO.read(new File("res/leftHand/put05.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int frameTime = 16700000;
        this.timing = new long[hitImg.length];
        timing[0] = frameTime * 1;
        timing[1] = frameTime * 2;
        timing[2] = frameTime * 1;
        timing[3] = frameTime * 1;
        timing[4] = frameTime * 1;
        currentImg = hitImg.length;
    }

    public BufferedImage[] getHitImg() {
        return hitImg;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpriteNumber() {
        return hitImg.length;
    }

    public int getCurrentImg() {
        return currentImg;
    }

    public void setCurrentImg(int currentImg) {
        this.currentImg = currentImg;
    }

    public long[] getTiming() {
        return timing;
    }
}
