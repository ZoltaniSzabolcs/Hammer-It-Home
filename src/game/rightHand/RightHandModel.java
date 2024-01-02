package game.rightHand;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RightHandModel {
    private int width;
    private int height;
    private BufferedImage hitImg[];
    private int currentImg;
    private int timing[];
    public RightHandModel(int width, int height){
        this.width = width;
        this.height = height;
        hitImg = new BufferedImage[6];
        try {
            hitImg[0] = ImageIO.read(new File("res/rightHand/hit01.png"));
            hitImg[1] = ImageIO.read(new File("res/rightHand/hit01Boom.png"));
            hitImg[2] = ImageIO.read(new File("res/rightHand/hit02.png"));
            hitImg[3] = ImageIO.read(new File("res/rightHand/hit03.png"));
            hitImg[4] = ImageIO.read(new File("res/rightHand/hit04.png"));
            hitImg[5] = ImageIO.read(new File("res/rightHand/hit05.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        int frameTime = 16700000;
        this.timing = new int[hitImg.length];
        timing[0] = frameTime;
        timing[1] = frameTime * 9;
        timing[2] = frameTime * 3;
        timing[3] = frameTime * 2;
        timing[4] = frameTime;
        timing[5] = frameTime;
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

    public int[] getTiming() {
        return timing;
    }
}
