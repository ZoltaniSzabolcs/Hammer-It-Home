package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RightHandModel {
    private int width;
    private int height;
    private BufferedImage hitImg[];
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
    }
    public BufferedImage getImg(int i){
        if(i < 6){
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
