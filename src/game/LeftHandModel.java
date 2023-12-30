package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LeftHandModel {
    private int width;
    private int height;
    private BufferedImage hitImg[];
    public LeftHandModel(int width, int height){
        this.width = width;
        this.height = height;
        hitImg = new BufferedImage[5];
        try {
            hitImg[0] = ImageIO.read(new File("res/leftHand/put01.png"));
            hitImg[1] = ImageIO.read(new File("res/leftHand/put02.png"));
            hitImg[2] = ImageIO.read(new File("res/leftHand/put03.png"));
            hitImg[3] = ImageIO.read(new File("res/leftHand/put04.png"));
            hitImg[4] = ImageIO.read(new File("res/leftHand/put05.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public BufferedImage getImg(int i){
        if(i < 5){
            return hitImg[i];
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
